/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.negocio.servlet;

import Exchange.proyecto.persistencia.dao.Email;
import Exchange.proyecto.persistencia.dao.Encriptacioaes;
import Exchange.proyecto.persistencia.dao.ProductoDAO;
import Exchange.proyecto.persistencia.dao.usuarioDao;
import Exchange.proyecto.persistencia.vo.PublicarVO;
import Exchange.proyecto.persistencia.vo.usuariovo;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.jsp.PageContext;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author 57313
 */
@MultipartConfig
public class Controlador_usuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    usuarioDao dao = new usuarioDao();
    usuariovo vo = new usuariovo();
    ProductoDAO pdao = new ProductoDAO();
    Email email = new Email();
    Encriptacioaes encriptacioaes = new Encriptacioaes();
    ArrayList<String> listaerrores = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String url = request.getServletPath();
        HttpSession session = request.getSession();
        switch (url) {
            case "/ingresar":

                ingresar(response, request);

                break;

            case "/regristar":
                regristarse(response, request);

                break;
            case "/inicio":

                usuariovo vo = (usuariovo) session.getAttribute("usuario");
                if (vo == null) {
                    response.sendRedirect(request.getContextPath() + "/Controlador_Errores");
                } else {

                    request.getRequestDispatcher("jsp/Usuario/inicio.jsp").forward(request, response);
                }

                break;
            case "/cerrar":

                session.removeAttribute("usuario");
                response.sendRedirect("index.jsp");
                break;
            case "/editarusuario":

                editar(request, response);

                break;
            case "/clave":
                cambioclave(request, response);
                break;
            case "/consultar":
                consultarusuario(request, response);
                break;
            case "/recuperclave":
                Recuperclave(request, response);

                break;

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void editar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        usuariovo usuario = (usuariovo) session.getAttribute("usuario");
        String mensaje = "El usuario " + usuario.getNombres() + " se ha Actualizado Sus Datos Correctamente";
        vo.setId(Integer.parseInt(request.getParameter("idusuario")));
        vo.setNombres(request.getParameter("nombre"));
        vo.setCorreo(request.getParameter("correo"));
        vo.setTelefono(request.getParameter("telefono"));
        vo.setCiudad_id(Integer.parseInt(request.getParameter("txtciudad")));
        dao.editarUsuario(vo);
        vo = dao.consultarusuario(usuario.getId());
        session.setAttribute("usuario", vo);
        email.actualizardatos(usuario.getCorreo(), mensaje, "Actualización De datos");

    }

    private void ingresar(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        vo.setCorreo(request.getParameter("correo"));
        vo.setPassword(request.getParameter("password"));
        listaerrores.clear();
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(vo.getCorreo());
        if (mather.find() == false) {
            listaerrores.add("El Correo Ingresado es invalido");
        }
        if (dao.consultarrcorreo(vo.getCorreo())) {
            if (dao.consultarclave(vo.getPassword(), vo.getCorreo())) {

            } else {
                listaerrores.add("La Contraseña es incorrecta");
            }
        } else {
            listaerrores.add("El correo no existe");
        }

        if (listaerrores.size() > 0) {
            request.setAttribute("Errorlogin", listaerrores);
            request.getRequestDispatcher("jsp/No_Usuario/Ingreso.jsp").forward(request, response);
        } else if (dao.consultar(vo)) {

            HttpSession session = request.getSession();
            session.setAttribute("usuario", vo);

            response.sendRedirect(request.getContextPath() + "/inicio");
        } else {
            request.getRequestDispatcher("jsp/No_Usuario/Ingreso.jsp").forward(request, response);
        }
    }

    private void regristarse(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        listaerrores.clear();
        vo.setNombres(request.getParameter("txtnombre"));
        vo.setCorreo(request.getParameter("txtcorreo"));
        vo.setPassword(request.getParameter("txtpassword"));
        vo.setTelefono(request.getParameter("txttelefono"));
        vo.setGenero(request.getParameter("sexo"));
        vo.setCiudad_id(Integer.parseInt(request.getParameter("txtciudad")));
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(vo.getCorreo());
        if (vo.getNombres().equals("")) {
            listaerrores.add("El Nombre es obligatorio");
        }
        if (vo.getCorreo().equals("")) {
            listaerrores.add("El Correo es obligatorio");
        }
        if (vo.getPassword().equals("")) {
            listaerrores.add("La Contraseña es obligatorio");
        }
        if (vo.getGenero().equals("")) {
            listaerrores.add("El Telefono es obligatorio");
        }
        if (vo.getGenero().equals("")) {
            listaerrores.add("El Sexo es obligatorio");
        }

        if (dao.consultarrcorreo(vo.getCorreo())) {
            listaerrores.add("El Correo Ya existe");
        }
        if (dao.consultarTelefono(vo.getTelefono())) {
            listaerrores.add("EL Telefono ya Existe");
        }
        if (mather.find() == false) {
            listaerrores.add("El Correo Ingresado es invalido");
        }
        if (listaerrores.size() > 0) {
            request.setAttribute("campos", vo);
            request.setAttribute("listaerrores", listaerrores);
            request.getRequestDispatcher("jsp/No_Usuario/regristar.jsp").forward(request, response);
        } else if (dao.agregar(vo)) {
           

            request.getRequestDispatcher("jsp/No_Usuario/Ingreso.jsp").forward(request, response);
        } else {
            response.sendRedirect("jsp/No_Usuario/regristar.jsp");
        }
    }

    private void consultarusuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        usuariovo usuario = (usuariovo) session.getAttribute("usuario");
        Gson json = new Gson();
        String gson = "";
        String enu = "";
        PrintWriter out = null;

        vo = dao.consultarusuario(usuario.getId());
        gson = json.toJson(vo);
        response.setContentType("application/json");
        out = response.getWriter();
        out.print(gson);
        out.flush();

    }

    private void cambioclave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        usuariovo usuario = (usuariovo) session.getAttribute("usuario");

        String clavevieja = request.getParameter("claveanterior");
        String clavenueva = request.getParameter("clavenueva");
        String confirmar = request.getParameter("confirmarclave");

        try (PrintWriter out = response.getWriter()) {
            listaerrores.clear();
            vo.setCorreo(usuario.getCorreo());
            vo.setPassword(clavenueva);
            vo.setId(usuario.getId());
            if (dao.clave(usuario.getCorreo(), usuario.getId(), clavevieja)) {
                listaerrores.add("*La Clave que ingreso no es correcta");
            }

            if (listaerrores.size() > 0) {

                for (int i = 0; i < listaerrores.size(); i++) {
                    out.println(listaerrores.get(i));
                    out.println("<br>");
                }

            } else {

                
            dao.EditaClave(vo);
                out.println("<h3>Su Clave fue Cambiada</h3>");
            }
        } catch (Exception e) {
        }
    }

    private void Recuperclave(HttpServletRequest request, HttpServletResponse response) {
        String correo = request.getParameter("correo");
        vo = dao.correo(correo);
        try {
            String Desencriptacion = encriptacioaes.desencriptar(vo.getPassword(), vo.getCorreo());
            String mensaje = "Su Contraseña Es " + Desencriptacion;
            email.recuperContraseña(vo.getCorreo(), mensaje, "Recuperación de Clave");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Controlador_usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Controlador_usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Controlador_usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Controlador_usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Controlador_usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Controlador_usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.negocio.servlet;

import Exchange.proyecto.persistencia.dao.Email;
import Exchange.proyecto.persistencia.dao.InteresadosDAO;
import Exchange.proyecto.persistencia.dao.ProductoDAO;
import Exchange.proyecto.persistencia.dao.usuarioDao;
import Exchange.proyecto.persistencia.vo.InteresadosVO;
import Exchange.proyecto.persistencia.vo.PublicarVO;
import Exchange.proyecto.persistencia.vo.usuariovo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 57313
 */
public class Controlador_Interesados extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    InteresadosDAO dao = new InteresadosDAO();
    InteresadosVO ivo = new InteresadosVO();
    ProductoDAO pdao = new ProductoDAO();
    PublicarVO publicarVO = new PublicarVO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = request.getServletPath();
        HttpSession session = request.getSession();
        usuariovo vo = (usuariovo) session.getAttribute("usuario");
        switch (url) {
            case "/eliminarinteresados":
                eliminar(response, request);
                break;
            case "/agregarinteresados":
                agregarinteresados(response, request);
                break;
            case "/Interesados":
                if (vo == null) {
                    response.sendRedirect(request.getContextPath() + "/Controlador_Errores");
                } else {
                    int id = Integer.parseInt(request.getParameter("idproducto"));
                    InteresadosDAO dao = new InteresadosDAO();
                    List<InteresadosVO> interesado = dao.verinteresados(id);
                    request.setAttribute("interesados", interesado);

                    request.getRequestDispatcher("jsp/Usuario/Interesados.jsp").forward(request, response);
                }
                break;
            case "/productoaintercambiar":
                int idusuario = Integer.parseInt(request.getParameter("idusuario"));
                int idinteresado = Integer.parseInt(request.getParameter("idinteresado"));
                int idproducto = Integer.parseInt(request.getParameter("idproducto"));
                if (vo == null) {
                    response.sendRedirect(request.getContextPath() + "/Controlador_Errores");
                } else {

                    publicarVO = pdao.consultarproducto(idproducto);
                    List<PublicarVO> producto = pdao.listarinteresados(idusuario, publicarVO.getPrecioestimado());
                    request.setAttribute("interesado", idinteresado);
                    request.setAttribute("producto", publicarVO);
                    request.setAttribute("usuarioaintercambiar", producto);
                    request.getRequestDispatcher("jsp/Usuario/subasta_1.jsp").forward(request, response);
                }
                break;
            case "/listainteresados":
                Listadeinteresados(request, response);
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

    private void eliminar(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        HttpSession session = request.getSession();
        usuariovo vo = (usuariovo) session.getAttribute("usuario");
        if (vo == null) {
            response.sendRedirect(request.getContextPath() + "/Controlador_Errores");
        } else {
            int idinteresado = Integer.parseInt(request.getParameter("idinteresado"));
            dao.eliminar(idinteresado);
            response.sendRedirect(request.getContextPath() + "/inicio");
        }

    }

    private void agregarinteresados(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        PublicarVO pvo = new PublicarVO();
        usuariovo usuario = new usuariovo();
        usuarioDao usuariodao = new usuarioDao();
        Email email = new Email();
        int idproducto = Integer.parseInt(request.getParameter("idproducto"));
        int idusuario = Integer.parseInt(request.getParameter("idusuario"));
        PublicarVO producto = usuariodao.datosproducto(idproducto);
        pvo.setId_publicar(idproducto);
        usuario.setId(idusuario);
        ivo.setPublicar(pvo);
        ivo.setUsuario(usuario);
        dao.guardarinteresados(ivo);

        if (email.enviarCorreo(producto.getUsuario().getCorreo(), "Tienes un interesado en tu producto " + producto.getNombre(), "Notificación")) {
            System.out.println("si se envio");
        }

    }

    private void Listadeinteresados(HttpServletRequest request, HttpServletResponse response) {

        try (PrintWriter out = response.getWriter()) {

        } catch (Exception e) {
        }
    }

}

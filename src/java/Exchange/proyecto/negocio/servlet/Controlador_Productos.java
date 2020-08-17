/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.negocio.servlet;

import Exchange.proyecto.persistencia.dao.ProductoDAO;
import Exchange.proyecto.persistencia.vo.PublicarVO;
import Exchange.proyecto.persistencia.vo.usuariovo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author 57313
 */
public class Controlador_Productos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    PublicarVO pvo = new PublicarVO();
    ProductoDAO pdao = new ProductoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = request.getServletPath();
        HttpSession session = request.getSession();
        usuariovo vo = (usuariovo) session.getAttribute("usuario");
        switch (url) {
            case "/detalles":
                int idproducto = Integer.parseInt(request.getParameter("idproducto"));
                String precio = pdao.consultarproducto(idproducto).getPrecioestimado();

                pvo.setId_publicar(idproducto);

                if (pdao.detallesproducto(pvo)) {

                    ArrayList<PublicarVO> producto = new ArrayList<>();
                    producto = (ArrayList<PublicarVO>) pdao.productorelacionado(precio);
                    request.setAttribute("producto", pvo);
                    request.setAttribute("r", producto);
                    request.getRequestDispatcher("jsp/No_Usuario/Producto.jsp").forward(request, response);

                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
            case "/producto":
                int producto = Integer.parseInt(request.getParameter("producto"));
                String precios = pdao.consultarproducto(producto).getPrecioestimado();
                pvo.setId_publicar(producto);
                if (vo == null) {
                    response.sendRedirect(request.getContextPath() + "/Controlador_Errores");
                } else if (pdao.detallesproducto(pvo)) {

                    ArrayList<PublicarVO> productos = new ArrayList<>();
                    productos = (ArrayList<PublicarVO>) pdao.productorelacionado(precios);
                    request.setAttribute("producto", pvo);
                    request.setAttribute("r", productos);

                    request.getRequestDispatcher("jsp/Usuario/Detallesproducto.jsp").forward(request, response);

                } else {
                    request.getRequestDispatcher("jsp/Usuario/inicio.jsp").forward(request, response);
                }
                break;
            case "/editarproducto":
                break;
            case "/eliminar":
                eliminarproducto(request, response);

                break;
            case "/publicar":
                nuevoproducto(response, request);
                break;
            case "/listar_producto":
                listarproducto(response, request);
                break;
            case "/publicaciones":
                listarpublicaciones(response, request);
                break;
            case "/Listar_Precio":
                
                break;
            case "/publicarproductos":
                if (vo == null) {
                    response.sendRedirect(request.getContextPath() + "/Controlador_Errores");
                } else {

                    request.getRequestDispatcher("jsp/Usuario/PublicarProducto.jsp").forward(request, response);
                }
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
        String url = request.getServletPath();
        switch (url) {

        }
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

    private void nuevoproducto(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        FileItemFactory file_factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(file_factory);

        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> imgs = new ArrayList<>();

        try {
            List items = sfu.parseRequest(request);
            for (int i = 0; i < items.size(); i++) {
                FileItem item = (FileItem) items.get(i);
                if (!item.isFormField()) {
                    File archivo = new File("C:\\Users\\57313\\Documents\\NetBeansProjects\\exchange\\web\\img\\productos\\" + item.getName());
                    item.write(archivo);
                    imgs.add("img/productos/" + item.getName());
                } else {
                    campos.add(item.getString());
                }
            }
        } catch (Exception ex) {

        }
        ProductoDAO pdao = new ProductoDAO();
        PublicarVO pvo = new PublicarVO();
        pvo.setNombre(campos.get(0));
        pvo.setDescripcion(campos.get(1));
        pvo.setPrecioestimado(campos.get(2));
        pvo.setCantidad(campos.get(3));
        pvo.setMarca(campos.get(4));
        pvo.setImagen1(imgs.get(0));
        pvo.setImagen2(imgs.get(1));
        pvo.setImagen3(imgs.get(2));
        pvo.setId_categoria(Integer.parseInt(campos.get(5)));
        pvo.setId_usuario(id);
        if (pdao.Publicar_producto(pvo)) {

            response.sendRedirect(request.getContextPath() + "/inicio");
        } else {

        }
    }

    private void listarproducto(HttpServletResponse response, HttpServletRequest request) {
        String precio = request.getParameter("precio");
        ArrayList<PublicarVO> producto = new ArrayList<>();
        producto = (ArrayList<PublicarVO>) pdao.productorelacionado(precio);
        try (PrintWriter out = response.getWriter()) {

            for (int i = 0; i < producto.size(); i++) {

                out.println(" <div class=\"col-md-3 col-xs-6\">");
                out.println("<div class=\"product\">");
                out.println(" <div class=\"product-img\">");
                out.println("<img src=\"\" alt=\"\">");
                out.println("<div class=\"product-label\">");
                out.println("<span class=\"sale\">-30%</span>");
                out.println("</div>");
                out.println("</div>");
                out.println("<div class=\"product-body\">");
                out.println(" <p class=\"product-category\"></p>");
                out.println("<p class=\"product-category\"></p>");
                out.println("<h3 class=\"product-name\"><a href=\"#\"></a></h3>");
                out.println("<div class=\"product-btns\">");
                out.println("<h4 class=\"product-price\">$980.00<del class=\"product-old-price\"></del></h4>");
                out.println("<div class=\"product-btns\">");
                out.println("<button class=\"add-to-wishlist\"><i class=\"fa fa-heart-o\"></i><span class=\"tooltipp\">add to wishlist</span></button>");
                out.println("<button class=\"add-to-compare\"><i class=\"fa fa-exchange\"></i><span class=\"tooltipp\">add to compare</span></button>");
                out.println("<button class=\"quick-view\"><i class=\"fa fa-eye\"></i><span class=\"tooltipp\">quick view</span></button>");
                out.println(" </div>");
                out.println("</div>");
                out.println("<div class=\"add-to-cart\">");
                out.println("<button class=\"add-to-cart-btn\"><i class=\"fa fa-shopping-cart\"></i> add to cart</button>");
                out.println("</div>");

            }

        } catch (Exception e) {
        }
    }

    private void eliminarproducto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("ideli"));

        pdao.eliminar_producto(id);
        request.getRequestDispatcher("jsp/Usuario/inicio.jsp").forward(request, response);

    }

    private void listarpublicaciones(HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        usuariovo vo = (usuariovo) session.getAttribute("usuario");

        ArrayList<PublicarVO> producto = new ArrayList<>();
        producto = (ArrayList<PublicarVO>) pdao.listar(vo.getId());
        try (PrintWriter out = response.getWriter()) {
            for (int i = 0; i < producto.size(); i++) {
                out.println(" <div class=\"product-widget\">");
                out.println("<a href=\"producto?producto=" + producto.get(i).getId_publicar() + "\"><div class=\"product-img\">");
                out.println("<img src=\"" + producto.get(i).getImagen1() + "\" alt=\"\">");
                out.println(" </div></a>");
                out.println(" <div class=\"product-body\">");
  
                out.println("  <h3 class=\"product-name\"><a href=\"Interesados?idproducto=" + producto.get(i).getId_publicar() + "\">Ver Interesados</a></h3>");
                out.println("<h4 class=\"product-price\"><span class=\"qty\"></span>" + producto.get(i).getPrecioestimado() + "</h4>");
                out.println("  </div>");
                out.println(" <button class=\"delete\" onclick='mensaje(" + producto.get(i).getId_publicar() + ")'><i class=\"fa fa-close\"></i></button>");
                out.println("</div> ");
            }

        } catch (Exception e) {
        }

    }

}

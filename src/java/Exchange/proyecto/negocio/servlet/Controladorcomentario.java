/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.negocio.servlet;

import Exchange.proyecto.persistencia.dao.ComentariosDao;
import Exchange.proyecto.persistencia.vo.ComentariosVo;
import Exchange.proyecto.persistencia.vo.PublicarVO;
import Exchange.proyecto.persistencia.vo.usuariovo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 57313
 */
public class Controladorcomentario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ComentariosDao cd = new ComentariosDao();
    ComentariosVo comentariosVo = new ComentariosVo();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = request.getServletPath();
        switch (url) {
            case "/comentar":
                comentar(response, request);

                break;
            case "/eliminarcomentario":
                break;
            case "/agregarcomentar":
                agregarcomentario(response, request);
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

    private void comentar(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        int idpublicacion = Integer.parseInt(request.getParameter("idpublicacion"));

        List<ComentariosVo> comentar = cd.listarcomentarios(idpublicacion);
        try (PrintWriter out = response.getWriter()) {

            for (int i = 0; i < comentar.size(); i++) {
                out.println("<li>");
                out.println("<div class=\"review-heading\">");
                out.println("<h5 class=\"name\">" + comentar.get(i).getUsuariovo().getNombres() + "</h5> ");
                out.println("</div>");
                out.println("<div class=\"review-body\">");
                out.println("<p>" + comentar.get(i).getComentario() + "</p>");
                out.println("</div>");
                out.println(" </li>");
            }

        } catch (Exception e) {

        }

    }

    private void agregarcomentario(HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        usuariovo vo = (usuariovo) session.getAttribute("usuario");
        comentariosVo.setComentario(request.getParameter("comentario"));
        comentariosVo.setProducto(Integer.parseInt(request.getParameter("idpublicacion")));
        comentariosVo.setUsuario(vo.getId());
     
        if (cd.comentar(comentariosVo)) {
            
        }

    }

}

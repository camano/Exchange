/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.negocio.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 57313
 */
public class Controlador_Errores extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sesion Caducada</title>");
            out.println("</head>");
            out.println("<style type='text/css'>");
            out.println("h1{\n"
                    + "    text-align: center;\n"
                    + "    color: #1a2537;\n"
                    + "    font-size: 40px;\n"
                    + "    font-family: Arial, Helvetica, sans-serif;\n"
                    + "}");
            out.println("</style>");
            out.println("<style type='text/css'>");
            out.println("h2{\n"
                    + "    text-align: center;\n"
                    + "    color: #5d5d5d;\n"
                    + "    font-size: 30px;\n"
                    + "    font-family: Arial, Helvetica, sans-serif;\n"
                    + "}");
            out.println("</style>");
            out.println("<style type='text/css'>");
            out.println("a {\n"
                    + "  color: #5d5d5d;\n"
                    + "  font-weight: 500;\n"
                    + "  -webkit-transition: 0.2s color;\n"
                    + "  transition: 0.2s color;\n"
                    + "}");
            out.println("</style>");
            out.println("<body>");
            out.println("<center>");
            out.println("<img src='./img/admiracion.png' />");
            out.println("<h1>Cierre de sesion Automatica</h1>");
            out.println("<h2>Vuelva a iniciar sesion</h2>");
            out.println("<button class='primary-btn'><a href='jsp/No_Usuario/Ingreso.jsp'>Iniciar Sesion</a></button>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
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

}

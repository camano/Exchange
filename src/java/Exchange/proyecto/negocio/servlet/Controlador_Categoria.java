/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.negocio.servlet;

import Exchange.proyecto.persistencia.dao.BusquedadDao;
import Exchange.proyecto.persistencia.dao.ProductoDAO;
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
public class Controlador_Categoria extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ProductoDAO pdao = new ProductoDAO();
    BusquedadDao busquedadDao = new BusquedadDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = request.getServletPath();
        HttpSession session = request.getSession();
        usuariovo vo = (usuariovo) session.getAttribute("usuario");
        switch (url) {
            case "/categoria":
                int idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
                String busquedad = request.getParameter("busquedad");

                if (idcategoria != 0) {
                    List<PublicarVO> producto = pdao.listarcategoria(idcategoria);
                    request.setAttribute("listarcategoria", producto);
                    request.getRequestDispatcher("jsp/No_Usuario/Catalogo.jsp").forward(request, response);
                } else {
                    List<PublicarVO> busqueda = busquedadDao.busquedad(busquedad);
                    request.setAttribute("listarcategoria", busqueda);
                    request.getRequestDispatcher("jsp/No_Usuario/Catalogo.jsp").forward(request, response);
                }

                break;
            case "/categoria_Usuario":
                int categoria = Integer.parseInt(request.getParameter("idcategoria"));
                String busqueda = request.getParameter("busquedad");
                String precio = request.getParameter("precio");

                if (vo == null) {
                    response.sendRedirect(request.getContextPath() + "/Controlador_Errores");
                } else if (categoria != 0) {
                    List<PublicarVO> producto = pdao.listarcategoria(categoria);
                    request.setAttribute("listarcategoria", producto);

                    request.getRequestDispatcher("jsp/Usuario/Catalogo.jsp").forward(request, response);
                } else {

                    List<PublicarVO> busquedas = busquedadDao.busquedad(busqueda);

                    request.setAttribute("listarcategoria", busquedas);
                    request.getRequestDispatcher("jsp/Usuario/Catalogo.jsp").forward(request, response);
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

    private void listarCategoria(HttpServletRequest request, HttpServletResponse response) {

    }

}

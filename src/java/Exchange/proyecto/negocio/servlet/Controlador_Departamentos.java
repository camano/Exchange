/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.negocio.servlet;

import Exchange.proyecto.persistencia.dao.CiudadDao;
import Exchange.proyecto.persistencia.dao.departamentoDao;
import Exchange.proyecto.persistencia.vo.CiudadVO;
import Exchange.proyecto.persistencia.vo.DepartamentosVo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xjorg
 */
public class Controlador_Departamentos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public void departamentobox(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**/
        try (PrintWriter out = response.getWriter()) {
            out.println("<option value=1>Selecione un departamento</option>");
            departamentoDao dpdao = new departamentoDao();
            List<DepartamentosVo> ldp = new ArrayList<>();
            ldp = dpdao.departamentos();
            for (int i = 0; i < ldp.size(); i++) {
             out.println("<option value="+ldp.get(i).getIddepartamento()+">"+ldp.get(i).getDescripcion()+"</option>");
            }
        } catch (Exception e) {

        }

    }
   public void municipiobox(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try (PrintWriter out =response.getWriter()){
           int id = Integer.parseInt(request.getParameter("idDep"));
            out.println("<option value=1>Selecione el municipio</option>");
            CiudadDao cdao= new CiudadDao();
            List<CiudadVO> cvo= new ArrayList<>();
            cvo = cdao.ciudades(id);
            for (int i = 0; i < cvo.size(); i++) {
            out.println("<option value="+cvo.get(i).getIdciudad()+">"+cvo.get(i).getDescripcion()+"</option>");
            }
        } catch (Exception e) {
        }
    }
 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("departamentos")) {
            departamentobox(request, response);
        }
       if (action.equalsIgnoreCase("ciudad")) {
            municipiobox(request, response);
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

    private void ciudades(HttpServletRequest request, HttpServletResponse response) {
       try (PrintWriter out =response.getWriter()){
           int id = Integer.parseInt(request.getParameter("idDep"));
            out.println(" <label for=\"exampleFormControlSelect1\">Rol</label>");
            CiudadDao cdao= new CiudadDao();
            List<CiudadVO> cvo= new ArrayList<>();
            cvo = cdao.ciudad();
            for (int i = 0; i < cvo.size(); i++) {
            out.println("<option value="+cvo.get(i).getIdciudad()+">"+cvo.get(i).getDescripcion()+"</option>");
            }
        } catch (Exception e) {
        }
    }

}

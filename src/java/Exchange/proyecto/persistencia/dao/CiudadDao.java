/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.dao;

import Exchange.proyecto.persistencia.conexion.Conexion;
import Exchange.proyecto.persistencia.vo.CiudadVO;
import Exchange.proyecto.persistencia.vo.PublicarVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonathan
 */
public class CiudadDao {
     Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    //metodo para ver las ciudades
      public List ciudades(int idDep) {
        PreparedStatement pst;
        ResultSet rs;
        List<CiudadVO> lista = new ArrayList<>();
        String sql = "SELECT * FROM `ciudad` WHERE departamento_id_departamento="+idDep;
        try {
            pst = con.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                CiudadVO cvo=new CiudadVO();
                cvo.setIdciudad(rs.getInt("id_ciudad"));
                cvo.setDescripcion(rs.getString("ciudad"));
                
                lista.add(cvo);
            }

        } catch (Exception e) {
        }
        return lista;
    }
      public List ciudad() {
        PreparedStatement pst;
        ResultSet rs;
        List<CiudadVO> lista = new ArrayList<>();
        String sql = "SELECT * FROM `ciudad`";
        try {
            pst = con.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                CiudadVO cvo=new CiudadVO();
                cvo.setIdciudad(rs.getInt("id_ciudad"));
                cvo.setDescripcion(rs.getString("ciudad"));
                
                lista.add(cvo);
            }

        } catch (Exception e) {
        }
        return lista;
    }
    
}

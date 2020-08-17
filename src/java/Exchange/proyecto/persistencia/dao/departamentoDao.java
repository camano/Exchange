/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.dao;

import Exchange.proyecto.persistencia.conexion.Conexion;
import Exchange.proyecto.persistencia.vo.CiudadVO;
import Exchange.proyecto.persistencia.vo.DepartamentosVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonathan
 */
public class departamentoDao {
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    //Con este metodo podemos ver todos los departamentos
     public List departamentos() {
        PreparedStatement pst;
        ResultSet rs;
        List<DepartamentosVo> lista = new ArrayList<>();
        String sql = "SELECT * FROM departamento ";
        try {
            pst = con.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                DepartamentosVo dv =new DepartamentosVo();
                dv.setIddepartamento(rs.getInt("id_departamento"));
                dv.setDescripcion(rs.getString("nombre"));
                
                lista.add(dv);
            }

        } catch (Exception e) {
        }
        return lista;
    }
    
}

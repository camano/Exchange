/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.dao;

import Exchange.proyecto.persistencia.conexion.Conexion;
import Exchange.proyecto.persistencia.interfaces.Crudinteresados;
import Exchange.proyecto.persistencia.vo.CiudadVO;
import Exchange.proyecto.persistencia.vo.InteresadosVO;
import Exchange.proyecto.persistencia.vo.PublicarVO;
import Exchange.proyecto.persistencia.vo.usuariovo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonathan
 */
public class InteresadosDAO implements Crudinteresados {

    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List verinteresados(int id) {
        List<InteresadosVO> interesados=new ArrayList<>();
        String query = "SELECT * FROM verInteresados WHERE idproducto="+id;
        try {
            ps=con.getConnection().prepareStatement(query);
           // ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                
                usuariovo usuario=new usuariovo();
                PublicarVO pvo=new PublicarVO();
                InteresadosVO ivo=new InteresadosVO();
                CiudadVO ciudadVO=new CiudadVO();
                ivo.setIdinteresados(rs.getInt("idinteresados"));
                usuario.setId(rs.getInt("idusuario"));
                usuario.setNombres(rs.getString("usuario"));
                pvo.setNombre("nombre");
                pvo.setId_publicar(rs.getInt("idproducto"));
                ciudadVO.setDescripcion("ciudad");
                usuario.setCiudadVO(ciudadVO);
                ivo.setUsuario(usuario);
                ivo.setPublicar(pvo);
                interesados.add(ivo);
            }
            
        } catch (Exception e) {
        }
        
        return interesados;
    }

    @Override
    public void guardarinteresados(InteresadosVO interesadosVO) {
       String query="INSERT INTO `interesados` (idproducto_id,`idusuario_id`) VALUES(?,?)";
        try {
            ps=con.getConnection().prepareStatement(query);
            ps.setInt(1,interesadosVO.getPublicar().getId_publicar());
            ps.setInt(2, interesadosVO.getUsuario().getId());
            if (ps.executeUpdate()==1) {
                
            }
        } catch (SQLException e) {
        }
        con.desconectar();
        
    }

    @Override
    public void eliminar(int id) {
        String query="DELETE FROM interesados WHERE `idinteresados`=?";
        try {
            ps=con.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
        }
        
        con.desconectar();
     
    }
    
    
    public boolean eliminartodo(int id){
          String query="DELETE FROM interesados WHERE `idproducto_id`=?";
        try {
            ps=con.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            if (ps.executeUpdate()==1) {
                return true;
            }
        } catch (Exception e) {
        }
        
        con.desconectar();
        return false;
    }
public boolean consultarinteresados(int id){
    String query="select * from interesados where idinteresados="+id;
    InteresadosVO ivo=new InteresadosVO();
    PublicarVO pvo=new PublicarVO();
    try {
        ps=con.getConnection().prepareStatement(query);
        rs=ps.executeQuery();
       while(rs.next()){
           pvo.setId_publicar(rs.getInt("idproducto"));
           ivo.setPublicar(pvo);
       }
    } catch (Exception e) {
    }
    con.desconectar();
    return false;
}
    
}

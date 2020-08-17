/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.dao;

import Exchange.proyecto.persistencia.conexion.Conexion;
import Exchange.proyecto.persistencia.vo.BusquedadVo;
import Exchange.proyecto.persistencia.vo.CiudadVO;
import Exchange.proyecto.persistencia.vo.PublicarVO;
import Exchange.proyecto.persistencia.vo.usuariovo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 57313
 */
public class BusquedadDao {

    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public void insertarbusquedad(BusquedadVo busquedadVo) {
        String sql = "";
    }

    public List busquedad(String nombre) {
        List<PublicarVO> busquedad = new ArrayList<>();
        String sql = "SELECT * FROM producto INNER JOIN categoria ON producto.`categoria_idcategoria`=categoria.`idcategoria` INNER JOIN usuario ON producto.`usuario_idusuario`=usuario.`idusuario` \n"
                + "WHERE nombre LIKE '%"+nombre+"%' AND disponible=TRUE";
        try {
            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PublicarVO pvo = new PublicarVO();
                pvo.setId_publicar(rs.getInt("idproducto"));
                pvo.setNombre(rs.getString("nombre"));
                pvo.setDescripcion(rs.getString("descripcion"));
                pvo.setPrecioestimado(rs.getString("precio_estimado"));
                pvo.setMarca(rs.getString("marca"));
                pvo.setId_usuario(rs.getInt("usuario_idusuario"));
                pvo.setImagen1(rs.getString("imagen1"));
                pvo.setImagen2(rs.getString("imagen2"));
                pvo.setFecha(rs.getString("FechaPublicación"));

                busquedad.add(pvo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BusquedadDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return busquedad;
    }

}

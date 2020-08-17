/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.dao;

import Exchange.proyecto.persistencia.conexion.Conexion;
import Exchange.proyecto.persistencia.interfaces.crudSolicitud;
import Exchange.proyecto.persistencia.vo.InteresadosVO;
import Exchange.proyecto.persistencia.vo.PublicarVO;
import Exchange.proyecto.persistencia.vo.SolicitudVo;
import Exchange.proyecto.persistencia.vo.subastaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 57313
 */
public class SolicitudDAO implements crudSolicitud {

    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    InteresadosVO ivo = new InteresadosVO();
    PublicarVO pvo = new PublicarVO();
    ProductoDAO pdao = new ProductoDAO();

    @Override
    public void agregarsolicitud(SolicitudVo solicitudVo) {
        String query = "insert into solicitud_intercambio(producto_idproducto,idinteresados_id) values(?,?)";
        try {
            ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, solicitudVo.getPublicarVO().getId_publicar());
            ps.setInt(2, solicitudVo.getInteresadosVO().getIdinteresados());
            ps.execute();

        } catch (Exception e) {
        }
    }

    public subastaVO obtenerproducto(int interesado) throws SQLException {
        int producto1;
        int producto2;
        String sql = "SELECT * FROM `solicitud_intercambio` INNER JOIN interesados "
                + "ON `solicitud_intercambio`.`idinteresados_id`= interesados.`idinteresados` WHERE `idinteresados`=" + interesado;
        ps = con.getConnection().prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            subastaVO vo = new subastaVO();

            producto1 = rs.getInt("producto_idproducto");
            producto2 = rs.getInt("idproducto_id");
            vo.setProducto_idproducto(producto1);
            vo.setProducto_id(producto2);
            return vo;
        }
        return null;
    }

}

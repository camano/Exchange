/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.dao;

import Exchange.proyecto.persistencia.conexion.Conexion;
import Exchange.proyecto.persistencia.interfaces.CrudComentarios;
import Exchange.proyecto.persistencia.vo.ComentariosVo;
import Exchange.proyecto.persistencia.vo.PublicarVO;
import Exchange.proyecto.persistencia.vo.usuariovo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 57313
 */
public class ComentariosDao implements CrudComentarios {

    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();

    //Metodo para Comentar 
    @Override
    public boolean comentar(ComentariosVo comentariosVo) {
        String consulta = "insert into comentarios (comentario,idusuario_id,idproducto_id) values(?,?,?)";
        try {
            ps = con.getConnection().prepareStatement(consulta);
            ps.setString(1, comentariosVo.getComentario());
            ps.setInt(2, comentariosVo.getUsuario());
            ps.setInt(3, comentariosVo.getProducto());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("ERROR" + e);
        }
        con.desconectar();
        return false;

    }

    //Metodo para eliminar comentarios
    @Override
    public boolean eliminar(ComentariosVo comentariosVo) {
        String eliminar = "delete from comentarios where idcomentario=?";
        try {
            ps = con.getConnection().prepareStatement(eliminar);
            ps.setInt(1, comentariosVo.getIdcomentario());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("ERROR" + e);
        }
        con.desconectar();
        return false;
    }

    //metodo para ver los comentarios con el id del producto
    @Override
    public List listarcomentarios(int id) {
        List<ComentariosVo> comentarios = new ArrayList<>();
        String listar = "select * from comentarios inner join usuario on comentarios.idusuario_id=usuario.idusuario\n"
                + "inner join producto on comentarios.idproducto_id=producto.idproducto where idproducto_id=?";
        try {
            ps = con.getConnection().prepareStatement(listar);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ComentariosVo cv = new ComentariosVo();
                usuariovo vo = new usuariovo();
                PublicarVO pvo = new PublicarVO();
                cv.setIdcomentario(rs.getInt("idcomentario"));
                cv.setComentario(rs.getString("comentario"));
                vo.setNombres(rs.getString("usuario"));
                pvo.setNombre("nombre");
            
                cv.setUsuariovo(vo);
                cv.setPublicarVO(pvo);
                comentarios.add(cv);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return comentarios;
    }

    @Override
    public boolean eliminarid(int idproducto) {
        String query = "DELETE FROM comentarios WHERE idproducto_id="+idproducto;
        try {
            ps = con.getConnection().prepareStatement(query);
           
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("ERROR" + e);
        }
        con.desconectar();
        return false;
        }
        
    }

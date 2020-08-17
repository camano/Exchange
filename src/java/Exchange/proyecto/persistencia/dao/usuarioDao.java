/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.dao;

import Exchange.proyecto.persistencia.conexion.Conexion;
import Exchange.proyecto.persistencia.interfaces.Crud;
import Exchange.proyecto.persistencia.vo.CiudadVO;
import Exchange.proyecto.persistencia.vo.PublicarVO;
import Exchange.proyecto.persistencia.vo.usuariovo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonathan
 */
public class usuarioDao implements Crud {

    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int cont = 0;
    ProductoDAO pdao = new ProductoDAO();

    //Cone este metodo podemos ingresar 
    @Override
    public boolean consultar(usuariovo usuario) {
        Encriptacioaes encriptacioaes = new Encriptacioaes();

        try {
            final String claveEncriptacion = usuario.getCorreo();
            String clave = encriptacioaes.encriptar(usuario.getPassword(), claveEncriptacion);
            String sql = "SELECT * FROM usuario INNER JOIN ciudad ON usuario.ciudad_id_ciudad=ciudad.id_ciudad WHERE usuario.correo=? AND usuario.password=?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while (rs.absolute(1)) {
                CiudadVO cvo = new CiudadVO();
                usuario.setId(rs.getInt("idusuario"));
                usuario.setNombres(rs.getString("usuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPassword(rs.getString("password"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCantidad(pdao.countproducto(usuario.getId()));
                cvo.setIdciudad(rs.getInt("id_ciudad"));

                cvo.setDescripcion(rs.getString("ciudad"));

                usuario.setCiudadVO(cvo);
                return true;

            }

        } catch (Exception e) {
            System.out.println("error" + e);
            System.out.println("no se pudo");
        }
        con.desconectar();
        return false;

    }

    //Con este metodo podemos Regristar un usuario
    @Override
    public boolean agregar(usuariovo usuario) {
        PreparedStatement pst = null;
        Encriptacioaes encriptacioaes = new Encriptacioaes();
        try {
            final String claveEncriptacion = usuario.getCorreo();
            String clave = encriptacioaes.encriptar(usuario.getPassword(), claveEncriptacion);
            String sql = "CALL agregarusuario(?,?,?,?,?,?);";

            pst = con.getConnection().prepareCall(sql);

            pst.setString(1, usuario.getNombres());
            pst.setString(2, usuario.getCorreo());
            pst.setString(3, clave);
            pst.setString(4, usuario.getTelefono());
            pst.setString(5, usuario.getGenero());
            pst.setInt(6, usuario.getCiudad_id());

            if (pst.executeUpdate() == 1) {

                return true;
            } else {
                return false;
            }

        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | SQLException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
        }
        con.desconectar();

        return false;
    }

    //Con este metodo podemos Verificar si un usuario existe
    //Con este metodo podemos actualizar los datos del usuario
    public PublicarVO datosproducto(int idusuario) {
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM producto INNER JOIN usuario ON producto.usuario_idusuario=usuario.idusuario WHERE idproducto=" + idusuario;
        try {
            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                PublicarVO producto = new PublicarVO();
                usuariovo usuario = new usuariovo();
                producto.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                producto.setUsuario(usuario);
                return producto;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean consultarrcorreo(String correo) {
        String sql = "select * from usuario where correo='" + correo + "'";

        try {
            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.absolute(1)) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public boolean consultarTelefono(String telefono) {
        String sql = "select * from usuario where telefono='" + telefono + "'";
        try {
            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.absolute(1)) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean consultarclave(String clave, String correo) {
        Encriptacioaes encriptacioaes = new Encriptacioaes();
        try {
            final String claveEncriptacion = correo;
            String claves = encriptacioaes.encriptar(clave, claveEncriptacion);
            String sql = "select * from usuario where password='" + claves + "'";
            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.absolute(1)) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean clave(String correo,int id,String claveantigua) {
        Encriptacioaes encriptacioaes = new Encriptacioaes();
        try {
            final String claveEncriptacion = correo;
            String claves = encriptacioaes.encriptar(claveantigua, claveEncriptacion);
            String sql = "select * from usuario where password=? and idusuario=?";
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, claves);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            if (rs.absolute(1)) {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public usuariovo consultarusuario(int id) {
        usuariovo usuario = new usuariovo();
        try {

            String sql = "SELECT * FROM usuario INNER JOIN ciudad ON usuario.ciudad_id_ciudad=ciudad.id_ciudad WHERE usuario.idusuario=" + id;
            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.absolute(1)) {
                CiudadVO cvo = new CiudadVO();

                usuario.setId(rs.getInt("idusuario"));
                usuario.setNombres(rs.getString("usuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPassword(rs.getString("password"));
                usuario.setTelefono(rs.getString("telefono"));

                cvo.setIdciudad(rs.getInt("id_ciudad"));

                cvo.setDescripcion(rs.getString("ciudad"));

                usuario.setCiudadVO(cvo);
                return usuario;

            }

        } catch (Exception e) {
            System.out.println("error" + e);
            System.out.println("no se pudo");
        }
        con.desconectar();

        return null;
    }

    public usuariovo correo(String id) {
        usuariovo usuario = new usuariovo();
        try {

            String sql = "SELECT * FROM usuario INNER JOIN ciudad ON usuario.ciudad_id_ciudad=ciudad.id_ciudad WHERE usuario.correo='" + id + "'";
            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.absolute(1)) {
                CiudadVO cvo = new CiudadVO();

                usuario.setId(rs.getInt("idusuario"));
                usuario.setNombres(rs.getString("usuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPassword(rs.getString("password"));
                usuario.setTelefono(rs.getString("telefono"));

                cvo.setIdciudad(rs.getInt("id_ciudad"));

                cvo.setDescripcion(rs.getString("ciudad"));

                usuario.setCiudadVO(cvo);
                return usuario;

            }

        } catch (Exception e) {
            System.out.println("error" + e);
            System.out.println("no se pudo");
        }
        con.desconectar();

        return null;
    }

    @Override
    public void editarUsuario(usuariovo usuario) {
        String sql = "update usuario set usuario=?,telefono=?,correo=?,ciudad_id_ciudad=? where idusuario=?";
        try {
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getTelefono());
            ps.setString(3, usuario.getCorreo());
            ps.setInt(4, usuario.getCiudad_id());
            ps.setInt(5, usuario.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void EditaClave(usuariovo usuario) {
        Encriptacioaes encriptacioaes = new Encriptacioaes();
        try {
            final String claveEncriptacion = usuario.getCorreo();
            String clave = encriptacioaes.encriptar(usuario.getPassword(), claveEncriptacion);
            String sql = "CALL `EditaClave`(?,?)";
            ps = con.getConnection().prepareCall(sql);
            ps.setString(1, clave);
            ps.setInt(2, usuario.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
   

}

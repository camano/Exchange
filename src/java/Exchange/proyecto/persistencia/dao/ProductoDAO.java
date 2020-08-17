package Exchange.proyecto.persistencia.dao;

import Exchange.proyecto.persistencia.conexion.Conexion;
import Exchange.proyecto.persistencia.dao.ComentariosDao;
import Exchange.proyecto.persistencia.interfaces.CrudProducto;
import Exchange.proyecto.persistencia.vo.CategoriasVo;
import Exchange.proyecto.persistencia.vo.CiudadVO;
import Exchange.proyecto.persistencia.vo.PublicarVO;
import Exchange.proyecto.persistencia.vo.subastaVO;
import Exchange.proyecto.persistencia.vo.usuariovo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author johan
 */
public class ProductoDAO implements CrudProducto {

    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int cont = 0;

    //Con este Metodo se puede editar la publicación
    @Override
    public boolean editar_producto(PublicarVO p) {
        PreparedStatement pst = null;
        String sql = "update producto set nombre=?,cantidad=?,descripcion=?,precio_estimado=?,marca=?,categoria_idcategoria=? where idproducto=?";
        try {

            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getCantidad());
            pst.setString(3, p.getDescripcion());
            pst.setString(4, p.getPrecioestimado());
            pst.setString(5, p.getMarca());

            pst.setInt(6, p.getId_categoria());

            pst.setInt(7, p.getId_publicar());

            if (pst.executeUpdate() == 1) {

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            con.desconectar();
        }

        return false;
    }

    //Con esta lista podemos Ver los productos de los usuarios
    public List listar(int id) {
        PreparedStatement pst;
        ResultSet rs;
        List<PublicarVO> lista = new ArrayList<>();
        String sql = "SELECT * FROM `verProducto`\n"
                + " WHERE disponible = 1 and `idusuario`=?\n"
                + "ORDER BY idproducto DESC\n"
                + "";
        try {
            pst = con.getConnection().prepareStatement(sql);

            pst.setInt(1, id);

            rs = pst.executeQuery();
            while (rs.next()) {
                PublicarVO pvo = new PublicarVO();
                CiudadVO ciudadVO = new CiudadVO();
                usuariovo vo = new usuariovo();
                pvo.setId_publicar(rs.getInt("idproducto"));
                pvo.setNombre(rs.getString("nombre"));
                pvo.setDescripcion(rs.getString("descripcion"));
                pvo.setPrecioestimado(rs.getString("precio_estimado"));
                pvo.setMarca(rs.getString("marca"));
                pvo.setImagen1(rs.getString("imagen1"));
                ciudadVO.setDescripcion(rs.getString("ciudad"));
                vo.setCiudadVO(ciudadVO);
                pvo.setUsuario(vo);
                lista.add(pvo);
            }

        } catch (Exception e) {
        }
        return lista;
    }

    //Con esta lista podemos ver todas las publicaciones en orden descentente
    public List verproducto() {
        PreparedStatement pst;
        ResultSet rs;
        List<PublicarVO> producto = new ArrayList<>();
        String sql = "SELECT * FROM `verProducto`\n"
                + " WHERE disponible = 1 \n"
                + "ORDER BY idproducto DESC\n"
                + "LIMIT 5";
        try {
            pst = con.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                PublicarVO pvo = new PublicarVO();
                usuariovo vo = new usuariovo();
                CiudadVO cvo = new CiudadVO();
                CategoriasVo categoriasVo = new CategoriasVo();
                pvo.setId_publicar(rs.getInt("idproducto"));
                pvo.setNombre(rs.getString("nombre"));
                pvo.setDescripcion(rs.getString("descripcion"));
                pvo.setPrecioestimado(rs.getString("precio_estimado"));
                pvo.setMarca(rs.getString("marca"));
                pvo.setId_usuario(rs.getInt("usuario_idusuario"));
                pvo.setImagen1(rs.getString("imagen1"));
                pvo.setImagen2(rs.getString("imagen2"));
                pvo.setFecha(rs.getString("FechaPublicación"));
                vo.setNombres(rs.getString("usuario"));
                vo.setId(rs.getInt("idusuario"));
                cvo.setDescripcion(rs.getString("ciudad"));
                categoriasVo.setDescripcion(rs.getString("categoria"));

                pvo.setCategoriasVo(categoriasVo);
                vo.setCiudadVO(cvo);
                pvo.setUsuario(vo);
                producto.add(pvo);

            }

        } catch (SQLException e) {
        }
        return producto;
    }

    //Con este metodo podemos per las imagenes de las publicaciones
    //Con este metodo se elimina las publicaciones
    @Override
    public void eliminar_producto(int id) {
        PreparedStatement pst = null;
        ComentariosDao cd = new ComentariosDao();
        String sql = "DELETE FROM `producto` WHERE idproducto=" + id;
        try {

            pst = con.getConnection().prepareStatement(sql);
            if (cd.eliminarid(id)) {
                pst.execute();
            } else {
                pst.execute();
            }

        } catch (Exception e) {
        }
        con.desconectar();
    }

    //Con este metodo podemos ver las publicaciones por categorias
    public List listarcategoria(int id) {
        PreparedStatement pst;
        ResultSet rs;
        List<PublicarVO> lista = new ArrayList<>();
        String sql = "SELECT * FROM `verProducto` WHERE categoria_idcategoria=" + id;
        try {
            pst = con.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                PublicarVO pvo = new PublicarVO();
                CategoriasVo cv = new CategoriasVo();
                pvo.setId_publicar(rs.getInt("idproducto"));
                pvo.setNombre(rs.getString("nombre"));
                pvo.setDescripcion(rs.getString("descripcion"));
                pvo.setPrecioestimado(rs.getString("precio_estimado"));
                pvo.setImagen1(rs.getString("imagen1"));
                pvo.setMarca(rs.getString("marca"));
                cv.setDescripcion(rs.getString("categoria"));
                pvo.setCategoriasVo(cv);
                lista.add(pvo);
            }

        } catch (Exception e) {
        }
        return lista;
    }

    //Con este metodo podemos ver los detalles de una publicación
    public boolean detallesproducto(PublicarVO pvo) {
        PreparedStatement pst;
        ResultSet rs;

        String sql = "SELECT * FROM producto INNER join usuario on producto.usuario_idusuario=usuario.idusuario INNER JOIN categoria ON producto.categoria_idcategoria=categoria.idcategoria INNER JOIN ciudad on usuario.ciudad_id_ciudad=ciudad.id_ciudad WHERE idproducto=?";
        try {
            pst = con.getConnection().prepareStatement(sql);
            pst.setInt(1, pvo.getId_publicar());
            rs = pst.executeQuery();
            while (rs.absolute(1)) {
                usuariovo vo = new usuariovo();
                CiudadVO cvo = new CiudadVO();
                CategoriasVo cv = new CategoriasVo();
                pvo.setId_publicar(rs.getInt("idproducto"));
                pvo.setNombre(rs.getString("nombre"));
                pvo.setDescripcion(rs.getString("descripcion"));
                pvo.setPrecioestimado(rs.getString("precio_estimado"));
                pvo.setMarca(rs.getString("marca"));
                pvo.setCantidad(rs.getString("cantidad"));
                pvo.setId_usuario(rs.getInt("usuario_idusuario"));
                vo.setNombres(rs.getString("usuario"));
                vo.setTelefono(rs.getString("telefono"));
                vo.setCorreo(rs.getString("correo"));
                cvo.setDescripcion(rs.getString("ciudad"));
                cv.setDescripcion(rs.getString("categoria"));
                pvo.setImagen1(rs.getString("imagen1"));
                pvo.setImagen2(rs.getString("imagen2"));
                pvo.setImagen3(rs.getString("imagen3"));
                pvo.setFecha(rs.getString("FechaPublicación"));

                vo.setCiudadVO(cvo);
                pvo.setUsuario(vo);
                pvo.setCategoriasVo(cv);
                return true;
            }

        } catch (SQLException e) {
        }
        return false;
    }

    //Con este metodo podemos ver los productos de otro usuario
    public PublicarVO consultarproducto(int idproducto) {
        PreparedStatement pst;
        ResultSet rs;

        String sql = "SELECT * FROM producto INNER join usuario on producto.usuario_idusuario=usuario.idusuario INNER JOIN categoria ON producto.categoria_idcategoria=categoria.idcategoria INNER JOIN ciudad on usuario.ciudad_id_ciudad=ciudad.id_ciudad WHERE idproducto=?";
        try {
            pst = con.getConnection().prepareStatement(sql);
            pst.setInt(1, idproducto);
            rs = pst.executeQuery();
            if (rs.absolute(1)) {
                usuariovo vo = new usuariovo();
                CiudadVO cvo = new CiudadVO();
                PublicarVO pvo = new PublicarVO();
                CategoriasVo cv = new CategoriasVo();
                pvo.setId_publicar(rs.getInt("idproducto"));
                pvo.setNombre(rs.getString("nombre"));
                pvo.setDescripcion(rs.getString("descripcion"));
                pvo.setPrecioestimado(rs.getString("precio_estimado"));
                pvo.setImagen1(rs.getString("imagen1"));
                pvo.setMarca(rs.getString("marca"));
                pvo.setCantidad(rs.getString("cantidad"));
                pvo.setId_usuario(rs.getInt("usuario_idusuario"));
                vo.setNombres(rs.getString("usuario"));
                vo.setTelefono(rs.getString("telefono"));
                cvo.setDescripcion(rs.getString("ciudad"));
                cv.setDescripcion(rs.getString("categoria"));
                vo.setCorreo(rs.getString("correo"));
                vo.setCiudadVO(cvo);
                pvo.setUsuario(vo);
                pvo.setCategoriasVo(cv);
                return pvo;
            }

        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public boolean Publicar_producto(PublicarVO p) {
        PreparedStatement pst = null;
        Date fecha = new Date();
        SimpleDateFormat forma = new SimpleDateFormat("YYY-MM-dd");
        p.setFecha(forma.format(fecha));
        p.setDisponible(true);
        String sql = "CALL `agregarpublicacion`(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            pst = con.getConnection().prepareCall(sql);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getCantidad());
            pst.setString(3, p.getDescripcion());
            pst.setString(4, p.getPrecioestimado());
            pst.setString(5, p.getMarca());
            pst.setInt(6, p.getId_usuario());
            pst.setInt(7, p.getId_categoria());
            pst.setString(8, p.getImagen1());
            pst.setString(9, p.getImagen2());
            pst.setString(10, p.getImagen3());
            pst.setBoolean(11, p.isDisponible());
            pst.setString(12, p.getFecha());

            if (pst.executeUpdate() == 1) {

                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            con.desconectar();
        }

        return false;
    }

    public void disponibilidad(int interesado) throws SQLException {
        SolicitudDAO solicitudDAO = new SolicitudDAO();
        String sql = "UPDATE producto SET disponible=FALSE WHERE `idproducto`=" + solicitudDAO.obtenerproducto(interesado).getProducto_idproducto();

        try {
            ps = con.getConnection().prepareStatement(sql);

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disponibilidadinteresado(int interesado) throws SQLException {
        SolicitudDAO solicitudDAO = new SolicitudDAO();
        String sql = "UPDATE producto SET disponible=FALSE WHERE `idproducto`=" + solicitudDAO.obtenerproducto(interesado).getProducto_id();

        try {
            ps = con.getConnection().prepareStatement(sql);

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List productorelacionado(String precio) {
        PreparedStatement pst;
        ResultSet rs;
        List<PublicarVO> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE precio_estimado=? AND disponible=TRUE ORDER BY producto.idproducto DESC";
        try {
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, precio);
            rs = pst.executeQuery();
            while (rs.next()) {
                PublicarVO pvo = new PublicarVO();
                pvo.setId_publicar(rs.getInt("idproducto"));
                pvo.setNombre(rs.getString("nombre"));
                pvo.setDescripcion(rs.getString("descripcion"));
                pvo.setPrecioestimado(rs.getString("precio_estimado"));
                pvo.setMarca(rs.getString("marca"));
                pvo.setImagen1(rs.getString("imagen1"));
                lista.add(pvo);
            }

        } catch (Exception e) {
        }
        return lista;
    }

    public String countproducto(int id) {
        String ca;
        String sql = "SELECT COUNT(*) AS cantidad FROM producto WHERE usuario_idusuario=" + id + " AND disponible=TRUE";
        try {
            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                ca = rs.getString("cantidad");
                return ca;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List listarinteresados(int id, String precio) {
        PreparedStatement pst;
        ResultSet rs;
        List<PublicarVO> lista = new ArrayList<>();
        String sql = "SELECT * FROM `verProducto`\n"
                + " WHERE (disponible = 1 AND `precio_estimado`=?) AND `idusuario`=?\n"
                + "ORDER BY idproducto DESC\n"
                + "";
        try {
            pst = con.getConnection().prepareCall(sql);
            pst.setString(1, precio);
            pst.setInt(2, id);

            rs = pst.executeQuery();
            while (rs.next()) {
                PublicarVO pvo = new PublicarVO();
                CiudadVO ciudadVO = new CiudadVO();
                usuariovo vo = new usuariovo();
                pvo.setId_publicar(rs.getInt("idproducto"));
                pvo.setNombre(rs.getString("nombre"));
                pvo.setDescripcion(rs.getString("descripcion"));
                pvo.setPrecioestimado(rs.getString("precio_estimado"));
                pvo.setMarca(rs.getString("marca"));
                pvo.setImagen1(rs.getString("imagen1"));
                ciudadVO.setDescripcion(rs.getString("ciudad"));
                vo.setCiudadVO(ciudadVO);
                pvo.setUsuario(vo);
                lista.add(pvo);
            }

        } catch (Exception e) {
        }
        return lista;
    }

}

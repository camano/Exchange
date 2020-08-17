/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.dao;

import Exchange.proyecto.persistencia.vo.CategoriasVo;
import Exchange.proyecto.persistencia.vo.ComentariosVo;
import Exchange.proyecto.persistencia.vo.InteresadosVO;
import Exchange.proyecto.persistencia.vo.PublicarVO;
import Exchange.proyecto.persistencia.vo.usuariovo;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author jonathan
 */
public class probar {

    public static void main(String[] args) throws SQLException, UnsupportedEncodingException {

        usuariovo vo = new usuariovo();
        Encriptacioaes encriptacioaes = new Encriptacioaes();
        usuarioDao dao = new usuarioDao();

   try {
       vo=dao.correo("pruebas@gmail.com");
            String Desencriptacion = encriptacioaes.desencriptar(vo.getPassword(), vo.getCorreo());
            String mensaje = "Su Contraseña Es " + Desencriptacion;
            System.out.println(mensaje);
          
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(probar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(probar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(probar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(probar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(probar.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

}

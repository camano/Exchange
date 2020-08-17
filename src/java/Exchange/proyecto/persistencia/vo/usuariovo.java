/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.vo;

import java.io.InputStream;

/**
 *
 * @author jonathan
 */
public class usuariovo {
    private int id;
    private String Nombres;
    private String Correo;
    private String Password;
    private String Telefono;
    private String genero;
    private int ciudad_id;
    private String cantidad;

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

  

    
   
    private CiudadVO ciudadVO;

    public CiudadVO getCiudadVO() {
        return ciudadVO;
    }

    public void setCiudadVO(CiudadVO ciudadVO) {
        this.ciudadVO = ciudadVO;
    }
    

    public usuariovo() {
    }
    

    public usuariovo(int id, String Nombres, String Correo, String Password, String Telefono, String genero, int ciudad_id) {
        this.id = id;
        this.Nombres = Nombres;
        this.Correo = Correo;
        this.Password = Password;
        this.Telefono = Telefono;
        this.genero = genero;
        this.ciudad_id = ciudad_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(int ciudad_id) {
        this.ciudad_id = ciudad_id;
    }
    
    
    
    
}

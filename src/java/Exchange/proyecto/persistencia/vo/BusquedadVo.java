/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.vo;

/**
 *
 * @author 57313
 */
public class BusquedadVo {
    int idbusquedad;
    String fecha;
    String palabraclave;
    usuariovo usuario;

    public BusquedadVo() {
    }

    public int getIdbusquedad() {
        return idbusquedad;
    }

    public void setIdbusquedad(int idbusquedad) {
        this.idbusquedad = idbusquedad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPalabraclave() {
        return palabraclave;
    }

    public void setPalabraclave(String palabraclave) {
        this.palabraclave = palabraclave;
    }

    public usuariovo getUsuario() {
        return usuario;
    }

    public void setUsuario(usuariovo usuario) {
        this.usuario = usuario;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.vo;

/**
 *
 * @author johan
 */
public class subastaVO {
   private int idsolicitud_intercambio;
    private String nombres;
    private String descripciones;
    private String precios;
    private String estado;
    private String notificacion;
    private int producto_idproducto;
    private int producto_id;

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }
    private int usuario_idusuario;

    public subastaVO() {
    }

    public subastaVO(int idsolicitud_intercambio, String nombres, String descripciones, String precios, String estado, String notificacion, int producto_idproducto, int usuario_idusuario) {
        this.idsolicitud_intercambio = idsolicitud_intercambio;
        this.nombres = nombres;
        this.descripciones = descripciones;
        this.precios = precios;
        this.estado = estado;
        this.notificacion = notificacion;
        this.producto_idproducto = producto_idproducto;
        this.usuario_idusuario = usuario_idusuario;
    }

    public int getIdsolicitud_intercambio() {
        return idsolicitud_intercambio;
    }

    public void setIdsolicitud_intercambio(int idsolicitud_intercambio) {
        this.idsolicitud_intercambio = idsolicitud_intercambio;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripciones() {
        return descripciones;
    }

    public void setDescripciones(String descripciones) {
        this.descripciones = descripciones;
    }

    public String getPrecios() {
        return precios;
    }

    public void setPrecios(String precios) {
        this.precios = precios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public int getProducto_idproducto() {
        return producto_idproducto;
    }

    public void setProducto_idproducto(int producto_idproducto) {
        this.producto_idproducto = producto_idproducto;
    }

    public int getUsuario_idusuario() {
        return usuario_idusuario;
    }

    public void setUsuario_idusuario(int usuario_idusuario) {
        this.usuario_idusuario = usuario_idusuario;
    }

   
    
}

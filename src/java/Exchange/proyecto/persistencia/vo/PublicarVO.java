/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.vo;

import java.io.InputStream;

/**
 *
 * @author johan
 */
public class PublicarVO {

    private int id_publicar;
    private String nombre;
    private String cantidad;
    private String descripcion;
    private String precioestimado;
    private String marca;
    private String certificado;
    private String tiempouso;
    private usuariovo usuario;
    private CategoriasVo categoriasVo;
    private int id_usuario;
    private int id_categoria;
    private int id_tiempopublicacion;
    private String imagen1;
    private String imagen2;
    private String imagen3;
    private String fecha;
    private boolean disponible;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public PublicarVO(int id_publicar, String nombre, String cantidad, String descripcion, String precioestimado, String marca, String certificado, String tiempouso, usuariovo usuario, CategoriasVo categoriasVo, int id_usuario, int id_categoria, int id_tiempopublicacion, String imagen1, String imagen2, String imagen3, String fecha, boolean disponible) {
        this.id_publicar = id_publicar;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precioestimado = precioestimado;
        this.marca = marca;
        this.certificado = certificado;
        this.tiempouso = tiempouso;
        this.usuario = usuario;
        this.categoriasVo = categoriasVo;
        this.id_usuario = id_usuario;
        this.id_categoria = id_categoria;
        this.id_tiempopublicacion = id_tiempopublicacion;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
        this.fecha = fecha;
        this.disponible = disponible;
    }

  

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }

    public String getImagen3() {
        return imagen3;
    }

    public void setImagen3(String imagen3) {
        this.imagen3 = imagen3;
    }

  

   

    public CategoriasVo getCategoriasVo() {
        return categoriasVo;
    }

    public void setCategoriasVo(CategoriasVo categoriasVo) {
        this.categoriasVo = categoriasVo;
    }

    public usuariovo getUsuario() {
        return usuario;
    }

    public void setUsuario(usuariovo usuario) {
        this.usuario = usuario;
    }

 

    public PublicarVO() {
    }

    public int getId_publicar() {
        return id_publicar;
    }

    public void setId_publicar(int id_publicar) {
        this.id_publicar = id_publicar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecioestimado() {
        return precioestimado;
    }

    public void setPrecioestimado(String precioestimado) {
        this.precioestimado = precioestimado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getTiempouso() {
        return tiempouso;
    }

    public void setTiempouso(String tiempouso) {
        this.tiempouso = tiempouso;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_tiempopublicacion() {
        return id_tiempopublicacion;
    }

    public void setId_tiempopublicacion(int id_tiempopublicacion) {
        this.id_tiempopublicacion = id_tiempopublicacion;
    }

}

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
public class ComentariosVo {
    
    private int idcomentario;
    private String comentario;
    private usuariovo usuariovo;
    private PublicarVO publicarVO;
    private int usuario;
    private int producto;

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public ComentariosVo() {
    }

    public ComentariosVo(int idcomentario, String comentario, usuariovo usuariovo, PublicarVO publicarVO) {
        this.idcomentario = idcomentario;
        this.comentario = comentario;
        this.usuariovo = usuariovo;
        this.publicarVO = publicarVO;
    }

    public int getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(int idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public usuariovo getUsuariovo() {
        return usuariovo;
    }

    public void setUsuariovo(usuariovo usuariovo) {
        this.usuariovo = usuariovo;
    }

    public PublicarVO getPublicarVO() {
        return publicarVO;
    }

    public void setPublicarVO(PublicarVO publicarVO) {
        this.publicarVO = publicarVO;
    }
    
    
}

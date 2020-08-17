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
public class InteresadosVO {
    int idinteresados;
    usuariovo usuario;
    PublicarVO publicar;

    public InteresadosVO() {
    }

    public InteresadosVO(int idinteresados, usuariovo usuario) {
        this.idinteresados = idinteresados;
        this.usuario = usuario;
    }

    public int getIdinteresados() {
        return idinteresados;
    }

    public void setIdinteresados(int idinteresados) {
        this.idinteresados = idinteresados;
    }

    public usuariovo getUsuario() {
        return usuario;
    }

    public void setUsuario(usuariovo usuario) {
        this.usuario = usuario;
    }

    public PublicarVO getPublicar() {
        return publicar;
    }

    public void setPublicar(PublicarVO publicar) {
        this.publicar = publicar;
    }
    
}

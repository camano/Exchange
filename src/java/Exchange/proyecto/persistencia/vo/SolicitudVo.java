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
public class SolicitudVo {

    int idsolicitud;
    String oferta;
    PublicarVO publicarVO;
    InteresadosVO interesadosVO;

    public SolicitudVo() {
    }

    public SolicitudVo(int idsolicitud, String oferta, PublicarVO publicarVO, InteresadosVO interesadosVO) {
        this.idsolicitud = idsolicitud;
        this.oferta = oferta;
        this.publicarVO = publicarVO;
        this.interesadosVO = interesadosVO;
    }

    public int getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(int idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public PublicarVO getPublicarVO() {
        return publicarVO;
    }

    public void setPublicarVO(PublicarVO publicarVO) {
        this.publicarVO = publicarVO;
    }

    public InteresadosVO getInteresadosVO() {
        return interesadosVO;
    }

    public void setInteresadosVO(InteresadosVO interesadosVO) {
        this.interesadosVO = interesadosVO;
    }

}

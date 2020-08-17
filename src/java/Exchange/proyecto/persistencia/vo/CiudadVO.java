/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.vo;

/**
 *
 * @author jonathan
 */
public class CiudadVO {
    private int idciudad;
    private String descripcion;

    public CiudadVO() {
    }

    public CiudadVO(int idciudad, String descripcion) {
        this.idciudad = idciudad;
        this.descripcion = descripcion;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void getDescripcion(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

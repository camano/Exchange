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
public class DepartamentosVo {
    private int iddepartamento;
    private String descripcion;

    public DepartamentosVo() {
    }

    public DepartamentosVo(int iddepartamento, String descripcion) {
        this.iddepartamento = iddepartamento;
        this.descripcion = descripcion;
    }

    public int getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

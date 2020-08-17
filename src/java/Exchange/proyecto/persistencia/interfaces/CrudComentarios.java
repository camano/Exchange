/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.interfaces;

import Exchange.proyecto.persistencia.vo.ComentariosVo;
import java.util.List;

/**
 *
 * @author 57313
 */
public interface CrudComentarios {
    public boolean comentar(ComentariosVo comentariosVo);
    public boolean eliminar(ComentariosVo comentariosVo);
  public List listarcomentarios(int id);
  public boolean eliminarid(int idproducto);
}

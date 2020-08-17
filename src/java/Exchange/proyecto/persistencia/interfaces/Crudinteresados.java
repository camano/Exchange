/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.interfaces;

import Exchange.proyecto.persistencia.vo.InteresadosVO;
import Exchange.proyecto.persistencia.vo.usuariovo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 57313
 */
public interface Crudinteresados {
 
      public List verinteresados(int id);
      public void guardarinteresados(InteresadosVO interesadosVO);
      public void eliminar(int id);
    
}

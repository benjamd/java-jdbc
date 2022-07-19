/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.UsuarioDTO;
import java.util.List;

/**
 *
 * @author benja
 */
public interface IUsuarioDao  {
    
    List<UsuarioDTO> select();
    
    int insert(UsuarioDTO usuario);
    
    int update(UsuarioDTO usuario);
    
    int delete(UsuarioDTO usuario);
}

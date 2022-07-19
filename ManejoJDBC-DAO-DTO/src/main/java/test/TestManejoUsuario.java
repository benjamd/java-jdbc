/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.IUsuarioDao;
import datos.UsuarioDaoJDBC;
import domain.UsuarioDTO;
import java.util.List;

/**
 *
 * @author benja
 */
public class TestManejoUsuario {

    public static void main(String[] args) {
        IUsuarioDao usuarioDao = new UsuarioDaoJDBC();

        //LISTAR
        List<UsuarioDTO> usuarios = usuarioDao.select();

        for (UsuarioDTO user : usuarios) {
            System.out.println("usuario = " + user);

        }

        //INSERT
        System.out.println("");
        UsuarioDTO nuevoUsuario = new UsuarioDTO("diego", "rallo");
        int  reg = usuarioDao.insert(nuevoUsuario);
        System.out.println("registros afectados: " + reg);
        System.out.println("");
        
        usuarios = usuarioDao.select();
        for (UsuarioDTO user : usuarios) {
            System.out.println("usuario = " + user);

        }        
        
        //ACTUALIZAR
        UsuarioDTO actualizarUsuario = new UsuarioDTO(1, "jperez", "fac1l");
        reg = usuarioDao.update(actualizarUsuario);
        System.out.println("registros afectados: " + reg);
        System.out.println("");
        
        usuarios = usuarioDao.select();
        for (UsuarioDTO user : usuarios) {
            System.out.println("usuario = " + user);

        }                
        
        //ELIMINAR
        UsuarioDTO eliminarUsuario = new UsuarioDTO(2);
        reg = usuarioDao.delete(eliminarUsuario);
        System.out.println("registros afectados: " + reg);
        System.out.println("");
        
        usuarios = usuarioDao.select();
        for (UsuarioDTO user : usuarios) {
            System.out.println("usuario = " + user);

        }    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}

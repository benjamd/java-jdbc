/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.UsuarioJDBC;
import domain.Usuario;
import java.util.List;

/**
 *
 * @author benja
 */
public class TestManejoUsuario {

    public static void main(String[] args) {
        UsuarioJDBC usuarioDao = new UsuarioJDBC();

        //LISTAR
        List<Usuario> usuarios = usuarioDao.seleccionar();

        for (Usuario user : usuarios) {
            System.out.println("usuario = " + user);

        }

        //INSERT
        System.out.println("");
        Usuario nuevoUsuario = new Usuario("diego", "rallo");
        int  reg = usuarioDao.insertar(nuevoUsuario);
        System.out.println("registros afectados: " + reg);
        System.out.println("");
        
        usuarios = usuarioDao.seleccionar();
        for (Usuario user : usuarios) {
            System.out.println("usuario = " + user);

        }        
        
        //ACTUALIZAR
        Usuario actualizarUsuario = new Usuario(1, "jperez", "fac1l");
        reg = usuarioDao.actualizar(actualizarUsuario);
        System.out.println("registros afectados: " + reg);
        System.out.println("");
        
        usuarios = usuarioDao.seleccionar();
        for (Usuario user : usuarios) {
            System.out.println("usuario = " + user);

        }                
        
        //ELIMINAR
        Usuario eliminarUsuario = new Usuario(2);
        reg = usuarioDao.eliminar(eliminarUsuario);
        System.out.println("registros afectados: " + reg);
        System.out.println("");
        
        usuarios = usuarioDao.seleccionar();
        for (Usuario user : usuarios) {
            System.out.println("usuario = " + user);

        }    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.Conexion;
import datos.IPersonaDao;
import datos.PersonaDaoJDBC;
import datos.UsuarioDaoJDBC;
import domain.PersonaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benja
 */
public class TestManejoPersona {
    
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            IPersonaDao PersonaDao = new PersonaDaoJDBC(conexion);

            List<PersonaDTO> personas = PersonaDao.select();
            
            personas.forEach(persona -> {System.out.println("personas = " + personas);
            });
            
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al Rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
            
        }
                
                
    }    
}

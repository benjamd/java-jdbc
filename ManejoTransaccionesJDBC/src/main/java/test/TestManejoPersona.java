/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.Conexion;
import datos.PersonaJDBC;
import datos.UsuarioJDBC;
import domain.Persona;
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
            
            PersonaJDBC personaDao = new PersonaJDBC(conexion);
            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(2);
            cambioPersona.setNombre("Karla Jazmin");
            cambioPersona.setApellido("Azure Diaz");
            cambioPersona.setEmail("kjAzured@gmail.com");
            cambioPersona.setTelefono("01142543945");
            personaDao.actualizar(cambioPersona);
            
            /*
            ERROR PARA TESTEAR ROLLBACK
            personaDao.insertar(new Persona("Manolo", "Arrimadasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
                    , "marrimada@hotmail.es", "55559999"));
            */
            
            personaDao.insertar(new Persona("Manolo", "Arias"
                    , "marrimada@hotmail.es", "55559999"));
            
            
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

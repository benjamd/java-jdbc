/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

/**
 *
 * @author benja
 */
public class TestManejoPersona {
    
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        List<Persona> personas = personaDao.seleccionar();
        
        personas.forEach(p -> {
            System.out.println("persona = " + p);
        });
        System.out.println("");
        
        //INSERT PERSONA
        /*
        System.out.println("INSERT PERSONA);
        Persona personaNueva = new Persona("Daniela", "Torres", "dtorres@hotmail.com", "1134210921");
        int reg = personaDao.insertar(personaNueva);    
        System.out.println("registros afectados: " + reg);
        System.out.println("");
       */
        //MODIFICAR PERSONA
        /*
        System.out.println("MODIFICAR PERSONA");
        Persona personaModificar = new Persona(1,"Juan Carlos", "Gomez", "jg@gmail.com", "278-1111");
        int reg = personaDao.actualizar(personaModificar);    
        System.out.println("registros afectados: " + reg);
        System.out.println("");
        */
        
        //ELIMINAR PERSONA
        System.out.println("ELIMINAR PERSONA");
        Persona PersonaEliminar = new Persona(3);
        int reg = personaDao.eliminar(PersonaEliminar);
        System.out.println("registros afectados: " + reg);
        System.out.println("");
        
        //NUEVA CONSULTA
        personas = personaDao.seleccionar();
        
        personas.forEach(p -> {
            System.out.println("persona = " + p);
        });
        System.out.println("");
                
                
    }    
}

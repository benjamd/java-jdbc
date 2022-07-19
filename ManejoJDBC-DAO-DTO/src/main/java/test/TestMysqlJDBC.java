/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author benja
 */
public class TestMysqlJDBC {
    
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrival=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion =  DriverManager.getConnection(url, "root", "B3nja_md");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM personas";
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while(resultado.next()) {
                System.out.print("Id persona: "+ resultado.getInt("id_persona"));
                System.out.print(", Nombre: "+ resultado.getString("nombre"));
                System.out.print(", Apellido: "+ resultado.getString("apellido"));
                System.out.print(", Email: "+ resultado.getString("email"));
                System.out.print(", Telefono: "+ resultado.getString("telefono"));
                System.out.println("");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        
        
        
        
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benja
 */
public class UsuarioDaoJDBC implements IUsuarioDao {
    
    private static final String SQL_SELECT = "SELECT id_usuario, username, password FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios(username, password) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET username = ? , password = ?  WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario = ?";
    
    public List<UsuarioDTO> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDTO usuario = null;
        List<UsuarioDTO> usuarios = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs != null && rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String username = rs.getString("username");
                String password = rs.getString("password");
                usuario = new UsuarioDTO(idUsuario, username, password);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }

        return usuarios;
    }
    
    public int insert(UsuarioDTO usuario){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            close(stmt);
            close(conn);
            
            
        }
     return rows;   
    }

    
    public int update(UsuarioDTO usuario){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getIdUsuario());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
        
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            close(stmt);
            close(conn);
            
            
        }
     return rows;   
    }
    
    
    public int delete(UsuarioDTO usuario){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            close(stmt);
            close(conn);
            
            
        }
     return rows;   
    }
    
}

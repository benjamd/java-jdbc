/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.PersonaDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author benja
 */
public interface IPersonaDao {
    
    List<PersonaDTO> select() throws SQLException;
    
    int insert(PersonaDTO persona) throws SQLException;
    
    int update(PersonaDTO persona) throws SQLException;
    
    int delete(PersonaDTO persona) throws SQLException;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baquiax.aprueba;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class PersonaDB {
    public boolean insert(Persona persona){
        try {
            PreparedStatement statement = ConeccionDB.getConeccion().prepareStatement("insert into personas(nombre,edad) values(?,?)");
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getEdad());
            
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Persona> listPersons(){
        List<Persona> list = new ArrayList<>();
        try {
            PreparedStatement statement = ConeccionDB.getConeccion().prepareStatement("select * from personas");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {                
                list.add(new Persona(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("edad")));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

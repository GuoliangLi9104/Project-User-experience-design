/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Li
 */
public class VotersDAO {

    public VotersDAO() {
    }
    
     public void createVoters(Voters voters) {

        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO voter (idNumber, name, lastName, vote) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, voters.getIDNumber());
            ps.setString(2, voters.getName());
            ps.setString(3, voters.getLastName());
            ps.setInt(4, voters.getVote());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el candidato");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el candidato, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

  public List<Voters> readVoters() {
    DBConnectionJava db = new DBConnectionJava();
    List<Voters> Voter = new ArrayList<>();
    String sql = "SELECT * FROM voter";

    try {
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int idNumber = resultSet.getInt("idNumber");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            int vote = resultSet.getInt("vote");

            Voter.add(new Voters(id,idNumber, name, lastName, vote));
        }
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    } finally {
        db.disconnect();
    }
    return Voter;
}

  public void updateVoters(Voters voters) {
    DBConnectionJava db = new DBConnectionJava();
    String consultaSQL = "UPDATE voter SET idNumber=?,name=?, lastName=?, vote=? WHERE id=?";
    
    try {
        PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
        ps.setInt(1, voters.getIDNumber());
        ps.setString(1, voters.getName());
        ps.setString(2, voters.getLastName());
        ps.setInt(4, voters.getVote());
        ps.execute();
        JOptionPane.showMessageDialog(null, "Modificación Exitosa");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se modificó, error: " + e.toString());
    } finally {
        db.disconnect();
    }
}

    public void delete(int id) {

        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM candidates WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el candidato");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }finally {
            db.disconnect();
        }
        
    }
}

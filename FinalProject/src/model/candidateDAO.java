/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JRS
 */
public class candidateDAO {
    
     public candidateDAO() {
    }

    public void createCandidate(candidate Candidate) {

        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO canditates (name, lastName, picture, id_party) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, Candidate.getName());
            ps.setString(2, Candidate.getLastName());
            ps.setString(3, Candidate.getPicture());
            ps.setInt(4, Candidate.getId_party());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el candidato");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el candidato, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

  public List<candidate> readCandidate() {
    DBConnectionJava db = new DBConnectionJava();
    List<candidate> candidates = new ArrayList<>();
    String sql = "SELECT * FROM canditates";

    try {
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            String picture = resultSet.getString("picture");
            int id_party = resultSet.getInt("id_party");

            candidates.add(new candidate(id, name, lastName, picture, id_party));
        }
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    } finally {
        db.disconnect();
    }
    return candidates;
}

  public void updateCandidate(candidate Candidate) {
    DBConnectionJava db = new DBConnectionJava();
    String consultaSQL = "UPDATE canditates SET name=?, lastName=?, picture=?, id_party=? WHERE id=?";
    
    try {
        PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
        ps.setString(1, Candidate.getName());
        ps.setString(2, Candidate.getLastName());
        ps.setString(3, Candidate.getPicture());
        ps.setInt(4, Candidate.getId_party());
        ps.setInt(5, Candidate.getId());
        ps.execute();
        JOptionPane.showMessageDialog(null, "Modificación Exitosa");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se modificó, error: " + e.toString());
    } finally {
        db.disconnect();
    }
}
  public int getIDCandidate(String name) {
        int value = 0;
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT id FROM canditates WHERE name = ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                value = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return value;
    }

    public String getNameCandidate(int id) {
        String value = "";
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT name FROM canditates WHERE id = ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                value = resultSet.getString("name");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return value;
    }

    public void deleteCandidate(int id) {

        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM canditates WHERE id=?";

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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

    public void create(candidate Candidate) {

        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO candidates (name, lastName, picture, id_party) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, Candidate.getName());
            ps.setString(2, Candidate.getLastName());
            ps.setBlob(3, Candidate.getPicture());
            ps.setInt(4, Candidate.getId_party());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el candidato");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el candidato, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

  public List<candidate> read() {
    DBConnectionJava db = new DBConnectionJava();
    List<candidate> candidates = new ArrayList<>();
    String sql = "SELECT * FROM candidates";

    try {
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            Blob picture = resultSet.getBlob("picture");
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

  public void update(candidate Candidate) {
    DBConnectionJava db = new DBConnectionJava();
    String consultaSQL = "UPDATE candidates SET name=?, lastName=?, picture=?, id_party=? WHERE id=?";
    
    try {
        PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
        ps.setString(1, Candidate.getName());
        ps.setString(2, Candidate.getLastName());
        ps.setBlob(3, Candidate.getPicture());
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

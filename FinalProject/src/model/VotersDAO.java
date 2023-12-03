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
        String consultaSQL = "INSERT INTO voters (idNumber, name, lastName, vote) VALUES (?, ?, ?, ?)";
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
        String sql = "SELECT * FROM voters";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idNumber = resultSet.getInt("idNumber");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                int vote = resultSet.getInt("vote");

                Voter.add(new Voters(id, idNumber, name, lastName, vote));
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
        String consultaSQL = "UPDATE voters SET idNumber=?,name=?, lastName=?,vote=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, voters.getIDNumber());
            ps.setString(2, voters.getName());
            ps.setString(3, voters.getLastName());
            ps.setInt(4, voters.getVote());
            ps.setInt(5, voters.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    public void deleteVoters(int id) {

        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM voters WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el candidato");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        } finally {
            db.disconnect();
        }

    }

    public int getIDVoters(String name) {
        int value = 0;
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT id FROM voters WHERE name = ?";
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

    public String getNameVoters(int id) {
        String value = "";
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT name FROM voters WHERE id = ?";
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
    
     public Voters authenticateVoter(String ID) {
        DBConnectionJava db = new DBConnectionJava();
        int IDNumber = Integer.parseInt(ID);
        Voters voters = null;
        String sql = "SELECT * FROM voters WHERE idNumber = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, IDNumber);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idNumber = resultSet.getInt("idNumber");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                int vote = resultSet.getInt("vote");

                voters = new Voters(id, idNumber, name, lastName, vote);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }

        return voters;
    }
     
     
     public void decreaseVote(Voters voters) {
    DBConnectionJava db = new DBConnectionJava();
    String consultaSQL = "UPDATE voters SET vote = vote - 1 WHERE id=?";

    try {
        PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
        ps.setInt(1, voters.getId());
        ps.execute();
        JOptionPane.showMessageDialog(null, "Voto disminuido exitosamente");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se disminuyó el voto, error: " + e.toString());
    } finally {
        db.disconnect();
    }
}
    
}

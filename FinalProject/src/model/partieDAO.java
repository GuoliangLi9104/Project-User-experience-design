/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
public class partieDAO {

    public partieDAO() {
    }
   
    
    public void create(partie Partie) {

        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO parties (name) VALUES (?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, Partie.getName());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el candidato");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el candidato, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

  public List<partie> readParties() {
    DBConnectionJava db = new DBConnectionJava();
    List<partie> Partie = new ArrayList<>();
    String sql = "SELECT * FROM canditates";

    try {
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Partie.add(new partie(id, name));
        }
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    } finally {
        db.disconnect();
    }
    return Partie;
}

  public void updateParties(partie Parties) {
    DBConnectionJava db = new DBConnectionJava();
    String consultaSQL = "UPDATE parties SET name=? WHERE id=?";
    
    try {
        PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
        ps.setString(1, Parties.getName());
        ps.setInt(2, Parties.getId());
        ps.execute();
        JOptionPane.showMessageDialog(null, "Modificación Exitosa");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se modificó, error: " + e.toString());
    } finally {
        db.disconnect();
    }
}

    public void deleteParties(int id) {

        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM parties WHERE id=?";

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
    
    public int getIDParty(String name) {
        int value = 0;
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT id FROM parties WHERE name = ?";
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

    public String getNameParty(int id) {
        String value = "";
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT name FROM parties WHERE id = ?";
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
    
}

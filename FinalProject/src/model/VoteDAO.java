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
public class VoteDAO {

    public VoteDAO() {
    }

    public void createVote(Vote votes) {

        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO votes (id_voter, id_candidate, id_vote) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, votes.getIDVoter());
            ps.setInt(2, votes.getIDCandidate());
            ps.setInt(3, votes.getIDVote());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el candidato");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el candidato, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    public List<Vote> readVote() {
        DBConnectionJava db = new DBConnectionJava();
        List<Vote> Vote = new ArrayList<>();
        String sql = "SELECT * FROM votes";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_voter = resultSet.getInt("id_voter");
                int id_party = resultSet.getInt("id_candidate");
                int id_vote = resultSet.getInt("id_vote");

                Vote.add(new Vote(id, id_voter, id_party, id_vote));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return Vote;
    }

    public void updateVote(Vote vote) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "UPDATE vote SET id_voter=?,id_party=?, id_vote=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, vote.getIDVoter());
            ps.setInt(1, vote.getIDCandidate());
            ps.setInt(2, vote.getIDVote());
            ps.setInt(4, vote.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    public void deleteVote(int id) {

        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM votes WHERE id=?";

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

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT c.name AS Nombre\n"
                + "FROM votes AS v\n"
                + "INNER JOIN canditates AS c ON v.id_candidate = c.id\n"
                + "GROUP BY c.id;";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String Name = resultSet.getString("Nombre");
                names.add(Name);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return names;

    }

    public List<Integer> getVotes() {
        List<Integer> votes = new ArrayList<>();
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT AVG(v.id_vote) AS votos\n"
                + "FROM votes AS v\n"
                + "INNER JOIN canditates AS c ON v.id_candidate = c.id\n"
                + "GROUP BY c.id;";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int vote = resultSet.getInt("votos");
                votes.add(vote);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return votes;

    }

    public int getIDVote(String name) {
        int value = 0;
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT id FROM votes WHERE name = ?";
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

}

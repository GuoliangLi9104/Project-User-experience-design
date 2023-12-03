/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.*;
import view.*;

/**
 *
 * @author JRS
 */
public class ctrlVoters {
    private VotersDAO daoVoters = new VotersDAO();
    private candidateDAO daoCandi = new candidateDAO();
    private int id, voterID, candidateID;

    public void loadDataVoters(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<Voters> votersList = daoVoters.readVoters();
        for (Voters voter : votersList) {
            Object[] row = {voter.getId(), voter.getName(), voter.getLastName(), voter.getIDNumber(), voter.getVote()};
            model.addRow(row);
        }
    }

    public void addVoter(JTextField idNumber, JTextField name, JTextField lastName,  JTextField vote) {
        try {
            this.daoVoters.createVoters(new Voters(this.id, Integer.parseInt(idNumber.getText()), name.getText(), lastName.getText(), Integer.parseInt(vote.getText())));
            JOptionPane.showMessageDialog(null, "Votante añadido exitosamente ");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error in data format: " + e.toString());
        }
    }

    public void updateVoter(JTextField idNumber, JTextField name, JTextField lastName,  JTextField vote) {
        try {
            this.daoVoters.updateVoters(new Voters(this.id, Integer.parseInt(idNumber.getText()), name.getText(), lastName.getText(), Integer.parseInt(vote.getText())));
            JOptionPane.showMessageDialog(null, "Votante modificado exitosamente");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error de formato : " + e.toString());
        }
    }

    public void deleteVoter() {
        this.daoVoters.deleteVoters(this.id);
    }

    public void getIDVoter(JComboBox voter) {
        this.voterID = this.daoVoters.getIDVoters(voter.getSelectedItem().toString());
    }

     public void getIDCandidate(JComboBox candidate) {
        this.candidateID = this.daoCandi.getIDCandidate(candidate.getSelectedItem().toString());
    }
    
    public void loadVoter(JComboBox s) {
        List<Voters> votersList = this.daoVoters.readVoters();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Voters voter : votersList) {
            model.addElement(voter.getName());
        }
        s.setModel(model);
    }

    public String selectedRow(JTable table, JTextField name, JTextField lastName, JTextField IDNumber, JTextField vote) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                lastName.setText(table.getValueAt(row, 2).toString());
                IDNumber.setText(table.getValueAt(row, 3).toString());
                vote.setText(table.getValueAt(row, 4).toString());
            } else {
                JOptionPane.showMessageDialog(null, "No se selecciono fila");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de seleccion: " + e.toString());
        }
        return "";  // Return some value as needed
    }

    public void clearFields(JTextField name, JTextField lastName, JTextField IDNumber, JTextField vote) {
        name.setText("");
        lastName.setText("");
        IDNumber.setText("");
        vote.setText("");
    }
    
    public void authenticateVoter(String ID) {
        Voters voters = null;
        voters = daoVoters.authenticateVoter(ID);
        frmVoter voteForms = new frmVoter(voters);
    }
}

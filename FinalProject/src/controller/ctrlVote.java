/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Vote;
import model.*;
/**
 *
 * @author JRS
 */
public class ctrlVote {
    private candidateDAO daoCandi = new candidateDAO();
    private VoteDAO daoVote = new VoteDAO();
    private partieDAO partiDAO = new partieDAO();
    private VotersDAO votersDAO = new VotersDAO();
    private int id, voteID, candidateID,voterID;

    public void loadDataVotes(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<Vote> votesList = daoVote.readVote();
        for (Vote vote : votesList) {
            Object[] row = {vote.getId(), this.votersDAO.getNameVoters(vote.getIDVoter()), this.daoCandi.getNameCandidate(vote.getIDCandidate()), vote.getIDVote()};
            model.addRow(row);
        }
    }

    public void addVote(JComboBox idVoter, JComboBox idCandidate, JTextField idVote) {
        try {
            this.daoVote.createVote(new Vote(this.id, this.voterID, this.candidateID, Integer.parseInt(idVote.getText())));
            JOptionPane.showMessageDialog(null, "Voto añadido exitosamente");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato: " + e.toString());
        }
    }

    public void updateVote(JComboBox idVoter, JComboBox idCandidate, JTextField idVote) {
        try {
            this.daoVote.updateVote(new Vote(this.id, this.voterID, this.candidateID, Integer.parseInt(idVote.getText())));
            JOptionPane.showMessageDialog(null, "Voto modificado exitosamente");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato: " + e.toString());
        }
    }

    public void deleteVote() {
        this.daoVote.deleteVote(this.id);
    }

    public void getIDVote(JComboBox vote) {
        this.voteID = this.daoVote.getIDVote(vote.getSelectedItem().toString());
    }
    
    public void getIDCandidate(JComboBox vote) {
        this.candidateID = this.daoCandi.getIDCandidate(vote.getSelectedItem().toString());
    }
    
    public void getIDVoter(JComboBox vote) {
        this.voterID = this.votersDAO.getIDVoters(vote.getSelectedItem().toString());
    }

    public void loadVote(JComboBox s) {
        List<Vote> votesList = this.daoVote.readVote();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Vote vote : votesList) {
            model.addElement(Integer.toString(vote.getIDVote()));
        }
        s.setModel(model);
    }

    public String selectedRow(JTable table, JComboBox idVoter, JComboBox idCandidate, JTextField idVote) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                idVoter.setSelectedItem(table.getValueAt(row, 1).toString());
                idCandidate.setSelectedItem(table.getValueAt(row, 2).toString());
                idVote.setText(table.getValueAt(row, 3).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de seleccion : " + e.toString());
        }
        return "";  
    }

    public void clearFields(JTextField idVoter, JTextField idParty, JTextField idVote) {
        idVoter.setText("");
        idParty.setText("");
        idVote.setText("");
    }
}

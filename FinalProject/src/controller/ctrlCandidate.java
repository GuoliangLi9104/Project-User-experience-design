/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.candidate;
import model.candidateDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import model.*;

/**
 *
 * @author JRS
 */
public class ctrlCandidate {
    private candidateDAO daoCandi = new candidateDAO();
    private int id, candidateID;

    public void loadDataCandidates(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<candidate> candidates = daoCandi.readCandidate();
        for (candidate Candidate : candidates) {
            Object[] row = {Candidate.getId(), Candidate.getName(), Candidate.getLastName(), Candidate.getPicture(), Candidate.getId_party()};
            model.addRow(row);
        }
    }

    public void addCandidate(JTextField name, JTextField lastName, String picture, JTextField id_party) {
        try {
            this.daoCandi.createCandidate(new candidate(0, name.getText(), lastName.getText(), picture, Integer.parseInt(id_party.getText())));
            JOptionPane.showMessageDialog(null, "Candidato agregado con éxito");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de datos: " + e.toString());
        }
    }

    public void updateCandidate(JTextField name, JTextField lastName, String picture, JTextField id_party) {
        try {
            this.daoCandi.updateCandidate(new candidate(this.id, name.getText(), lastName.getText(), picture, Integer.parseInt(id_party.getText())));
            JOptionPane.showMessageDialog(null, "Candidato actualizado con éxito");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de datos: " + e.toString());
        }
    }

    public void deleteCandidate() {
        this.daoCandi.deleteCandidate(this.id);
    }

    public void getIDCandidate(JComboBox candidate) {
        this.candidateID = this.daoCandi.getIDCandidate(candidate.getSelectedItem().toString());
    }

    public void loadCandidate(JComboBox s) {
        List<candidate> candidates = this.daoCandi.readCandidate();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (candidate Candidate : candidates) {
            model.addElement(Candidate.getName());
        }
        s.setModel(model);
    }
    
    
  public String selectedRow(JTable table, JTextField name, JTextField lastName, String picture, JComboBox id_party) {
  String imagen = "";  // Holds the picture route
    try {
        int row = table.getSelectedRow();
        if (row >= 0) {
            this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
            name.setText(table.getValueAt(row, 1).toString());
            lastName.setText(table.getValueAt(row, 2).toString());
            imagen = table.getValueAt(row, 3).toString();
            id_party.setSelectedItem(table.getValueAt(row, 4).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
    }
    return imagen;  // Devuelve la ruta de la imagen
}

    public void clearFields(JTextField name, JTextField lastName, JTextField id_party) {
        name.setText("");
        lastName.setText("");
        id_party.setText("");
    }
}
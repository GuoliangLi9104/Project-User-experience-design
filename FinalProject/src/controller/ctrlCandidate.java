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
import java.sql.Blob;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author JRS
 */
public class ctrlCandidate {
    private candidateDAO dao = new candidateDAO();
    private int id;

    public void loadDataCandidates(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<candidate> candidates = dao.read();
        for (candidate Candidate : candidates) {
            Object[] row = {Candidate.getId(), Candidate.getName(), Candidate.getLastName(), Candidate.getPicture(), Candidate.getId_party()};
            model.addRow(row);
        }
    }

    public void addCandidate(JTextField name, JTextField lastName, Blob picture, JTextField id_party) {
        try {
            this.dao.create(new candidate(0, name.getText(), lastName.getText(), picture, Integer.parseInt(id_party.getText())));
            JOptionPane.showMessageDialog(null, "Candidato agregado con éxito");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de datos: " + e.toString());
        }
    }

    public void updateCandidate(JTextField name, JTextField lastName, Blob picture, JTextField id_party) {
        try {
            this.dao.update(new candidate(this.id, name.getText(), lastName.getText(), picture, Integer.parseInt(id_party.getText())));
            JOptionPane.showMessageDialog(null, "Candidato actualizado con éxito");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de datos: " + e.toString());
        }
    }

    public void deleteCandidate() {
        this.dao.delete(this.id);
    }

  public void selectedRow(JTable table, JTextField name, JTextField lastName, JLabel picture, JTextField id_party) {
    try {
        int row = table.getSelectedRow();
        if (row >= 0) {
            this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
            name.setText(table.getValueAt(row, 1).toString());
            lastName.setText(table.getValueAt(row, 2).toString());
            id_party.setText(table.getValueAt(row, 4).toString());
            
            // Gets the picture Blob from the database and shows it in the view
            Blob pictureBlob = (Blob) table.getValueAt(row, 3); 
            byte[] pictureBytes = pictureBlob.getBytes(1, (int) pictureBlob.length());
            ImageIcon imageIcon = new ImageIcon(pictureBytes);
            picture.setIcon(imageIcon);
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
    }
}

    public void clearFields(JTextField name, JTextField lastName, JTextField id_party) {
        name.setText("");
        lastName.setText("");
        id_party.setText("");
    }
}
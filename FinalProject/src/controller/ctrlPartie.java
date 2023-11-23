/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.partie;
import model.partieDAO;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author JRS
 */
    public class ctrlPartie {
    private partieDAO daoPartie = new partieDAO();
    private int id, partieID;
   

    public void loadDataParties(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<partie> parties = daoPartie.readParties();
        for (partie partie : parties) {
            Object[] row = {partie.getId(), partie.getName(), partie.getId_candidate()};
            model.addRow(row);
        }
    }

    public void addPartie(JTextField name, JTextField id_candidate) {
        try {
            this.daoPartie.create(new partie(0, name.getText(), Integer.parseInt(id_candidate.getText())));
            JOptionPane.showMessageDialog(null, "Partie added successfully");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error in data format: " + e.toString());
        }
    }

    public void updatePartie(JTextField name, JTextField id_candidate) {
        try {
            this.daoPartie.updateParties(new partie(this.id, name.getText(), Integer.parseInt(id_candidate.getText())));
            JOptionPane.showMessageDialog(null, "Partie updated successfully");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error in data format: " + e.toString());
        }
    }

    public void deletePartie() {
        this.daoPartie.deleteParties(this.id);
    }

    public void getIDPartie(JComboBox partie) {
        this.partieID = this.daoPartie.getIDParty(partie.getSelectedItem().toString());
    }

    public void loadPartie(JComboBox s) {
        List<partie> parties = this.daoPartie.readParties();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (partie partie : parties) {
            model.addElement(partie.getName());
        }
        s.setModel(model);
    }

    public String selectedRow(JTable table, JTextField name, JTextField id_candidate) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                id_candidate.setText(table.getValueAt(row, 2).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Row not selected");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selection error, error: " + e.toString());
        }
        return "";  // Return the picture path (not handled in this code)
    }

    public void clearFields(JTextField name, JTextField id_candidate) {
        name.setText("");
        id_candidate.setText("");
    }
    
    public void getIdParty(JComboBox Party) {
        this.partieID = this.daoPartie.getIDParty(Party.getSelectedItem().toString());
    }
     public void loadParty(JComboBox s) {
        List<partie> parties = this.daoPartie.readParties();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (partie Party : parties) {
            model.addElement(Party.getName());
        }
        s.setModel(model);
    }
    
}

    
    


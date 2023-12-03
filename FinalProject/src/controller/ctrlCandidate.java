/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.URL;
import model.candidate;
import model.candidateDAO;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.*;
import view.*;

/**
 *
 * @author JRS
 */
public class ctrlCandidate {

    private candidateDAO daoCandi = new candidateDAO();
    private partieDAO partiDAO = new partieDAO();
    private ctrlVote ctrlVote = new ctrlVote();
    private ctrlVoters ctrlVoters = new ctrlVoters();
    private VotersDAO daoVoters = new VotersDAO();
    private frmLogin login = new frmLogin();
    private int id, candidateID, partyID;

    public void loadDataCandidates(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<candidate> candidates = daoCandi.readCandidate();
        for (candidate Candidate : candidates) {
            Object[] row = {Candidate.getId(), Candidate.getName(), Candidate.getLastName(), Candidate.getPicture(), this.partiDAO.getNameParty(Candidate.getId_party())};
            model.addRow(row);
        }
    }

    public void addCandidate(JTextField name, JTextField lastName, String picture, JComboBox id_party) {
        try {
            this.daoCandi.createCandidate(new candidate(0, name.getText(), lastName.getText(), picture, this.partyID));
            JOptionPane.showMessageDialog(null, "Candidato agregado con éxito");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de datos: " + e.toString());
        }
    }

    public void updateCandidate(JTextField name, JTextField lastName, String picture, JComboBox id_party) {
        try {
            this.daoCandi.updateCandidate(new candidate(this.id, name.getText(), lastName.getText(), picture, this.partyID));
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

    public void getIdParty(JComboBox Party) {
        this.partyID = this.partiDAO.getIDParty(Party.getSelectedItem().toString());
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
    }

    public void displayCanditates(JScrollPane scrollPane, Voters voter, frmVoter frmVoterRef) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        List<candidate> candidates = daoCandi.readCandidate();

        for (candidate Candidate : candidates) {
            JPanel canditatePanel = new JPanel();
            canditatePanel.setPreferredSize(new Dimension(300, 200));
            canditatePanel.setBorder(BorderFactory.createTitledBorder(canditatePanel.getName()));
            canditatePanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            // JLabel for ID
            gbc.gridx = 0;
            gbc.gridy = 0;
            canditatePanel.add(new JLabel("ID: " + Candidate.getId()), gbc);

            // JLabel for Name
            gbc.gridy++;
            canditatePanel.add(new JLabel("Nombre: " + Candidate.getName()), gbc);

            // JLabel for Category
            gbc.gridy++;
            canditatePanel.add(new JLabel("Apellido: " + Candidate.getLastName()), gbc);

            // JLabel for Image
            gbc.gridy++;
            try {
                String Imagen = Candidate.getPicture();
                ImageIcon icon = new ImageIcon(Imagen);
                Image originalImage = icon.getImage();
                Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);

                JLabel imageLabel = new JLabel(resizedIcon);

                canditatePanel.add(imageLabel, gbc);
            } catch (Exception e) {
                canditatePanel.add(new JLabel("Image not available"), gbc);
            }

            // JLabel for Instructions
            gbc.gridy++;
            canditatePanel.add(new JLabel("Partido: " + this.partiDAO.getNameParty(Candidate.getId_party())), gbc);

            
            gbc.gridy++;
            JButton showDataButton = new JButton("Votar");
            showDataButton.addActionListener(e -> {
                // Método para mostrar datos (puedes reemplazar esto con tu lógica específica)
                Votes(Candidate, voter);
                // Mostrar nueva ventana y cerrar la actual
                //frmVoterRef.dispose();  // Cerrar la ventana actual
            });
            canditatePanel.add(showDataButton, gbc);
            mainPanel.add(canditatePanel);

        }
        scrollPane.setViewportView(mainPanel);
    }

    private void Votes(candidate Candidate, Voters voter) {
        ctrlVote.addVote(voter.getId(), Candidate.getId(), 1);
        daoVoters.decreaseVote(voter);
    }

}

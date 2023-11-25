/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.*;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author Li
 */
public class frmAdmin extends javax.swing.JFrame {

    ctrlCandidate ctrlc = new ctrlCandidate();
    ctrlPartie ctrlp = new ctrlPartie();
    ctrlVote ctrlVote = new ctrlVote();
    ctrlVoters ctrlVoter = new ctrlVoters();

    /**
     * Creates new form frmAdmin
     */
    public frmAdmin() {
        initComponents();
        this.loadCbxCandidatesParty();
        this.chargetableAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPMain = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCandidates = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        lblImagenCandi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbxCanditatesParty = new javax.swing.JComboBox<>();
        txtNameCandi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtLastNameCandi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnDeleteCandidates = new javax.swing.JButton();
        btnModifyCandidates = new javax.swing.JButton();
        btnCreateCandidates = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblVoteVoters = new javax.swing.JLabel();
        lblIDVoters = new javax.swing.JLabel();
        lblLastNameVoters = new javax.swing.JLabel();
        lblNameVoters = new javax.swing.JLabel();
        txtLastNameVoters = new javax.swing.JTextField();
        txtNameVoters = new javax.swing.JTextField();
        txtIDVoters = new javax.swing.JTextField();
        txtVoteVoters = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTableVoters = new javax.swing.JTable();
        btnCreateVoters = new javax.swing.JButton();
        btnDeleteVoters = new javax.swing.JButton();
        btnModifyVoters = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxNameVotes = new javax.swing.JComboBox<>();
        cbxPartyVotes = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTableVote = new javax.swing.JTable();
        btnCreateVote = new javax.swing.JButton();
        btnDeleteVotes = new javax.swing.JButton();
        btnModifyVotes = new javax.swing.JButton();
        txtVotesVotes = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNameParty = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTableParty = new javax.swing.JTable();
        btnCreateParty = new javax.swing.JButton();
        btnDeleteParty = new javax.swing.JButton();
        btnModifyParty = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPMain.setMinimumSize(new java.awt.Dimension(700, 500));
        JPMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCandidates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Imagen", "Partido"
            }
        ));
        tblCandidates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCandidatesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCandidates);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 800, 290));

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(lblImagenCandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 170, 150));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Imagen:");
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        cbxCanditatesParty.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbxCanditatesParty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCanditatesParty.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCanditatesPartyItemStateChanged(evt);
            }
        });
        cbxCanditatesParty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCanditatesPartyActionPerformed(evt);
            }
        });
        jPanel9.add(cbxCanditatesParty, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 290, -1));

        txtNameCandi.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel9.add(txtNameCandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 200, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre:");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Partido:");
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido:");
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtLastNameCandi.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel9.add(txtLastNameCandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 270, -1));

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 40, 40));

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 650, 240));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteCandidates.setText("Eliminar");
        jPanel10.add(btnDeleteCandidates, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, -1));

        btnModifyCandidates.setText("Modificar");
        btnModifyCandidates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyCandidatesActionPerformed(evt);
            }
        });
        jPanel10.add(btnModifyCandidates, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btnCreateCandidates.setText("Agregar");
        btnCreateCandidates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCandidatesActionPerformed(evt);
            }
        });
        jPanel10.add(btnCreateCandidates, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, -1));

        jPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 100, 120));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Candidatos", jPanel1);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVoteVoters.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblVoteVoters.setForeground(new java.awt.Color(0, 0, 0));
        lblVoteVoters.setText("Voto:");
        jPanel6.add(lblVoteVoters, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        lblIDVoters.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblIDVoters.setForeground(new java.awt.Color(0, 0, 0));
        lblIDVoters.setText("Cedula:");
        jPanel6.add(lblIDVoters, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        lblLastNameVoters.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblLastNameVoters.setForeground(new java.awt.Color(0, 0, 0));
        lblLastNameVoters.setText("Apellido:");
        jPanel6.add(lblLastNameVoters, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, -1));

        lblNameVoters.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNameVoters.setForeground(new java.awt.Color(0, 0, 0));
        lblNameVoters.setText("Nombre:");
        jPanel6.add(lblNameVoters, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtLastNameVoters.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel6.add(txtLastNameVoters, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 180, -1));

        txtNameVoters.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel6.add(txtNameVoters, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 180, -1));

        txtIDVoters.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel6.add(txtIDVoters, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 180, -1));

        txtVoteVoters.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel6.add(txtVoteVoters, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 180, -1));

        tblTableVoters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Cedula", "Voto"
            }
        ));
        tblTableVoters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableVotersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTableVoters);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 800, 360));

        btnCreateVoters.setText("Agregar");
        btnCreateVoters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateVotersActionPerformed(evt);
            }
        });
        jPanel6.add(btnCreateVoters, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 80, -1));

        btnDeleteVoters.setText("Eliminar");
        btnDeleteVoters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteVotersActionPerformed(evt);
            }
        });
        jPanel6.add(btnDeleteVoters, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 80, -1));

        btnModifyVoters.setText("Modificar");
        btnModifyVoters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyVotersActionPerformed(evt);
            }
        });
        jPanel6.add(btnModifyVoters, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Votantes", jPanel3);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Partido:");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Voto:");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Nombre:");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        cbxNameVotes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbxNameVotes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel7.add(cbxNameVotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 180, -1));

        cbxPartyVotes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbxPartyVotes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel7.add(cbxPartyVotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 180, -1));

        tblTableVote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblTableVote);

        jPanel7.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 800, 360));

        btnCreateVote.setText("Agregar");
        jPanel7.add(btnCreateVote, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 80, -1));

        btnDeleteVotes.setText("Eliminar");
        jPanel7.add(btnDeleteVotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 80, -1));

        btnModifyVotes.setText("Modificar");
        jPanel7.add(btnModifyVotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, -1, -1));

        txtVotesVotes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel7.add(txtVotesVotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 190, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Votos", jPanel4);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nombre:");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtNameParty.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel8.add(txtNameParty, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 520, -1));

        tblTableParty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        tblTableParty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablePartyMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTableParty);

        jPanel8.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 800, 360));

        btnCreateParty.setText("Agregar");
        btnCreateParty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePartyActionPerformed(evt);
            }
        });
        jPanel8.add(btnCreateParty, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 80, -1));

        btnDeleteParty.setText("Eliminar");
        btnDeleteParty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePartyActionPerformed(evt);
            }
        });
        jPanel8.add(btnDeleteParty, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 80, -1));

        btnModifyParty.setText("Modificar");
        btnModifyParty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyPartyActionPerformed(evt);
            }
        });
        jPanel8.add(btnModifyParty, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Partidos", jPanel2);

        JPMain.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        getContentPane().add(JPMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\Li\\Music\\Project-User-experience-design\\FinalProject\\Imagenes"));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String imageName = "Imagenes/" + fileChooser.getSelectedFile().getName();
            this.imagenIcon(imageName);
    }//GEN-LAST:event_jButton1ActionPerformed
    }
    private void tblCandidatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCandidatesMouseClicked
        String imagen = "";
        imagen = ctrlc.selectedRow(tblCandidates, txtNameCandi, txtLastNameCandi, imagen, cbxCanditatesParty);
        this.imagenIcon(imagen);
    }//GEN-LAST:event_tblCandidatesMouseClicked

    private void cbxCanditatesPartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCanditatesPartyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCanditatesPartyActionPerformed

    private void tblTableVotersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableVotersMouseClicked
        ctrlVoter.selectedRow(tblTableVoters, txtNameVoters, txtLastNameVoters, txtIDVoters, txtVoteVoters);
    }//GEN-LAST:event_tblTableVotersMouseClicked

    private void tblTablePartyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablePartyMouseClicked
        ctrlp.selectedRow(tblTableParty, txtNameParty);
    }//GEN-LAST:event_tblTablePartyMouseClicked

    private void cbxCanditatesPartyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCanditatesPartyItemStateChanged
        this.ctrlp.getIdParty(cbxCanditatesParty);
    }//GEN-LAST:event_cbxCanditatesPartyItemStateChanged

    private void btnCreateCandidatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCandidatesActionPerformed
        String picture = getCurrentImageName();
        ctrlc.addCandidate(txtNameCandi, txtLastNameCandi, picture, cbxCanditatesParty);
    }//GEN-LAST:event_btnCreateCandidatesActionPerformed

    private void btnModifyCandidatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyCandidatesActionPerformed


    }//GEN-LAST:event_btnModifyCandidatesActionPerformed

    private void btnCreateVotersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateVotersActionPerformed
       ctrlVoter.addVoter(txtIDVoters, txtNameVoters, txtLastNameVoters, txtVoteVoters);
       ctrlVoter.loadDataVoters(tblTableVoters);
    }//GEN-LAST:event_btnCreateVotersActionPerformed

    private void btnModifyVotersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyVotersActionPerformed
        ctrlVoter.updateVoter(txtIDVoters, txtNameVoters, txtLastNameVoters, txtVoteVoters);
        ctrlVoter.loadDataVoters(tblTableVoters);
    }//GEN-LAST:event_btnModifyVotersActionPerformed

    private void btnDeleteVotersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteVotersActionPerformed
        ctrlVoter.deleteVoter();
        ctrlVoter.loadDataVoters(tblTableVoters);
    }//GEN-LAST:event_btnDeleteVotersActionPerformed

    private void btnCreatePartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePartyActionPerformed
        ctrlp.addPartie(txtNameParty);
        ctrlp.loadDataParties(tblTableParty);
    }//GEN-LAST:event_btnCreatePartyActionPerformed

    private void btnModifyPartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyPartyActionPerformed
       ctrlp.updatePartie(txtNameParty);
        ctrlp.loadDataParties(tblTableParty);
    }//GEN-LAST:event_btnModifyPartyActionPerformed

    private void btnDeletePartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePartyActionPerformed
        ctrlp.deletePartie();
        ctrlp.loadDataParties(tblTableParty);
    }//GEN-LAST:event_btnDeletePartyActionPerformed

    public void chargetableAll() {
        ctrlc.loadDataCandidates(tblCandidates);
        ctrlVote.loadDataVotes(tblTableVote);
        ctrlp.loadDataParties(tblTableParty);
        ctrlVoter.loadDataVoters(tblTableVoters);
    }

    public void imagenIcon(String name) {
        ImageIcon Imagen = new ImageIcon(name);
        this.lblImagenCandi.setIcon(Imagen);
        this.lblImagenCandi.putClientProperty("nameImagen", name);
    }

    public void loadCbxCandidatesParty() {
        this.ctrlp.getIdParty(cbxCanditatesParty);
        this.ctrlp.loadParty(cbxCanditatesParty);
    }

    public String getCurrentImageName() {
        return (String) this.lblImagenCandi.getClientProperty("nameImagen");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdmin().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPMain;
    private javax.swing.JButton btnCreateCandidates;
    private javax.swing.JButton btnCreateParty;
    private javax.swing.JButton btnCreateVote;
    private javax.swing.JButton btnCreateVoters;
    private javax.swing.JButton btnDeleteCandidates;
    private javax.swing.JButton btnDeleteParty;
    private javax.swing.JButton btnDeleteVoters;
    private javax.swing.JButton btnDeleteVotes;
    private javax.swing.JButton btnModifyCandidates;
    private javax.swing.JButton btnModifyParty;
    private javax.swing.JButton btnModifyVoters;
    private javax.swing.JButton btnModifyVotes;
    private javax.swing.JComboBox<String> cbxCanditatesParty;
    private javax.swing.JComboBox<String> cbxNameVotes;
    private javax.swing.JComboBox<String> cbxPartyVotes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblIDVoters;
    private javax.swing.JLabel lblImagenCandi;
    private javax.swing.JLabel lblLastNameVoters;
    private javax.swing.JLabel lblNameVoters;
    private javax.swing.JLabel lblVoteVoters;
    private javax.swing.JTable tblCandidates;
    private javax.swing.JTable tblTableParty;
    private javax.swing.JTable tblTableVote;
    private javax.swing.JTable tblTableVoters;
    private javax.swing.JTextField txtIDVoters;
    private javax.swing.JTextField txtLastNameCandi;
    private javax.swing.JTextField txtLastNameVoters;
    private javax.swing.JTextField txtNameCandi;
    private javax.swing.JTextField txtNameParty;
    private javax.swing.JTextField txtNameVoters;
    private javax.swing.JTextField txtVoteVoters;
    private javax.swing.JTextField txtVotesVotes;
    // End of variables declaration//GEN-END:variables
}

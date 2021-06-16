/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak_alproii_pertemuan8_modul7;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ACER
 */
public class HalamanUtama1 extends javax.swing.JFrame {

    private static final String username = "root";
    private static final String password = "";
    private static final String dataConn = "jdbc:mysql://localhost:3306/manajemen_jadwal";

    DefaultTableModel mod;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i;
    FrameUpdateDelete updatedelete = new FrameUpdateDelete();

    /**
     * Creates new form HalamanUtama
     */
    public HalamanUtama1() {
        initComponents();
        tampil();
    }

    public void tampil() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dataConn, username, password);
            pst = con.prepareStatement("select * from data");

            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            q = stData.getColumnCount();

            DefaultTableModel mod = (DefaultTableModel) TabelJadwal.getModel();
            mod.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString("maskapai"));
                    columnData.add(rs.getString("dari"));
                    columnData.add(rs.getString("menuju"));
                    columnData.add(rs.getString("berangkat"));
                    columnData.add(rs.getString("tiba"));
                    columnData.add(rs.getString("tipe"));
                    columnData.add(rs.getString("harga"));
                }
                mod.addRow(columnData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void hapusdb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dataConn, username, password);
            pst = con.prepareStatement("select * from data");
            Object[] columnData = new Object[7];

            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            q = stData.getColumnCount();

            DefaultTableModel mod = (DefaultTableModel) TabelJadwal.getModel();
            mod.setRowCount(0);

            while (rs.next()) {
                columnData[0] = rs.getString("maskapai");
                columnData[1] = rs.getString("dari");
                columnData[2] = rs.getString("menuju");
                columnData[3] = rs.getString("berangkat");
                columnData[4] = rs.getString("tiba");
                columnData[5] = rs.getString("tipe");
                columnData[6] = rs.getString("harga");
                mod.addRow(columnData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void kosongkan() {
        txtBerangkat.setEditable(true);
        cbMaskapai.setSelectedIndex(0);
        cbDari.setSelectedIndex(0);
        cbMenuju.setSelectedIndex(0);
        txtBerangkat.setText("");
        txtTiba.setText("");
        rdTipe.clearSelection();
        txtHarga.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        rdTipe = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbMaskapai = new javax.swing.JComboBox<>();
        cbDari = new javax.swing.JComboBox<>();
        cbMenuju = new javax.swing.JComboBox<>();
        txtBerangkat = new javax.swing.JTextField();
        txtTiba = new javax.swing.JTextField();
        rdEkonomi = new javax.swing.JRadioButton();
        rdBisnis = new javax.swing.JRadioButton();
        rdEksekutif = new javax.swing.JRadioButton();
        txtHarga = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnKosongkan = new javax.swing.JButton();
        btnCetakReport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelJadwal = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuItemCreate = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuItemEditDelete = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("MANAJEMEN JADWAL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 136, 11, 131);
        jPanel1.add(jLabel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Maskapai");

        jLabel3.setText("Dari");

        jLabel4.setText("Menuju");

        jLabel5.setText("Berangkat");

        jLabel6.setText("Tiba");

        jLabel7.setText("Tipe");

        jLabel8.setText("Harga");

        cbMaskapai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Garuda Indonesia", "Air Asia", "Sriwijaya Air", "Lion Air", "Dulinan Air" }));

        cbDari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bandar Udara Internasional Soekarno-Hatta", "Bandar Udara Internasional Ngurah Rai", "Bandar Udara Internasional Juanda" }));

        cbMenuju.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bandar Udara Internasionall Sultan Hasanuddin", "Bandar Udara Internasional Kualanamu", "Bandar Udara Internasional Lombok", "Eternity" }));

        rdTipe.add(rdEkonomi);
        rdEkonomi.setText("Ekonomi");

        rdTipe.add(rdBisnis);
        rdBisnis.setText("Bisnis");

        rdTipe.add(rdEksekutif);
        rdEksekutif.setText("Eksekutif");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdEkonomi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdBisnis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdEksekutif))
                    .addComponent(cbMaskapai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbDari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMenuju, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBerangkat)
                    .addComponent(txtHarga)
                    .addComponent(txtTiba))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMaskapai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbDari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbMenuju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTiba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rdEkonomi)
                    .addComponent(rdBisnis)
                    .addComponent(rdEksekutif))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        btnKosongkan.setText("Kosong");
        btnKosongkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKosongkanActionPerformed(evt);
            }
        });

        btnCetakReport.setText("Cetak Report");
        btnCetakReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKosongkan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetakReport))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKosongkan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnCetakReport)
                .addContainerGap())
        );

        TabelJadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Maskapai", "Dari", "Menuju", "Berangkat", "Tiba", "Tipe", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelJadwalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelJadwal);

        jLabel9.setText("jLabel9");

        jMenu1.setText("Tambah");

        MenuItemCreate.setText("Create");
        MenuItemCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCreateActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemCreate);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        MenuItemEditDelete.setText("Edit + Delete");
        MenuItemEditDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemEditDeleteActionPerformed(evt);
            }
        });
        jMenu2.add(MenuItemEditDelete);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel9)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakReportActionPerformed
        // TODO add your handling code here:
        try {
            HashMap parameter = new HashMap();
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl = "jdbc:mysql://localhost:3306/manajemen_jadwal";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(dburl, username, password);
            File file = new File ("src/prak_alproii_pertemuan8_modul7/reportlatihan7.jasper");
            JasperReport jr = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, con);
            JasperViewer.viewReport(jp, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Data gagal dicetak!!" + "\n" + e.getMessage(), "Cetak Data",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCetakReportActionPerformed

    private void TabelJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelJadwalMouseClicked
        // TODO add your handling code here:
        int baris = TabelJadwal.rowAtPoint(evt.getPoint());

        String ls_maskapai = TabelJadwal.getValueAt(baris, 0).toString();
        cbMaskapai.setSelectedItem(ls_maskapai);
        String ls_dari = TabelJadwal.getValueAt(baris, 1).toString();
        cbDari.setSelectedItem(ls_dari);
        String ls_menuju = TabelJadwal.getValueAt(baris, 2).toString();
        cbMenuju.setSelectedItem(ls_menuju);
        String ls_berangkat = TabelJadwal.getValueAt(baris, 3).toString();
        txtBerangkat.setText(ls_berangkat);
        String ls_tiba = TabelJadwal.getValueAt(baris, 4).toString();
        txtTiba.setText(ls_tiba);
        Object rdTipe = TabelJadwal.getValueAt(baris, 5).toString();
        if (rdTipe.equals("Ekonomi")) {
            rdEkonomi.setSelected(true);
        } else if (rdTipe.equals("Bisnis")) {
            rdBisnis.setSelected(true);
        } else if (rdTipe.equals("Eksekutif")) {
            rdEksekutif.setSelected(true);
        }
        String ls_harga = TabelJadwal.getValueAt(baris, 6).toString();
        txtHarga.setText(ls_harga);

        updatedelete.getdata(ls_maskapai, ls_dari, ls_menuju, ls_berangkat, ls_tiba, (String) rdTipe, ls_harga);
    }//GEN-LAST:event_TabelJadwalMouseClicked

    private void btnKosongkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKosongkanActionPerformed
        // TODO add your handling code here:
        kosongkan();
    }//GEN-LAST:event_btnKosongkanActionPerformed

    private void MenuItemCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCreateActionPerformed
        // TODO add your handling code here
        this.setVisible(false);
        new FrameCreate().setVisible(true);
    }//GEN-LAST:event_MenuItemCreateActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void MenuItemEditDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemEditDeleteActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        updatedelete.setVisible(true);
    }//GEN-LAST:event_MenuItemEditDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(HalamanUtama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HalamanUtama1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuItemCreate;
    private javax.swing.JMenuItem MenuItemEditDelete;
    private javax.swing.JTable TabelJadwal;
    private javax.swing.JButton btnCetakReport;
    private javax.swing.JButton btnKosongkan;
    private javax.swing.JComboBox<String> cbDari;
    private javax.swing.JComboBox<String> cbMaskapai;
    private javax.swing.JComboBox<String> cbMenuju;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdBisnis;
    private javax.swing.JRadioButton rdEkonomi;
    private javax.swing.JRadioButton rdEksekutif;
    private javax.swing.ButtonGroup rdTipe;
    private javax.swing.JTextField txtBerangkat;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtTiba;
    // End of variables declaration//GEN-END:variables
}

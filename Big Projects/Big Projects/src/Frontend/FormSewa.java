/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

/**
 *
 * @author USER
 */
import Backend.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class FormSewa extends javax.swing.JFrame {

    /**
     * Creates new form FormSewa
     */
    public FormSewa() {
        initComponents();
        tampilkanDataMobil();
        kosongkanForm();
        tampilkanCmbView();
        tampilkanData();
        hitungHari();
    }

    public void kosongkanForm() {
        txtIdPeminjaman.setText("0");
        txtNoPol.setText("");
        txtTglPinjam.setText("0");
        txtBlnPinjam.setText("0");
        txtThnPinjam.setText("0");
        txtJamPinjam.setText("0");
        txtMntPinjam.setText("0");
        txtDtkPinjam.setText("0");
        txtTglKembali.setText("0");
        txtBlnKembali.setText("0");
        txtThnKembali.setText("0");
        txtJamKembali.setText("0");
        txtMntKembali.setText("0");
        txtDtkKembali.setText("0");

    }

    public void tampilkanCmbView() {
        DefaultComboBoxModel mdl = new DefaultComboBoxModel();
        cmbViewMobil.setModel(mdl);
        mdl.addElement("View All");
        mdl.addElement("Mobil Keluarga");
        mdl.addElement("Mobil PickUp");

    }

    public void tampilkanDataMobil() {
        String[] kolom = {"ID Mobil", "Jenis", "No Polisi", "Merk", "Warna", "Nama", "Harga Sewa / Hr"};
        ArrayList<MobilKeluarga> list = new MobilKeluarga().getAll();
        ArrayList<MobilPickUp> listp = new MobilPickUp().getAll();
        Object rowData[] = new Object[7];

        tblMobil.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getIdMobil();
            rowData[1] = list.get(i).getJenis().getJenis();
            rowData[2] = list.get(i).getNopol();
            rowData[3] = list.get(i).getMerkMobil();
            rowData[4] = list.get(i).getWarnaMobil();
            rowData[5] = list.get(i).getNamaMobil();
            rowData[6] = list.get(i).getJenis().getHargaSewa();

            ((DefaultTableModel) tblMobil.getModel()).addRow(rowData);
        }
        for (int a = 0; a < listp.size(); a++) {
            rowData[0] = listp.get(a).getIdPickUp();
            rowData[1] = listp.get(a).getJenis().getJenis();
            rowData[2] = listp.get(a).getNopol();
            rowData[3] = listp.get(a).getMerkPickUp();
            rowData[4] = listp.get(a).getWarnaPickUp();
            rowData[5] = listp.get(a).getNamaPickUp();
            rowData[6] = listp.get(a).getJenis().getHargaSewa();

            ((DefaultTableModel) tblMobil.getModel()).addRow(rowData);
        }
    }

    public void cariMobil(String keyword) {
        String[] kolom = {"ID Mobil", "Jenis", "No Polisi", "Merk", "Warna", "Nama", "Harga Sewa / Hr"};
        ArrayList<MobilKeluarga> list = new MobilKeluarga().search(keyword);
        ArrayList<MobilPickUp> listp = new MobilPickUp().search(keyword);

        Object rowData[] = new Object[7];

        tblMobil.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (MobilKeluarga mk : list) {
            rowData[0] = mk.getIdMobil();
            rowData[1] = mk.getJenis().getJenis();
            rowData[2] = mk.getNopol();
            rowData[3] = mk.getMerkMobil();
            rowData[4] = mk.getWarnaMobil();
            rowData[5] = mk.getNamaMobil();
            rowData[6] = mk.getJenis().getHargaSewa();

            ((DefaultTableModel) tblMobil.getModel()).addRow(rowData);
        }
        for (MobilPickUp mp : listp) {
            rowData[0] = mp.getIdPickUp();
            rowData[1] = mp.getJenis().getJenis();
            rowData[2] = mp.getNopol();
            rowData[3] = mp.getMerkPickUp();
            rowData[4] = mp.getWarnaPickUp();
            rowData[5] = mp.getNamaPickUp();
            rowData[6] = mp.getJenis().getHargaSewa();

            ((DefaultTableModel) tblMobil.getModel()).addRow(rowData);

        }
    }

    public int hitungHari() {
        int x = 0;
        if (txtBlnKembali.getText().equals(txtBlnPinjam.getText()) && txtThnKembali.getText().equals(txtThnPinjam.getText())) {
            int tglK = Integer.parseInt(txtTglKembali.getText());
            int tglP = Integer.parseInt(txtTglPinjam.getText());
            x = tglK - tglP;
        } else {
            int blnP = Integer.parseInt(txtBlnPinjam.getText());
            int blnK = Integer.parseInt(txtBlnKembali.getText());
            int tglP = Integer.parseInt(txtTglPinjam.getText());
            int tglK = Integer.parseInt(txtTglKembali.getText());
            if (blnP >= blnK) {
                for (int i = 0; i < 12 - (Integer.parseInt(txtBlnPinjam.getText()) - blnK); i++) {
                    if (blnP % 2 == 0) {
                        if (blnP == 2) {
                            x += 28;
                        } else {
                            x += 31;
                        }
                    } else {
                        x += 30;
                    }
                    if (blnP == 12) {
                        blnP = 1;
                    } else {
                        blnP++;
                    }
                }
                blnP = Integer.parseInt(txtBlnPinjam.getText());
                if (blnP % 2 == 0) {
                    if (blnP == 2) {
                        x = x + (28 - tglP) - 28 + tglK;
                    } else {
                        x = x + (31 - tglP) - 31 + tglK;
                    }
                } else {
                    x = x + (30 - tglP) - 30 + tglK;
                }
                if (!txtThnKembali.getText().equals(txtThnPinjam.getText())) {
                    int jrkT = Integer.parseInt(txtThnKembali.getText()) - Integer.parseInt(txtThnPinjam.getText());
                    if (jrkT > 1) {
                        x += 363 * (jrkT - 1) ;
                    }
                }
            } else {
                for (int i = 0; i < blnK - Integer.parseInt(txtBlnPinjam.getText()); i++) {
                    if (blnP % 2 == 0) {
                        if (blnP == 2) {
                            x += 28;
                        } else {
                            x += 31;
                        }
                    } else {
                        x += 30;
                    }
                    if (blnP == 12) {
                        blnP = 1;
                    } else {
                        blnP++;
                    }
                }
                blnP = Integer.parseInt(txtBlnPinjam.getText());
                if (blnP % 2 == 0) {
                    if (blnP == 2) {
                        x = x + (28 - tglP) - 28 + tglK;
                    } else {
                        x = x + (31 - tglP) - 31 + tglK;
                    }
                } else {
                    x = x + (30 - tglP) - 30 + tglK;
                }
                if (!txtThnKembali.getText().equals(txtThnPinjam.getText())) {
                    int jrkT = Integer.parseInt(txtThnKembali.getText()) - Integer.parseInt(txtThnPinjam.getText());
                    if (jrkT > 1) {
                        x += 363 * jrkT;
                    } else {
                        x += 363;
                    }
                }
            }
        }
        return x + 1;
    }

    public int hitungTotalHarga() {
        Peminjaman pm = new Peminjaman();
        return (int) (hitungHari() * pm.getJenis().getHargaSewa());
    }

    public void tampilkanData() {
        String[] kolom = {"ID", "No Ktp", "Nama", "No Polisi", "Merk Mobil", "Nama mobil", "Tanggal Pinjam", "Tanggal Kembali", "Harga Sewa / Hr", "Lama(Hr)", "Total Harga"};
        ArrayList<Peminjaman> list = new Peminjaman().getAll();
        ArrayList<Peminjaman> listp = new Peminjaman().getAll();
        Object rowData[] = new Object[11];

        tblPeminjaman.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getIdPeminjaman();
            rowData[1] = list.get(i).getPenyewa().getNoKtp();
            rowData[2] = list.get(i).getPenyewa().getNama();
            rowData[3] = list.get(i).getMob().getNopol();
            rowData[4] = list.get(i).getMob().getMerkMobil();
            rowData[5] = list.get(i).getMob().getNamaMobil();
            rowData[6] = list.get(i).getTglPinjam();
            rowData[7] = list.get(i).getTglKembali();
            rowData[8] = list.get(i).getJenis().getHargaSewa();
            rowData[9] = hitungHari();
            rowData[10] = hitungTotalHarga();

            ((DefaultTableModel) tblPeminjaman.getModel()).addRow(rowData);
        }
        for (int a = 0; a < listp.size(); a++) {
            rowData[0] = list.get(a).getIdPeminjaman();
            rowData[1] = list.get(a).getPenyewa().getNoKtp();
            rowData[2] = list.get(a).getPenyewa().getNama();
            rowData[3] = list.get(a).getPick().getNopol();
            rowData[4] = list.get(a).getPick().getMerkPickUp();
            rowData[5] = list.get(a).getPick().getNamaPickUp();
            rowData[6] = list.get(a).getTglPinjam();
            rowData[7] = list.get(a).getTglKembali();
            rowData[8] = list.get(a).getJenis().getHargaSewa();
            rowData[9] = hitungHari();
            rowData[10] = hitungTotalHarga();

            ((DefaultTableModel) tblPeminjaman.getModel()).addRow(rowData);
        }
    }

    public void cari(String keyword) {
        String[] kolom = {"ID", "No Ktp", "Nama", "No Polisi", "Merk Mobil", "Nama mobil", "Tanggal Pinjam", "Tanggal Kembali", "Harga Sewa / Hr", "Lama(Hr)", "Total Harga"};
        ArrayList<Peminjaman> list = new Peminjaman().search(keyword);
        ArrayList<Peminjaman> listp = new Peminjaman().search(keyword);
        Object rowData[] = new Object[11];

        tblPeminjaman.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Peminjaman pm : list) {
            rowData[0] = pm.getIdPeminjaman();
            rowData[1] = pm.getPenyewa().getNoKtp();
            rowData[2] = pm.getPenyewa().getNama();
            rowData[3] = pm.getMob().getNopol();
            rowData[4] = pm.getMob().getMerkMobil();
            rowData[5] = pm.getMob().getNamaMobil();
            rowData[6] = pm.getTglPinjam();
            rowData[7] = pm.getTglKembali();
            rowData[8] = pm.getJenis().getHargaSewa();
            rowData[9] = hitungHari();
            rowData[10] = hitungTotalHarga();

            ((DefaultTableModel) tblPeminjaman.getModel()).addRow(rowData);
        }
        for (Peminjaman pmn : listp) {
            rowData[0] = pmn.getIdPeminjaman();
            rowData[1] = pmn.getPenyewa().getNoKtp();
            rowData[2] = pmn.getPenyewa().getNama();
            rowData[3] = pmn.getPick().getNopol();
            rowData[4] = pmn.getPick().getMerkPickUp();
            rowData[5] = pmn.getPick().getNamaPickUp();
            rowData[6] = pmn.getTglPinjam();
            rowData[7] = pmn.getTglKembali();
            rowData[8] = pmn.getJenis().getHargaSewa();
            rowData[9] = hitungHari();
            rowData[10] = hitungTotalHarga();

            ((DefaultTableModel) tblPeminjaman.getModel()).addRow(rowData);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdPeminjaman = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNoPol = new javax.swing.JTextField();
        cmbViewMobil = new javax.swing.JComboBox<>();
        btnCariMobil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMobil = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTglPinjam = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBlnPinjam = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtThnPinjam = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtJamPinjam = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMntPinjam = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDtkPinjam = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTglKembali = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtBlnKembali = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtThnKembali = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtJamKembali = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtMntKembali = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtDtkKembali = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPeminjaman = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        txtIdPenyewa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORM PEMINJAMAN");

        jLabel2.setText("ID");

        txtIdPeminjaman.setEnabled(false);

        jLabel3.setText("NoPol Mobil");

        cmbViewMobil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbViewMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbViewMobilActionPerformed(evt);
            }
        });

        btnCariMobil.setText("CARI");
        btnCariMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariMobilActionPerformed(evt);
            }
        });

        tblMobil.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMobilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMobil);

        jLabel4.setText("Tanggal  Pinjam");

        jLabel5.setText("TGL");

        jLabel6.setText("BLN");

        jLabel7.setText("THN");

        jLabel8.setText("JAM");

        jLabel9.setText("MNT");

        jLabel10.setText("DTK");

        jLabel11.setText("Tanggal Kembali");

        jLabel12.setText("TGL");

        jLabel13.setText("BLN");

        jLabel14.setText("THN");

        jLabel15.setText("JAM");

        jLabel16.setText("MNT");

        jLabel17.setText("DTK");

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnTambah.setText("TAMBAH BARU");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tblPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblPeminjaman);

        jLabel18.setText("ID Penyewa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNoPol, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCariMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(14, 14, 14)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(14, 14, 14)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTglPinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                            .addComponent(txtJamPinjam)
                                            .addComponent(txtTglKembali)
                                            .addComponent(txtJamKembali))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtBlnPinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                            .addComponent(txtMntPinjam)
                                            .addComponent(txtBlnKembali)
                                            .addComponent(txtMntKembali))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtThnPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtDtkPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(txtThnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                                .addComponent(txtDtkKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdPenyewa)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbViewMobil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbViewMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdPenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNoPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCariMobil))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(txtBlnPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtThnPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJamPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtMntPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDtkPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBlnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJamKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMntKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDtkKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnTambah)
                    .addComponent(btnHapus)
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMobilMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblMobil.getModel();
        int row = tblMobil.getSelectedRow();

        if (row == 0) {
            MobilKeluarga mk = new MobilKeluarga();
            mk = mk.getById(Integer.parseInt(model.getValueAt(row, 0).toString()));

            txtNoPol.setText(mk.getNopol());

        } else {
            MobilPickUp mp = new MobilPickUp();
            mp = mp.getById(Integer.parseInt(model.getValueAt(row, 0).toString()));

            txtNoPol.setText(mp.getNopol());
        }
    }//GEN-LAST:event_tblMobilMouseClicked

    private void btnCariMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariMobilActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblMobil.getModel();
        cariMobil(txtNoPol.getText());
    }//GEN-LAST:event_btnCariMobilActionPerformed

    private void cmbViewMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbViewMobilActionPerformed
        // TODO add your handling code here:
        if (cmbViewMobil.getSelectedIndex() == 0) {
            tampilkanDataMobil();
        } else if (cmbViewMobil.getSelectedIndex() == 1) {
            String[] kolom = {"ID Mobil", "Jenis", "No Polisi", "Merk", "Warna", "Nama", "Harga Sewa / Hr"};
            ArrayList<MobilKeluarga> list = new MobilKeluarga().getAll();
            Object rowData[] = new Object[7];

            tblMobil.setModel(new DefaultTableModel(new Object[][]{}, kolom));

            for (int i = 0; i < list.size(); i++) {
                rowData[0] = list.get(i).getIdMobil();
                rowData[1] = list.get(i).getJenis().getJenis();
                rowData[2] = list.get(i).getNopol();
                rowData[3] = list.get(i).getMerkMobil();
                rowData[4] = list.get(i).getWarnaMobil();
                rowData[5] = list.get(i).getNamaMobil();
                rowData[6] = list.get(i).getJenis().getHargaSewa();

                ((DefaultTableModel) tblMobil.getModel()).addRow(rowData);
            }
        } else {
            String[] kolom = {"ID Mobil", "Jenis", "No Polisi", "Merk", "Warna", "Nama", "Harga Sewa / Hr"};
            ArrayList<MobilPickUp> listp = new MobilPickUp().getAll();
            Object rowData[] = new Object[7];

            tblMobil.setModel(new DefaultTableModel(new Object[][]{}, kolom));

            for (int a = 0; a < listp.size(); a++) {
                rowData[0] = listp.get(a).getIdPickUp();
                rowData[1] = listp.get(a).getJenis().getJenis();
                rowData[2] = listp.get(a).getNopol();
                rowData[3] = listp.get(a).getMerkPickUp();
                rowData[4] = listp.get(a).getWarnaPickUp();
                rowData[5] = listp.get(a).getNamaPickUp();
                rowData[6] = listp.get(a).getJenis().getHargaSewa();

                ((DefaultTableModel) tblMobil.getModel()).addRow(rowData);
            }
        }
    }//GEN-LAST:event_cmbViewMobilActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        
        Peminjaman pm = new Peminjaman();
        pm.setIdPeminjaman(Integer.parseInt(txtIdPeminjaman.getText()));
        pm.getPenyewa().setIdPenyewa(Integer.parseInt(txtIdPenyewa.getText()));
        pm.getJenis().getIdJenis();
        pm.getIdMobil();
        pm.setTglPinjam(txtTglPinjam.getText());
        pm.setTglKembali(txtTglKembali.getText());
        pm.save();
        txtIdPeminjaman.setText(Integer.toString(pm.getIdPeminjaman()));
        tampilkanData();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblPeminjaman.getModel();
        int row = tblPeminjaman.getSelectedRow();

        Peminjaman pen = new Peminjaman().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        pen.delete();
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        kosongkanForm();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(FormSewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSewa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariMobil;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbViewMobil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMobil;
    private javax.swing.JTable tblPeminjaman;
    private javax.swing.JTextField txtBlnKembali;
    private javax.swing.JTextField txtBlnPinjam;
    private javax.swing.JTextField txtDtkKembali;
    private javax.swing.JTextField txtDtkPinjam;
    private javax.swing.JTextField txtIdPeminjaman;
    private javax.swing.JTextField txtIdPenyewa;
    private javax.swing.JTextField txtJamKembali;
    private javax.swing.JTextField txtJamPinjam;
    private javax.swing.JTextField txtMntKembali;
    private javax.swing.JTextField txtMntPinjam;
    private javax.swing.JTextField txtNoPol;
    private javax.swing.JTextField txtTglKembali;
    private javax.swing.JTextField txtTglPinjam;
    private javax.swing.JTextField txtThnKembali;
    private javax.swing.JTextField txtThnPinjam;
    // End of variables declaration//GEN-END:variables
}

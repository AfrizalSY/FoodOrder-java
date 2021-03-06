/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesfoodorder;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author AFRIZAL SY
 */
public class Main extends javax.swing.JFrame {
Connection cn;
byte[] gambar;
byte[] bitarray = null;
String path;

    /**
     * Creates new form Main
     */
    private Image resize(int w, int h, Image img){
        BufferedImage bufimg = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
        Graphics2D dimensi = bufimg.createGraphics();
        dimensi.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        dimensi.drawImage(img, 0,0,w,h, null);
        dimensi.dispose();
        return bufimg;
    }
        public void ambilgambar(){
        try{
            int id = Integer.parseInt(txtid.getText());
            byte[] img = getgambar(id);
            BufferedImage file = ImageIO.read(new ByteArrayInputStream(img));
            ImageIcon icon = new ImageIcon(resize(pangbr.getWidth(), pangbr.getHeight(), file));
            pangbr.setIcon(icon);
        } catch (Exception ex){
            
        }
    }
    public byte[] getgambar(int id){
        try{
            PreparedStatement ps = cn.prepareStatement("select gambar from produk where id_produk like '"+id+"' ");
            ps.execute();
            ResultSet rs = ps.executeQuery();
            byte[] file = null;
            while(rs.next()){
                file =  rs.getBytes("gambar");
            }
            return file;
        } catch (Exception ex){
            
        }
        return null;
    }
    public Main() {
        initComponents();
        // mengambil ukuran layar
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
        btnadd.setEnabled(false);
        btnhapus.setEnabled(false);
        btnbayar.setEnabled(false);
        
        connection();
        loadrecord(tabelproduk);
        btnbayar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabelproduk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelkeranjang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        btnbayar = new javax.swing.JButton();
        btnkembali = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtproduk = new javax.swing.JLabel();
        txtharga = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtkuantitas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        pangbr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelproduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelproduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelprodukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelproduk);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 69, 340, 336));

        jLabel1.setFont(new java.awt.Font("Retroica", 0, 24)); // NOI18N
        jLabel1.setText("Pemesanan");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 18, -1, -1));

        tabelkeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Qty", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelkeranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkeranjangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelkeranjang);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 143, 340, 200));

        jLabel2.setText("Produk");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 47, -1, -1));

        jLabel4.setText("Keranjang");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 121, -1, -1));

        btnadd.setText("Tambah ke Keranjang");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        getContentPane().add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 350, 50));

        btnbayar.setBackground(new java.awt.Color(255, 0, 0));
        btnbayar.setText("Bayar");
        btnbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 340, 62));

        btnkembali.setText("Kembali");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btnkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 69, 340, -1));

        btnhapus.setBackground(new java.awt.Color(0, 0, 255));
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 340, 62));

        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 417, -1, -1));

        txtid.setText("-");
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 417, 71, -1));

        jLabel6.setText("Nama");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 439, -1, -1));

        jLabel7.setText("Harga");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 461, -1, -1));

        txtproduk.setText(" ");
        getContentPane().add(txtproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 439, 136, -1));

        txtharga.setText(" ");
        getContentPane().add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 461, 136, -1));

        jLabel5.setText("Kuantitas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 483, -1, -1));

        txtkuantitas.setText("1");
        txtkuantitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkuantitasActionPerformed(evt);
            }
        });
        getContentPane().add(txtkuantitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 483, 70, 30));

        jLabel8.setFont(new java.awt.Font("Retroica", 0, 18)); // NOI18N
        jLabel8.setText("Total Bayar");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, -1, -1));

        txttotal.setFont(new java.awt.Font("Retroica", 0, 18)); // NOI18N
        txttotal.setText("0");
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 120, -1));

        pangbr.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(pangbr, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 100, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void loadrecord(JTable table){
        try{
                PreparedStatement ps = cn.prepareStatement("select * from produk");
                ResultSet rs = ps.executeQuery();
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                model.setRowCount(0);
                Object[] row;
                while (rs.next()){
                    row = new Object[3];
                    row[0] = rs.getInt(1);
                    row[1] = rs.getString(2);
                    row[2] = rs.getInt(3);
                    model.addRow(row);
                }
                ps.execute();
                
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void loadrecord1(JTable table){
        try{
                PreparedStatement ps = cn.prepareStatement("select * from keranjang");
                ResultSet rs = ps.executeQuery();
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                model.setRowCount(0);
                Object[] row;
                while (rs.next()){
                    row = new Object[4];
                    row[0] = rs.getInt(1);
                    row[1] = rs.getString(2);
                    row[2] = rs.getInt(3);
                    row[3] = rs.getInt(4);
                    model.addRow(row);
                }
                ps.execute();
                
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void connection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/janjikita", "root", "");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Koneksi close");
        }
    }
    
    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
       connection();
        String id = txtid.getText();
        String prod = txtproduk.getText();
        String harga = txtharga.getText();
        String kuantitas = txtkuantitas.getText();
        int totals = 0;
        int harg = Integer.parseInt(harga);
        int qty = Integer.parseInt(txtkuantitas.getText());
        int total = harg * qty;
        String tot = String.valueOf(total);
        String Qty = String.valueOf(qty);
        
        try{
            PreparedStatement ps = cn.prepareStatement("insert into keranjang (id_produk, nama_produk, qty, total) values (?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, prod);
            ps.setString(3, kuantitas);
            ps.setString(4, tot);
            ps.execute();
            loadrecord(tabelproduk);
            loadrecord1(tabelkeranjang);
            PreparedStatement pss = cn.prepareStatement("select * from keranjang");
            ResultSet rs = pss.executeQuery();
            while (rs.next()){
                totals = totals + rs.getInt(4);
            }
            pss.execute();
//            int sum =+ total;
            txttotal.setText(""+totals);
            cn.close();
            txtid.setText("-");
            txtproduk.setText("");
            txtharga.setText("");
            
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        btnbayar.setEnabled(true);
    }//GEN-LAST:event_btnaddActionPerformed

    private void tabelprodukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelprodukMouseClicked
        btnadd.setEnabled(true);
        int rowIndex = tabelproduk.getSelectedRow();
        txtid.setText(tabelproduk.getValueAt(rowIndex,0).toString());
        txtproduk.setText(tabelproduk.getValueAt(rowIndex,1).toString());
        txtharga.setText(tabelproduk.getValueAt(rowIndex,2).toString());
        ambilgambar();
    }//GEN-LAST:event_tabelprodukMouseClicked

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        new Option().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        connection();
        
        int i = Integer.parseInt(txttotal.getText());
        int j = Integer.parseInt(txtharga.getText());
        int k = i - j ;
        String g = String.valueOf(k);
        txttotal.setText(g);
        try{
            String id = txtid.getText();
            if(id.equals("-")){
                JOptionPane.showMessageDialog(null, "Tidak ada data dipilih");
            } else {
                PreparedStatement ps = cn.prepareStatement("delete from keranjang where id_produk like '"+id+"'");
                ps.execute();
                loadrecord1(tabelkeranjang);
                cn.close();
                
                txtid.setText("-");
            txtproduk.setText("");
            txtharga.setText("");
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void tabelkeranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkeranjangMouseClicked
        btnhapus.setEnabled(true); 
        btnbayar.setEnabled(true); 
        int rowIndex = tabelkeranjang.getSelectedRow();
        txtid.setText(tabelkeranjang.getValueAt(rowIndex,0).toString());
        txtproduk.setText(tabelkeranjang.getValueAt(rowIndex,1).toString());
        txtharga.setText(tabelkeranjang.getValueAt(rowIndex,3).toString());
    }//GEN-LAST:event_tabelkeranjangMouseClicked

    private void txtkuantitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkuantitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkuantitasActionPerformed

    private void btnbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayarActionPerformed
        String data = txttotal.getText();
        Bayar p = new Bayar(data);
            p.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnbayarActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel pangbr;
    private javax.swing.JTable tabelkeranjang;
    private javax.swing.JTable tabelproduk;
    private javax.swing.JLabel txtharga;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtkuantitas;
    private javax.swing.JLabel txtproduk;
    private javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daftarmahasiswa;

// Import
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author sekar
 */
public class Menu extends javax.swing.JFrame {

    // Properties
    private DefaultTableModel dtm;
    private Boolean isUpdate = false;
    private int selectedID = -1;
    private ArrayList<Mahasiswa> listMhs;

    /**
     * Creates new form Menu
     */
    public Menu() {
        // Constructor
        initComponents();
        listMhs = new ArrayList<>();
        // Dummy
        listMhs.add(new Mahasiswa("2132888", "Cahya Gumilang", "A", "Male"));
        listMhs.add(new Mahasiswa("2001103", "Nelly Joy C. S.", "B", "Female"));
        listMhs.add(new Mahasiswa("2202222", "Muhammad Satria R.", "C", "Male"));
        // Set Table
        genderBox.setModel(setComboBox());
        tblMhs.setModel(setTable());
        // Hide Delete button
        btnDelete.setVisible(false);
    }
    
    // set default model tabel
    public final DefaultTableModel setTable() {
        // Column Title
        Object[] column = {"NIM", "Nama", "Nilai", "Gender"};
        DefaultTableModel dataTabel = new DefaultTableModel(null, column);
        // Get Cell Value
        for (int i = 0; i < listMhs.size(); i++) {
            Object[] row = new Object[4]; // Array of object
            row[0] = listMhs.get(i).getNim(); // cell 0
            row[1] = listMhs.get(i).getNama(); // cell 1
            row[2] = listMhs.get(i).getNilai(); // cell 2
            row[3] = listMhs.get(i).getGender();
            
            dataTabel.addRow(row); // add new row
        }
        return dataTabel;
    }
    
    // set defalut model combo box
    public final DefaultComboBoxModel setComboBox(){
        // value dari combo box
        String[] gender = {"Select gender", "Male", "Female"};
        
        // set value
        DefaultComboBoxModel<String> setGenderBox = new DefaultComboBoxModel<String>(gender);
        
        // set default selected item to "Pilih gender"
        setGenderBox.setSelectedItem("Select gender");
        
        return setGenderBox;
    }
    
    // untuk menambahkan data 
    public void insertData() {
        // get data from form
        String nim = fieldNim.getText();
        String nama = fieldNama.getText();
        String nilai = fieldNilai.getText();
        String gender = genderBox.getSelectedItem().toString();

        // add new data
        listMhs.add(new Mahasiswa(nim, nama, nilai, gender));

        // reset form
        resetForm();

        // update table
        tblMhs.setModel(setTable());

        // show information
        System.out.println("Insert Success!");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
    }
    
    // untuk opdate data
    public void updateData() {
        // get data from form
        String nim = fieldNim.getText();
        String nama = fieldNama.getText();
        String nilai = fieldNilai.getText();
        String gender = genderBox.getSelectedItem().toString();

        // set data to object
        listMhs.get(selectedID).setNim(nim);
        listMhs.get(selectedID).setNama(nama);
        listMhs.get(selectedID).setNilai(nilai);
        listMhs.get(selectedID).setGender(gender);

        // reset form
        resetForm();

        // update table
        tblMhs.setModel(setTable());

        // show information
        System.out.println("Update Success!");
        JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
    }
    
    // untuk delete data
    public void deleteData() {
        // remove data from list
        listMhs.remove(selectedID);

        // update table
        tblMhs.setModel(setTable());

        // reset form
        resetForm();

        // show information
        System.out.println("Delete Success!");
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
    }
    
    // method untuk reset form
    public void resetForm() {
        // Set All Value Form to Empty
        fieldNim.setText("");
        fieldNama.setText("");
        fieldNilai.setText("");
    }
    
    public boolean checkInput(){
        // Validate input data
        if (fieldNim.getText().isEmpty() || fieldNama.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                    "Lengkapi kolom NIM dan Nama", 
                    "Warning", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if(genderBox.getSelectedItem() == "Select gender"){
            JOptionPane.showMessageDialog(null, 
                    "Pilih Gender", 
                    "Warning", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        fieldNim = new javax.swing.JTextField();
        lblNim = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        fieldNama = new javax.swing.JTextField();
        lblNilai = new javax.swing.JLabel();
        fieldNilai = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMhs = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblNilai1 = new javax.swing.JLabel();
        genderBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(126, 136, 176));

        lblTitle.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Daftar Mahasiswa");

        btnAdd.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        fieldNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNimActionPerformed(evt);
            }
        });

        lblNim.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblNim.setForeground(new java.awt.Color(255, 255, 255));
        lblNim.setText("NIM");

        lblNama.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setText("Nama");

        fieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNamaActionPerformed(evt);
            }
        });

        lblNilai.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblNilai.setForeground(new java.awt.Color(255, 255, 255));
        lblNilai.setText("Nilai");

        fieldNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNilaiActionPerformed(evt);
            }
        });

        tblMhs.setAutoCreateRowSorter(true);
        tblMhs.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMhs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblMhs.setUpdateSelectionOnSort(false);
        tblMhs.setVerifyInputWhenFocusTarget(false);
        tblMhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMhsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMhs);

        btnDelete.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblNilai1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblNilai1.setForeground(new java.awt.Color(255, 255, 255));
        lblNilai1.setText("Gender");

        genderBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        genderBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(167, 167, 167))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNama)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNim)
                                .addGap(55, 55, 55)
                                .addComponent(fieldNim, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNilai)
                                    .addComponent(lblNilai1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldNilai, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addComponent(genderBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete)
                            .addComponent(btnCancel))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNim)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNama)
                    .addComponent(btnCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNilai)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNilai1)
                    .addComponent(genderBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnAdd.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void fieldNimActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        // Check if text field is empty
        if(fieldNim.getText().isEmpty()) {
            btnCancel.setText("Cancel");
        } else {
            btnCancel.setText("Reset");
        }
    }                                        

    private void fieldNamaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        // Check if text field is empty
        if(fieldNama.getText().isEmpty()) {
            btnCancel.setText("Cancel");
        } else {
            btnCancel.setText("Reset");
        }
    }                                         

    private void fieldNilaiActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        // Check if text field is empty
        if(fieldNilai.getText().isEmpty()) {
            btnCancel.setText("Cancel");
        } else {
            btnCancel.setText("Reset");
        }
    }                                          

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        // validasi data input
        if(checkInput() == false){
            return;
        }
        
        // If Add (data not clicked)
        if (isUpdate == false) {
            insertData();
            // set default selected item to "Pilih gender"
            genderBox.setSelectedItem("Select gender");
        } else {
            updateData();
            btnAdd.setText("Add");
            btnDelete.setVisible(false);
            // set default selected item to "Pilih gender"
            genderBox.setSelectedItem("Select gender");
            this.isUpdate = false;
        }
    }                                      

    private void tblMhsMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        // If data clicked
        this.isUpdate = true;
        
        // Get Selected Data
        int row = tblMhs.getSelectedRow();
        String selectedNim = tblMhs.getModel().getValueAt(row, 0).toString();
        String selectedNama = tblMhs.getModel().getValueAt(row, 1).toString();
        String selectedNilai = tblMhs.getModel().getValueAt(row, 2).toString();
        String selectedGender = tblMhs.getModel().getValueAt(row, 3).toString();
        
        // Search Data
        for (int i = 0; i < listMhs.size(); i++) {
            if (selectedNim.equals(listMhs.get(i).getNim())) {
                selectedID = i;
                break;
            }
        }
        
        // Set Form Value
        fieldNim.setText(selectedNim);
        fieldNama.setText(selectedNama);
        fieldNilai.setText(selectedNilai);
        genderBox.setSelectedItem(selectedGender);
        
        btnAdd.setText("Update");
        btnDelete.setVisible(true);
    }                                   

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        if (isUpdate == true) {
            // display confirmation message
            int result = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to delete this data?", 
                    "Confirmation", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
            
            if (result == JOptionPane.YES_OPTION) {
                // if user confirms deletion
                deleteData();
                btnAdd.setText("Add");
                btnDelete.setVisible(false);
                // set default selected item to "Pilih gender"
                genderBox.setSelectedItem("Select gender");
                this.isUpdate = false;
            }
        }
    }                                         

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        // Cancel Input Form
        btnAdd.setText("Add");
        btnDelete.setVisible(false);
        // set default selected item to "Pilih gender"
        genderBox.setSelectedItem("Select gender");
        this.isUpdate = false;
        
        // Reset Form
        resetForm();
    }                                         

    private void genderBoxActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JTextField fieldNilai;
    private javax.swing.JTextField fieldNim;
    private javax.swing.JComboBox<String> genderBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNilai;
    private javax.swing.JLabel lblNilai1;
    private javax.swing.JLabel lblNim;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblMhs;
    // End of variables declaration                   
}

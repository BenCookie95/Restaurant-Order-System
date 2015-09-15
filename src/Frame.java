/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.lang.NullPointerException;
import java.util.Random;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author IS2209 Group
 */
public class Frame extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    //declaring a new instance of our database class
    database a  = new database();
    //Declaring a new instance of classes
    Employee e = new Employee();
    //Creating a random number to be used as employee number
    Random rand = new Random();
    int x = rand.nextInt(10000);
    DefaultTableModel model;
    public Frame() {
        initComponents();
        //a.dropTable();
        //a.createTable();
        //assigning the default table model to our table
        model = (DefaultTableModel) tblEmployees.getModel();
        //calling the method which will populate tables upon initialization
        populateTable();
        btnAddR.setEnabled(false);
        btnDelete.setEnabled(false);
        //Document Listeners for validation, buttons become enabled when certain conditions are met
        //Code manipulated from http://stackoverflow.com/questions/10848335/how-to-implement-documentlistener
     txtPPSN.getDocument().addDocumentListener(new DocumentListener() {
          @Override
     public void changedUpdate(DocumentEvent e){
          lengthCheck();
      }
     @Override
        public void insertUpdate(DocumentEvent e) {
          lengthCheck();
      }
        @Override
        public void removeUpdate(DocumentEvent e) {
           lengthCheck();
      }
        });
    txtFirstName.getDocument().addDocumentListener(new DocumentListener() {
          @Override
     public void changedUpdate(DocumentEvent e){
          lengthCheck();
      }
     @Override
        public void insertUpdate(DocumentEvent e) {
          lengthCheck();
      }
        @Override
        public void removeUpdate(DocumentEvent e) {
           lengthCheck();
      }
        });
    txtLastName.getDocument().addDocumentListener(new DocumentListener() {
          @Override
     public void changedUpdate(DocumentEvent e){
          lengthCheck();
      }
     @Override
        public void insertUpdate(DocumentEvent e) {
          lengthCheck();
      }
        @Override
        public void removeUpdate(DocumentEvent e) {
           lengthCheck();
      }
        });
    txtWage.getDocument().addDocumentListener(new DocumentListener() {
          @Override
     public void changedUpdate(DocumentEvent e){
          lengthCheck();
      }
     @Override
        public void insertUpdate(DocumentEvent e) {
          lengthCheck();
      }
        @Override
        public void removeUpdate(DocumentEvent e) {
           lengthCheck();
      }
        });
    txtPosition.getDocument().addDocumentListener(new DocumentListener() {
          @Override
     public void changedUpdate(DocumentEvent e){
          lengthCheck();
      }
     @Override
        public void insertUpdate(DocumentEvent e) {
          lengthCheck();
      }
        @Override
        public void removeUpdate(DocumentEvent e) {
           lengthCheck();
      }
        });
    }
    //populate the table
    public void populateTable()
    {
        //decalring variables
        int EmployeeID;
        String FirstName;
        String LastName;
        String PPSN;
        String Wages;
        String Position;
        int r =0;
 
        try
        {
            a.createConnection();//creates connection
            
            a.stmt = a.conn.createStatement();//creates and executes sql statement
            ResultSet results = a.stmt.executeQuery("select * from " + a.tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            
            
            while(results.next())
            {              
            //Fills table until it reaches the end of the database
            EmployeeID = results.getInt(1);
            FirstName = results.getString(2);
            LastName = results.getString(3);
            PPSN = results.getString(4);
            Wages = results.getString(5);
            Position = results.getString(6);
            model.insertRow(model.getRowCount(), new Object[]{EmployeeID, FirstName, LastName, PPSN, Wages, Position});
            r++;
            }//end of while loop
            //closes and 'shuts down any open streams and connections
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        }
              
    }
    
    
    
    
    
        
    //method to insert employee into the database
     private void insertEmployee(Employee e)
    {
        a.createConnection();//creates connection
        try
        {
            a.stmt = a.conn.createStatement();//creates and executes statement to fill database table
            a.stmt.execute("insert into " + a.tableName + " values (" +
                    x +  ",'" + e.getFirstName() + "','" + e.getLastName() + "','" + e.getPPSN() + "','" + e.getWage() + "','" + e.getPosition() + "')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }
     
        //mehtod used in document listener for validation purposes
      public void lengthCheck(){
          if(txtFirstName.getText().equals("") || txtLastName.getText().equals("") || txtPPSN.getText().equals("")|| txtWage.getText().equals("")||txtPosition.getText().equals("")){
              btnAddR.setEnabled(false);
              btnDelete.setEnabled(false);
          }
          else if(txtFirstName.getText().length()> 50 || txtLastName.getText().length()>50 || txtPPSN.getText().length()>10|| txtWage.getText().length()>10||txtPosition.getText().length()>30){
               btnAddR.setEnabled(false);
          }
          else{
               btnAddR.setEnabled(true);
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

        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtPPSN = new javax.swing.JTextField();
        txtWage = new javax.swing.JTextField();
        txtPosition = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        btnAddR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnUnSelect = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 22, 239, -1));
        getContentPane().add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 60, 239, -1));
        getContentPane().add(txtPPSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 22, 130, -1));
        getContentPane().add(txtWage, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 60, 130, -1));
        getContentPane().add(txtPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 98, 439, -1));

        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmployeeID", "First Name", "Last Name", "PPSN", "Weekly Wage", "Position"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmployees.getTableHeader().setReorderingAllowed(false);
        tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployees);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 136, 592, 160));

        btnAddR.setBackground(new java.awt.Color(255, 255, 255));
        btnAddR.setText("Add");
        btnAddR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddR, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 100, 25));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Wage");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 63, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PPSN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 25, -1, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Position");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 101, -1, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 63, -1, -1));

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("First Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 25, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 100, 25));

        btnUnSelect.setBackground(new java.awt.Color(255, 255, 255));
        btnUnSelect.setText("Deselect");
        btnUnSelect.setToolTipText("Use this to unselect \na row from the table");
        btnUnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnSelectActionPerformed(evt);
            }
        });
        getContentPane().add(btnUnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 90, 25));

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back to Home");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 110, 25));

        btnMenu.setBackground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Edit Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 90, 25));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Grey-Background-GREY.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //button to add employee to table
    private void btnAddRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRActionPerformed
        // TODO add your handling code here:
      
        //populates table with textfield values
        model.insertRow(model.getRowCount(), new Object[]{x, txtFirstName.getText(), txtLastName.getText(), txtPPSN.getText(), txtWage.getText(), txtPosition.getText()});
        //Gets info from textfields to be used to populate database table
        e.setFirstName(txtFirstName.getText());
        e.setLastName(txtLastName.getText());
        e.setPPSN(txtPPSN.getText());
        e.setWage(txtWage.getText());
        e.setPosition(txtPosition.getText());
        
        //clears text fields
        txtFirstName.setText(null);
        txtLastName.setText(null);
        txtPPSN.setText(null);
        txtWage.setText(null);
        txtPosition.setText(null);
        //calls method to insert values to database
        insertEmployee(e);
      
        x++;
                
        
    }//GEN-LAST:event_btnAddRActionPerformed
    
    
    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        
    }//GEN-LAST:event_txtFirstNameActionPerformed
    //delete employee from database and table
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //setting the selected row from the table
        int row = tblEmployees.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel)tblEmployees.getModel();
        //Sets the variable selected equal to firstvalue in selected row and sets it to a string
        String selected = tblEmployees.getValueAt(row, 3).toString();
        
            
        
        if (row >= 0) {
            //remove row from table
            model.removeRow(row);
        try{
            a.createConnection();//creates connection
            //prepares statement to delete row from the database
            PreparedStatement ps = a.conn.prepareStatement("delete from Employee_Table where PPSN='"+selected+"' ");
            ps.executeUpdate();
            //creates text fields
            txtFirstName.setText(null);
            txtLastName.setText(null);
            txtPPSN.setText(null);
            txtWage.setText(null);
            txtPosition.setText(null);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeesMouseClicked
        //Setting row equal to selected row
        int row = tblEmployees.getSelectedRow();
        //setting selected equal to the ppsn and converts to string
        String selected = tblEmployees.getValueAt(row, 3).toString();
        DefaultTableModel model= (DefaultTableModel)tblEmployees.getModel();
        try{
        if(selected !=null ){
            //displays info of selected row into text fields
            txtFirstName.setText(String.valueOf(model.getValueAt(tblEmployees.getSelectedRow(), 1)));
            txtLastName.setText(String.valueOf(model.getValueAt(tblEmployees.getSelectedRow(), 2)));
            txtPPSN.setText(String.valueOf(model.getValueAt(tblEmployees.getSelectedRow(), 3)));
            txtWage.setText(String.valueOf(model.getValueAt(tblEmployees.getSelectedRow(), 4)));
            txtPosition.setText(String.valueOf(model.getValueAt(tblEmployees.getSelectedRow(), 5)));
            btnDelete.setEnabled(true);
            btnAddR.setEnabled(false);
        }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }//GEN-LAST:event_tblEmployeesMouseClicked

    private void btnUnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnSelectActionPerformed
        //unselects row
        tblEmployees.getSelectionModel().clearSelection();
        txtFirstName.setText(null);
        txtLastName.setText(null);
        txtPPSN.setText(null);
        txtWage.setText(null);
        txtPosition.setText(null);
    }//GEN-LAST:event_btnUnSelectActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Homepage h = new Homepage();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MenuEditor me = new MenuEditor();
        me.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddR;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnUnSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblEmployees;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPPSN;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtWage;
    // End of variables declaration//GEN-END:variables
}

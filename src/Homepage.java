//imports used in this frame
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class Homepage extends javax.swing.JFrame {
    //declaring our table models which pertain to table structures
    DefaultTableModel model;
    DefaultTableModel model1;
    
    //declaring a new instance of our database class
    database a =new database();
            
    public Homepage() { //initial contructor (will automatically call initialize components method)
        initComponents();
        
        btnRemoveOrder.setEnabled(false);
        //setting our tooltips
        btnRemoveOrder.setToolTipText("Select a row from the Bill table to remove, "
                 + "it will also remove the corresponding orders from the orders table");
        btnNewOrder.setToolTipText("This will create a new order");
        btnAdmin.setToolTipText("This will take you to the admin view (where credentials are necessary");
        //assigning the default table model to our two tables
        model = (DefaultTableModel) tblOrders.getModel();
        model1 = (DefaultTableModel) tblBill.getModel();
        //calling the method which will populate tables upon initialization
        populateTable();
        populateTable1();
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblOrders.getModel());
        tblOrders.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexToSort = 0;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
        
        TableRowSorter<TableModel> sorter1 = new TableRowSorter<>(tblBill.getModel());
        tblBill.setRowSorter(sorter1);
        List<RowSorter.SortKey> sortKeys1 = new ArrayList<>();
        int columnIndexToSort1 = 0;
        sortKeys1.add(new RowSorter.SortKey(columnIndexToSort1, SortOrder.ASCENDING));
        sorter1.setSortKeys(sortKeys1);
        sorter1.sort();
    }

    private void populateTable(){
        //variable declarations
        int OrderID;
        String Starter;
        String Main;
        String Dessert;
        String Drink;
        String Price;
        int r =0;
 
        try
        {
            
            a.createConnection();//creates connection to the database
            
           //creates and runs an sql statemtnt to display all info from the 'tablename2' variable
            a.stmt = a.conn.createStatement();
            ResultSet res = a.stmt.executeQuery("select * from " + a.tableName1);
            ResultSetMetaData rsmd = res.getMetaData();
            int numberCols = rsmd.getColumnCount();
            
            
            //loop will run as long as there is more data to read from the DB, assigning corresponding values accordingly
            while(res.next())
            {
                
            OrderID = res.getInt(1);
            Starter = res.getString(2);
            Main = res.getString(3);
            Dessert = res.getString(4);
            Drink = res.getString(5);
            Price = res.getString(6);
            
            
            //inserts a new row into the table containing an order object with the following properties
            model.insertRow(model.getRowCount(), new Object[]{OrderID, Starter, Main, Dessert, Drink, Price});
           
            r++;
            }//end while loop
            
            //closes and 'shuts down any open streams and connections
            res.close();
            a.stmt.close();
            a.shutdown();
            
            }//end try
        
        //will display apporpriate catch clause if required
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        }
    }
    
    
    private void populateTable1(){
         //variable declarations
        int OrderID;
        String Table;
        String Employee;
        String TotalPrice;
        int r =0;
 
        try
        {
            
            a.createConnection();//creates connection to the database
            
            //creates and runs an sql statemtnt to display all info from the 'tablename2' variable
            a.stmt = a.conn.createStatement();
            ResultSet res = a.stmt.executeQuery("select * from " + a.tableName2);
            
            ResultSetMetaData rsmd = res.getMetaData();
            int numberCols = rsmd.getColumnCount();
            
            //loop will run as long as there is more data to read from the DB, assigning corresponding values accordingly
            while(res.next())
            {
                
            OrderID = res.getInt(1);
            Table = res.getString(2);
            Employee = res.getString(3);
            TotalPrice = res.getString(4);
            
            
       
            //inserts a new row into the table containing an order object with the following properties
            model1.insertRow(model1.getRowCount(), new Object[]{OrderID, Table, Employee, TotalPrice});
           
            r++;
            }//end while loop
            
            //closes and 'shuts down any open streams and connections
            res.close();
            a.stmt.close();
            a.shutdown();
        }//end try
        
        //will display apporpriate catch clause if required
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        
        } catch(IllegalArgumentException a){
            JOptionPane.showMessageDialog(this, "You have entered an illegal character", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        btnNewOrder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        btnRemoveOrder = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Number", "Table No.", "Employee Name", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBill.getTableHeader().setReorderingAllowed(false);
        tblBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBill);
        if (tblBill.getColumnModel().getColumnCount() > 0) {
            tblBill.getColumnModel().getColumn(0).setResizable(false);
            tblBill.getColumnModel().getColumn(1).setResizable(false);
            tblBill.getColumnModel().getColumn(2).setResizable(false);
            tblBill.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 560, 130));

        btnNewOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnNewOrder.setText("New Order");
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 100, 25));

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Order Number", "Starter", "Main", "Dessert", "Drink", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrders.setGridColor(new java.awt.Color(255, 255, 255));
        tblOrders.setRowSelectionAllowed(false);
        tblOrders.getTableHeader().setReorderingAllowed(false);
        tblOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrders);
        if (tblOrders.getColumnModel().getColumnCount() > 0) {
            tblOrders.getColumnModel().getColumn(0).setResizable(false);
            tblOrders.getColumnModel().getColumn(1).setResizable(false);
            tblOrders.getColumnModel().getColumn(2).setResizable(false);
            tblOrders.getColumnModel().getColumn(3).setResizable(false);
            tblOrders.getColumnModel().getColumn(4).setResizable(false);
            tblOrders.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 560, 183));

        btnRemoveOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnRemoveOrder.setText("Remove Order");
        btnRemoveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemoveOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 110, 25));

        btnAdmin.setBackground(new java.awt.Color(255, 255, 255));
        btnAdmin.setText("Admin");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 100, 25));

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Individual Orders");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Order Summary");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Grey-Background-GREY.jpg"))); // NOI18N
        jLabel1.setName(""); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, -10, 590, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        
        Order o = new Order();//creates 'o', a new object based off the Order class
        //controlling visibiiilty
        o.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnNewOrderActionPerformed

    private void btnRemoveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveOrderActionPerformed
       
        int row = tblBill.getSelectedRow();//creates row variable, assigns it to current row
        
        String selected = tblBill.getValueAt(row, 0).toString();//assigns selected variable to the selected order id for deletion purposes
        
            
        
        
        try{
            //creates a connection, creates and runs sql queries to delete the selected order from both tables
            a.createConnection();
            PreparedStatement ps = a.conn.prepareStatement("delete from Price_Table where OrderID='"+selected+"' ");
            PreparedStatement ps1 = a.conn.prepareStatement("delete from ORDER_Table where OrderID='"+selected+"' ");
            ps.executeUpdate();
            ps1.executeUpdate();
            
            //creates two variables to delete the current row through for loops
            int rowCount = model.getRowCount();
            int rowCount1 = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
            }
            for (int ii = rowCount1 - 1; ii >= 0; ii--) {
            model1.removeRow(ii);
            }
            
            //repopulates the tables by re calling the methods
            populateTable();
            populateTable1();
            //restricts the possibility of deleting an order which isn't selected
            btnRemoveOrder.setEnabled(false);
            //confirms deletion
            JOptionPane.showMessageDialog(null, "Deleted");
        }
        //cathes if thrown
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        
        
    }//GEN-LAST:event_btnRemoveOrderActionPerformed

    private void tblBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillMouseClicked
        //allows for the possibility of deletion by enabling the button
        btnRemoveOrder.setEnabled(true);
    }//GEN-LAST:event_tblBillMouseClicked

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
         //creates a new instnace of the admin password frame and sets it to visible
        AdminPassword ap = new AdminPassword();
         ap.setVisible(true);
         this.setVisible(false);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void tblOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdersMouseClicked
        
    }//GEN-LAST:event_tblOrdersMouseClicked

    
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
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JButton btnRemoveOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBill;
    private javax.swing.JTable tblOrders;
    // End of variables declaration//GEN-END:variables
}

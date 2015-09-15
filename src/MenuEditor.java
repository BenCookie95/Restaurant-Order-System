
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IS2209 Group
 */
public class MenuEditor extends javax.swing.JFrame {

    /**
     * Creates new form MenuEditor
     */
    //declaring a new instance of our database class
    database a  = new database();
    //Declaring a new instance of classes
    Starter s = new Starter();
    Main m = new Main();
    Dessert ds = new Dessert();
    Drink dr = new Drink();
    //declaring our table models which pertain to table structures
    DefaultTableModel Startermodel;
    DefaultTableModel Mainmodel;
    DefaultTableModel Dessertmodel;
    DefaultTableModel Drinkmodel;
    public MenuEditor() {
        initComponents();
        //a.dropTable();
        //a.createStarterTable();
        //a.createMainTable();
        //a.createDessertTable();
        //a.createDrinkTable();
        //assigning the default table model to our tables
        Startermodel =  (DefaultTableModel) tblStarters.getModel();
        Mainmodel =     (DefaultTableModel) tblMains.getModel();
        Dessertmodel =  (DefaultTableModel) tblDesserts.getModel();
        Drinkmodel =    (DefaultTableModel) tblDrinks.getModel();
        //calling the method which will populate tables upon initialization
        populateStarterTable();
        populateMainTable();
        populateDessertTable();
        populateDrinkTable();
        //Disabling buttons for validation purposes
        btnAdd.setEnabled(false);
        btnAddMain.setEnabled(false);
        btnAddDessert.setEnabled(false);
        btnAddDrink.setEnabled(false);
        btnDelete.setEnabled(false);
        btnDeleteMain.setEnabled(false);
        btnDeleteDessert.setEnabled(false);
        btnDeleteDrink.setEnabled(false);
        //Document Listeners for validation, buttons become enabled when certain conditions are met
        //Code manipulated from http://stackoverflow.com/questions/10848335/how-to-implement-documentlistener
        txtStarter.getDocument().addDocumentListener(new DocumentListener() 
        {
        @Override
          
        public void changedUpdate(DocumentEvent e){
          StarterlengthCheck();
         }
            @Override
        public void insertUpdate(DocumentEvent e) {
          StarterlengthCheck();
         }
        @Override
        public void removeUpdate(DocumentEvent e) {
           StarterlengthCheck();
         }
        });
        txtStarterPrice.getDocument().addDocumentListener(new DocumentListener() 
        {
            @Override
          
        public void changedUpdate(DocumentEvent e){
          StarterlengthCheck();
         }
            @Override
        public void insertUpdate(DocumentEvent e) {
          StarterlengthCheck();
         }
        @Override
        public void removeUpdate(DocumentEvent e) {
           StarterlengthCheck();
         }
        });
        
        txtMain.getDocument().addDocumentListener(new DocumentListener() {
            @Override
        public void changedUpdate(DocumentEvent e){
          MainlengthCheck();
        }
           @Override
        public void insertUpdate(DocumentEvent e) {
          MainlengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           MainlengthCheck();
        }
        });
        txtMainPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
        public void changedUpdate(DocumentEvent e){
          MainlengthCheck();
        }
           @Override
        public void insertUpdate(DocumentEvent e) {
          MainlengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           MainlengthCheck();
        }
        });
         
        txtDessert.getDocument().addDocumentListener(new DocumentListener() 
        {
            @Override 
        public void changedUpdate(DocumentEvent e){
          DessertlengthCheck();
        }
            @Override
        public void insertUpdate(DocumentEvent e) {
          DessertlengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           DessertlengthCheck();
         }
        });
          
        txtDessertPrice.getDocument().addDocumentListener(new DocumentListener() 
        {
            @Override
          
        public void changedUpdate(DocumentEvent e){
          DessertlengthCheck();
        }
            @Override
        public void insertUpdate(DocumentEvent e) {
          DessertlengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           DessertlengthCheck();
        }
        });
         
        txtDrink.getDocument().addDocumentListener(new DocumentListener() {
            @Override
        public void changedUpdate(DocumentEvent e){
          DrinklengthCheck();
        }
           @Override
        public void insertUpdate(DocumentEvent e) {
          DrinklengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           DrinklengthCheck();
        }
        });
    
        txtDrinkPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
        public void changedUpdate(DocumentEvent e){
          DrinklengthCheck();
        }
           @Override
        public void insertUpdate(DocumentEvent e) {
          DrinklengthCheck();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           DrinklengthCheck();
        }
        });
        }
    
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //populate the table for the starters
    public void populateStarterTable()
    {
       
        String Starter;
        String StarterPrice;
        int r =0;
 
        try
        {
            a.createConnection();//creates connection to the database
            //creates and runs an sql statemtnt to display all info from the 'StarterTable' variable
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.StarterTable);
            
            
            
            //loop will run as long as there is more data to read from the DB, assigning corresponding values accordingly
            while(results.next())
            {              
            Starter = results.getString(1);
            StarterPrice = results.getString(2);
            //inserts a new row into the table containing an order object with the following properties
            Startermodel.insertRow(Startermodel.getRowCount(), new Object[]{Starter, StarterPrice});
            r++;
            }//end while loop
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
    
    private void insertStarter(Starter s)
    {
        a.createConnection();//Creates a connection to the database
        try
        {
            a.stmt = a.conn.createStatement();//creates and runs an sql statemtnt to insert all info from the textfields
            a.stmt.execute("insert into " + a.StarterTable + " values ('" +
                    s.getStarter() + "','" + s.getStarterPrice()+"')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();//closes Connection
    }
    //method used in the document Listener for validation purposes
    public void StarterlengthCheck(){
        if(txtStarter.getText().equals("") || txtStarterPrice.getText().equals("")){
            btnAdd.setEnabled(false);
            btnDelete.setEnabled(false);
        }
        else if(txtStarter.getText().length()> 100 || txtStarter.getText().length()>100){
            btnAdd.setEnabled(false);
        }
        else{
            btnAdd.setEnabled(true);
        }
      }
    
    @SuppressWarnings("unchecked")
    
     public void populateMainTable()
    {
       
        String Main;
        String MainPrice;
        int r =0;
 
        try
        {
            a.createConnection();//creates a connection to the database
            //creates and runs an sql statemtnt to display all info from the 'StarterTable' variable
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.MainTable);
            ResultSetMetaData rsmd = results.getMetaData();
            //Fills the Table until it reaches the end of the database
            while(results.next())
            {              
            Main = results.getString(1);
            MainPrice = results.getString(2);
            //inserts a new row into the table containing an order object with the following properties
            Mainmodel.insertRow(Mainmodel.getRowCount(), new Object[]{Main, MainPrice});
            r++;
            }//end of loop
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
    
    private void insertMain(Main m)
    {
        a.createConnection();//creates a connection to the database
        try
        {
            a.stmt = a.conn.createStatement();//creates and exectutes an sql statement to insert data to the database
            a.stmt.execute("insert into " + a.MainTable + " values ('" +
                            m.getMain() + "','" + m.getMainPrice()+"')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }
    //Creates method used in document listener
    public void MainlengthCheck(){
        if(txtMain.getText().equals("") || txtMainPrice.getText().equals("")){
            btnAddMain.setEnabled(false);
            btnDeleteMain.setEnabled(false);
        }
        else if(txtMain.getText().length()> 100 || txtMain.getText().length()>100){
            btnAddMain.setEnabled(false);
        }
        else{
            btnAddMain.setEnabled(true);
        }
      }
    
    @SuppressWarnings("unchecked")
    //Doing same thing as other populate methods
     public void populateDessertTable()
    {
       
        String Dessert;
        String DessertPrice;
       
        int r =0;
 
        try
        {
            a.createConnection();
            
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.DessertTable);
            ResultSetMetaData rsmd = results.getMetaData();

            while(results.next())
            {              
            Dessert = results.getString(1);
            DessertPrice = results.getString(2);
          
            Dessertmodel.insertRow(Dessertmodel.getRowCount(), new Object[]{Dessert, DessertPrice});
            r++;
            }//end of loop
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        
        } catch(IllegalArgumentException a){
            JOptionPane.showMessageDialog(this, "You have entered an illegal character", "Error", JOptionPane.ERROR_MESSAGE);
        }
              
    }
    //inserts data into the Dessert table in the same way as the other methods
    private void insertDessert(Dessert ds)
    {
        a.createConnection();
        try
        {
            a.stmt = a.conn.createStatement();
            a.stmt.execute("insert into " + a.DessertTable + " values ('" +
                    ds.getDessert() + "','" + ds.getDessertPrice()+"')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }
    //method used in document listener
    public void DessertlengthCheck(){
          if(txtDessert.getText().equals("") || txtDessertPrice.getText().equals("")){
              btnAddDessert.setEnabled(false);
              btnDeleteDessert.setEnabled(false);
          }
          else if(txtDessert.getText().length()> 100 || txtDessert.getText().length()>100){
               btnAddDessert.setEnabled(false);
          }
          else{
               btnAddDessert.setEnabled(true);
          }
      }
    
    @SuppressWarnings("unchecked")
    //Populates Drink table the same way as previous methods
    public void populateDrinkTable()
    {
       
        String Drink;
        String DrinkPrice;
       
        int r =0;
 
        try
        {
            a.createConnection();
            
            a.stmt = a.conn.createStatement();
            ResultSet results = a.stmt.executeQuery("select * from " + a.DrinkTable);
            ResultSetMetaData rsmd = results.getMetaData();
            
            while(results.next())
            {              
            Drink = results.getString(1);
            DrinkPrice = results.getString(2);
          
            Drinkmodel.insertRow(Drinkmodel.getRowCount(), new Object[]{Drink, DrinkPrice});
            r++;
            }
            results.close();
            a.stmt.close();
            a.shutdown();
        }
        catch (SQLException sqlExcept )
        {
           sqlExcept.printStackTrace();
        }
              
    }
    //inserts drink info into drink table the same way as previous methods
    private void insertDrink(Drink dr)
    {
        a.createConnection();
        try
        {
            a.stmt = a.conn.createStatement();
            a.stmt.execute("insert into " + a.DrinkTable + " values ('" +
                    dr.getDrink() + "','" + dr.getDrinkPrice()+"')");
            a.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        a.shutdown();
    }
    //Method used in document listener
    public void DrinklengthCheck(){
          if(txtDrink.getText().equals("") || txtDrinkPrice.getText().equals("")){
              btnAddDrink.setEnabled(false);
              btnDeleteDrink.setEnabled(false);
          }
          else if(txtDrink.getText().length()> 100 || txtDrink.getText().length()>100){
               btnAddDrink.setEnabled(false);
          }
          else{
               btnAddDrink.setEnabled(true);
          }
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStarters = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMains = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDesserts = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDrinks = new javax.swing.JTable();
        txtStarter = new javax.swing.JTextField();
        txtStarterPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtMainPrice = new javax.swing.JTextField();
        btnAddMain = new javax.swing.JButton();
        btnDeleteMain = new javax.swing.JButton();
        txtMain = new javax.swing.JTextField();
        txtDessertPrice = new javax.swing.JTextField();
        btnAddDessert = new javax.swing.JButton();
        btnDeleteDessert = new javax.swing.JButton();
        txtDessert = new javax.swing.JTextField();
        btnAddDrink = new javax.swing.JButton();
        txtDrinkPrice = new javax.swing.JTextField();
        btnDeleteDrink = new javax.swing.JButton();
        txtDrink = new javax.swing.JTextField();
        btnDeselectS = new javax.swing.JButton();
        btnDeselectM = new javax.swing.JButton();
        btnDeselectDes = new javax.swing.JButton();
        btnDeselectDr = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        btnBack.setText("Back to Home");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblStarters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Starters", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStarters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStartersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStarters);
        if (tblStarters.getColumnModel().getColumnCount() > 0) {
            tblStarters.getColumnModel().getColumn(0).setResizable(false);
            tblStarters.getColumnModel().getColumn(1).setMinWidth(70);
            tblStarters.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblStarters.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 242, 138));

        tblMains.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Main Courses", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMains.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMainsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMains);
        if (tblMains.getColumnModel().getColumnCount() > 0) {
            tblMains.getColumnModel().getColumn(0).setResizable(false);
            tblMains.getColumnModel().getColumn(1).setMinWidth(70);
            tblMains.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblMains.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 242, 138));

        tblDesserts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Desserts", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDesserts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDessertsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDesserts);
        if (tblDesserts.getColumnModel().getColumnCount() > 0) {
            tblDesserts.getColumnModel().getColumn(0).setResizable(false);
            tblDesserts.getColumnModel().getColumn(1).setMinWidth(70);
            tblDesserts.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblDesserts.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 309, 242, 138));

        tblDrinks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drinks", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDrinks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDrinksMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDrinks);
        if (tblDrinks.getColumnModel().getColumnCount() > 0) {
            tblDrinks.getColumnModel().getColumn(0).setResizable(false);
            tblDrinks.getColumnModel().getColumn(1).setMinWidth(70);
            tblDrinks.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblDrinks.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 458, 242, 138));
        getContentPane().add(txtStarter, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 57, 150, -1));
        getContentPane().add(txtStarterPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 88, 150, -1));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add Starter");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 120, 120, -1));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete Starter");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 120, 120, -1));
        getContentPane().add(txtMainPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 244, 150, -1));

        btnAddMain.setBackground(new java.awt.Color(255, 255, 255));
        btnAddMain.setText("Add Main");
        btnAddMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMainActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 275, 120, -1));

        btnDeleteMain.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteMain.setText("Delete Order");
        btnDeleteMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMainActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 275, 120, -1));
        getContentPane().add(txtMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 213, 150, -1));
        getContentPane().add(txtDessertPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 377, 150, -1));

        btnAddDessert.setBackground(new java.awt.Color(255, 255, 255));
        btnAddDessert.setText("Add Dessert");
        btnAddDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDessertActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddDessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 424, 120, -1));

        btnDeleteDessert.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteDessert.setText("Delete Dessert");
        btnDeleteDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDessertActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteDessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 424, 120, -1));
        getContentPane().add(txtDessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 346, 150, -1));

        btnAddDrink.setBackground(new java.awt.Color(255, 255, 255));
        btnAddDrink.setText("Add Drink");
        btnAddDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDrinkActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 573, 120, -1));
        getContentPane().add(txtDrinkPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 538, 150, -1));

        btnDeleteDrink.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteDrink.setText("Delete Drink");
        btnDeleteDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDrinkActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 573, 120, -1));

        txtDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDrinkActionPerformed(evt);
            }
        });
        getContentPane().add(txtDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 507, 150, -1));

        btnDeselectS.setBackground(new java.awt.Color(255, 255, 255));
        btnDeselectS.setText("Deselect");
        btnDeselectS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectSActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeselectS, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 70, 86, -1));

        btnDeselectM.setBackground(new java.awt.Color(255, 255, 255));
        btnDeselectM.setText("Deselect");
        btnDeselectM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectMActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeselectM, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 225, 86, -1));

        btnDeselectDes.setBackground(new java.awt.Color(255, 255, 255));
        btnDeselectDes.setText("Deselect");
        btnDeselectDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectDesActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeselectDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 359, 86, -1));

        btnDeselectDr.setBackground(new java.awt.Color(255, 255, 255));
        btnDeselectDr.setText("Deselect");
        btnDeselectDr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectDrActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeselectDr, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 522, 86, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Starter");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 58, -1, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Starter Price");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 89, -1, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Main Course");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 214, -1, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Dessert");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 347, -1, -1));

        jLabel16.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Main Course Price");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 245, -1, -1));

        jLabel17.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Dessert Price");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 378, -1, -1));

        jLabel18.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Drink");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 508, -1, -1));

        jLabel19.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Drink Price");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 539, -1, -1));

        btnBack1.setBackground(new java.awt.Color(255, 255, 255));
        btnBack1.setText("Back to Home");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 607, 110, 25));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Grey-Background-GREY.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //adding data to the Starter table
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       
       try{
        Double.parseDouble(txtStarterPrice.getText());//Checking if the text is double in the price text field
        //Inserts data into table
        Startermodel.insertRow(Startermodel.getRowCount(), new Object[]{txtStarter.getText(), txtStarterPrice.getText()});
        //Gets info from textfields to be used to populate database table
        s.setStarter(txtStarter.getText());
        s.setStarterPrice(txtStarterPrice.getText());
        //Clears text fields
        txtStarter.setText(null);
        txtStarterPrice.setText(null);
        //Calls method insert starter and passes the textfield values
        insertStarter(s);
       }
       catch(Exception c){
            //catched the error if a number isn't entered in the price text field
            JOptionPane.showMessageDialog(null, "You can only enter numbers into the price textfield");
            txtStarter.setText(null);
            txtStarterPrice.setText(null);
            btnAdd.setEnabled(false);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //Sets a variable equal to the selected row
        int row = tblStarters.getSelectedRow();
        //Sets the variable selected equal to firstvalue in selected row and sets it to a string
        String selected = tblStarters.getValueAt(row, 0).toString();
        
            
        
        if (row >= 0) {
                //removes row from table
                Startermodel.removeRow(row);
        try{
            a.createConnection();//creates connection
            //prepares and executes sql statement to delete from the database
            PreparedStatement ps = a.conn.prepareStatement("delete from Starter_Table where Starter='"+selected+"' ");
            ps.executeUpdate();
                    
            txtStarter.setText(null);
            txtStarterPrice.setText(null);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblStartersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStartersMouseClicked
        //sets the selected row equal to the variable
        int row = tblStarters.getSelectedRow();
        //Sets the variable 'selected' equal to firstvalue in selected row and sets it to a string
        String selected = tblStarters.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)tblStarters.getModel();
        try{
        if(selected !=null ){
            //Puts the selected row text into text fields
            txtStarter.setText(String.valueOf(model.getValueAt(tblStarters.getSelectedRow(), 0)));
            txtStarterPrice.setText(String.valueOf(model.getValueAt(tblStarters.getSelectedRow(), 1)));
            //Disable buttons for validation purposes
            btnDelete.setEnabled(true);
            btnAdd.setEnabled(false);
        }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }//GEN-LAST:event_tblStartersMouseClicked
    //does the same as previous add button
    private void btnAddMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMainActionPerformed
        try{
        Double.parseDouble(txtMainPrice.getText());
        Mainmodel.insertRow(Mainmodel.getRowCount(), new Object[]{txtMain.getText(), txtMainPrice.getText()});
        m.setMain(txtMain.getText());
        m.setMainPrice(txtMainPrice.getText());
        
        txtMain.setText(null);
        txtMainPrice.setText(null);
        
        insertMain(m);
        }
        catch(Exception c){
            JOptionPane.showMessageDialog(null, "You can only enter numbers into the price textfield");
            txtMain.setText(null);
            txtMainPrice.setText(null);
            btnAddMain.setEnabled(false);
        }
    }//GEN-LAST:event_btnAddMainActionPerformed
    //does the same as previous delete buttons
    private void btnDeleteMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMainActionPerformed
            
        int row = tblMains.getSelectedRow();
        String selected = tblMains.getValueAt(row, 0).toString();
        if (row >= 0) {

                Mainmodel.removeRow(row);
        try{
            a.createConnection();
            PreparedStatement ps = a.conn.prepareStatement("delete from Mains_Table where Main='"+selected+"' ");
            ps.executeUpdate();
                    
            txtMain.setText(null);
            txtMainPrice.setText(null);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        }
        
    }//GEN-LAST:event_btnDeleteMainActionPerformed
    //does the same as previous add buttons
    private void btnAddDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDessertActionPerformed
        try{
            Double.parseDouble(txtDessertPrice.getText());
            Dessertmodel.insertRow(Dessertmodel.getRowCount(), new Object[]{txtDessert.getText(), txtDessertPrice.getText()});
            ds.setDessert(txtDessert.getText());
            ds.setDessertPrice(txtDessertPrice.getText());
            txtDessert.setText(null);
            txtDessertPrice.setText(null);
            insertDessert(ds);
        }
        catch(Exception c){
            JOptionPane.showMessageDialog(null, "You can only enter numbers into the price textfield");
            txtDessert.setText(null);
            txtDessertPrice.setText(null);
            btnAddDessert.setEnabled(false);
        }
    }//GEN-LAST:event_btnAddDessertActionPerformed
    //does the same as previous delete buttons
    private void btnDeleteDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDessertActionPerformed
        
        int row = tblDesserts.getSelectedRow();
        
        String selected = tblDesserts.getValueAt(row, 0).toString();
        if (row >= 0) {

            Dessertmodel.removeRow(row);
        try{
            a.createConnection();
            PreparedStatement ps = a.conn.prepareStatement("delete from Dessert_Table where Dessert='"+selected+"' ");
            ps.executeUpdate();
                    
            txtDessert.setText(null);
            txtDessertPrice.setText(null);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
        catch(SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }   
        }
        
    }//GEN-LAST:event_btnDeleteDessertActionPerformed
    //does the same as previous add buttons
    private void btnAddDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDrinkActionPerformed
        try{
        
        Double.parseDouble(txtDrinkPrice.getText());
        Drinkmodel.insertRow(Drinkmodel.getRowCount(), new Object[]{txtDrink.getText(), txtDrinkPrice.getText()});
        dr.setDrink(txtDrink.getText());
        dr.setDrinkPrice(txtDrinkPrice.getText());
        
        txtDrink.setText(null);
        txtDrinkPrice.setText(null);
        
        insertDrink(dr);
        }
        catch(Exception c){
            JOptionPane.showMessageDialog(null, "You can only enter numbers into the price textfield");
            txtDrink.setText(null);
            txtDrinkPrice.setText(null);
            btnAddDrink.setEnabled(false);
        }
        
    }//GEN-LAST:event_btnAddDrinkActionPerformed
    //does the same as previous delete buttons
    private void btnDeleteDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDrinkActionPerformed
        
        int row = tblDrinks.getSelectedRow();
        String selected = tblDrinks.getValueAt(row, 0).toString();

        if (row >= 0) {

                Drinkmodel.removeRow(row);
        try{
            a.createConnection();
            PreparedStatement ps = a.conn.prepareStatement("delete from Drink_Table where Drink='"+selected+"' ");
            ps.executeUpdate();          
            txtDrink.setText(null);
            txtDrinkPrice.setText(null);
            JOptionPane.showMessageDialog(null, "Deleted");
            
        }
         catch(SQLException sqlExcept){
             sqlExcept.printStackTrace();
         }   
        }
        
    }//GEN-LAST:event_btnDeleteDrinkActionPerformed
    //does the same as previous table click events
    private void tblMainsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMainsMouseClicked

        int row = tblMains.getSelectedRow();
        
        String selected = tblMains.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)tblMains.getModel();
        try{
        if(selected !=null ){
            txtMain.setText(String.valueOf(model.getValueAt(tblMains.getSelectedRow(), 0)));
            txtMainPrice.setText(String.valueOf(model.getValueAt(tblMains.getSelectedRow(), 1)));
            
            btnDeleteMain.setEnabled(true);
            btnAddMain.setEnabled(false);
        }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Deleted");
        }

    }//GEN-LAST:event_tblMainsMouseClicked
    //does the same as previous table click events
    private void tblDessertsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDessertsMouseClicked
        int row = tblDesserts.getSelectedRow();
        
        String selected = tblDesserts.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)tblDesserts.getModel();
        try{
        if(selected !=null ){
            txtDessert.setText(String.valueOf(model.getValueAt(tblDesserts.getSelectedRow(), 0)));
            txtDessertPrice.setText(String.valueOf(model.getValueAt(tblDesserts.getSelectedRow(), 1)));
            
            btnDeleteDessert.setEnabled(true);
            btnAddDessert.setEnabled(false);
        }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }//GEN-LAST:event_tblDessertsMouseClicked
    //does the same as previous table click events
    private void tblDrinksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDrinksMouseClicked
        
        int row = tblDrinks.getSelectedRow();
        
        String selected = tblDrinks.getValueAt(row, 0).toString();
        DefaultTableModel model= (DefaultTableModel)tblDrinks.getModel();
        try{
        if(selected !=null ){
            txtDrink.setText(String.valueOf(model.getValueAt(tblDrinks.getSelectedRow(), 0)));
            txtDrinkPrice.setText(String.valueOf(model.getValueAt(tblDrinks.getSelectedRow(), 1)));
            
            btnDeleteDrink.setEnabled(true);
            btnAddDrink.setEnabled(false);
        }
        } catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Deleted");
        }
        
    }//GEN-LAST:event_tblDrinksMouseClicked

    private void txtDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDrinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDrinkActionPerformed
    //deselects the selected row from the table
    private void btnDeselectSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectSActionPerformed
        
        tblStarters.getSelectionModel().clearSelection();
        txtStarter.setText(null);
        txtStarterPrice.setText(null);
        
    }//GEN-LAST:event_btnDeselectSActionPerformed
    //deselects the selected row from the table
    private void btnDeselectMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectMActionPerformed
        
        tblMains.getSelectionModel().clearSelection();
        txtMain.setText(null);
        txtMainPrice.setText(null);
        
    }//GEN-LAST:event_btnDeselectMActionPerformed
    //deselects the selected row from the table
    private void btnDeselectDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectDesActionPerformed
        
        tblDesserts.getSelectionModel().clearSelection();
        txtDessert.setText(null);
        txtDessertPrice.setText(null);
        
    }//GEN-LAST:event_btnDeselectDesActionPerformed
    //deselects the selected row from the table
    private void btnDeselectDrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectDrActionPerformed
        
        tblDrinks.getSelectionModel().clearSelection();
        txtDrink.setText(null);
        txtDrinkPrice.setText(null);
        
    }//GEN-LAST:event_btnDeselectDrActionPerformed
    //Navigates back to previous form
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Homepage h = new Homepage();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        Frame h = new Frame();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBack1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddDessert;
    private javax.swing.JButton btnAddDrink;
    private javax.swing.JButton btnAddMain;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteDessert;
    private javax.swing.JButton btnDeleteDrink;
    private javax.swing.JButton btnDeleteMain;
    private javax.swing.JButton btnDeselectDes;
    private javax.swing.JButton btnDeselectDr;
    private javax.swing.JButton btnDeselectM;
    private javax.swing.JButton btnDeselectS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblDesserts;
    private javax.swing.JTable tblDrinks;
    private javax.swing.JTable tblMains;
    private javax.swing.JTable tblStarters;
    private javax.swing.JTextField txtDessert;
    private javax.swing.JTextField txtDessertPrice;
    private javax.swing.JTextField txtDrink;
    private javax.swing.JTextField txtDrinkPrice;
    private javax.swing.JTextField txtMain;
    private javax.swing.JTextField txtMainPrice;
    private javax.swing.JTextField txtStarter;
    private javax.swing.JTextField txtStarterPrice;
    // End of variables declaration//GEN-END:variables
}

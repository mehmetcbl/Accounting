/*
 * POWERED BY
 * 
 * OKAN ÜLKER - 17050111024
 * EMRE KÖRÜS - 16050111041
 * MEHMET ALİ CABİOĞLU - 16050111044
 */
package Frames;

import Models.FutureOperation;
import Models.InstantOperation;
import Utils.SystemFunctions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {
    
    public MainFrame() {
        initComponents();
        setTitle("OEM Accounting");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy  EEEE");
        Date date = new Date();
        labelDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        labelDate.setText(dateFormat.format(date));
        fillTheTable();
        fillComboBox();
        lblCompanyName.setText(SystemFunctions.getCompany().getCompanyName());
        lblCompanyOwner.setText(SystemFunctions.getCompany().getCompanyOwner());
        lblCompanyPhoneNumber.setText("GSM: "+SystemFunctions.getCompany().getCompanyPhoneNumber());
        
        lblBalance.setText(String.valueOf(SystemFunctions.getCompany().getBalance()));
        lblDebt.setText(String.valueOf(SystemFunctions.getCompany().getDebt()));
        lblClaim.setText(String.valueOf(SystemFunctions.getCompany().getClaim()));
        
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                SystemFunctions.saveCompanyToDatabase();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
    }
    
    private void fillComboBox() {
        ArrayList<String> cbItems = new ArrayList<>();
        for (int i = 0; i < SystemFunctions.getProductList().size(); i++) {
         
            boolean flag = false;

            for (int j = 0; j < cbItems.size(); j++) {
                if (cbItems.get(j).equals(SystemFunctions.getProductList().get(i).getName())) {
                    flag = true;
                }
            }
            if(!flag){
                cbItems.add(SystemFunctions.getProductList().get(i).getName());
            }
      
        }
        
        
        
        
        for (int i = 0; i < cbItems.size(); i++) {
            cbSearch.addItem(cbItems.get(i));

        }

        
        cbSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String result = "                   Available Product Information\n\n";
                
                for (int i = 0; i < SystemFunctions.getProductList().size(); i++) {
            
                    if (SystemFunctions.getProductList().get(i).getName().equalsIgnoreCase(cbSearch.getSelectedItem().toString()) ) {
                        
                        
                        result += "   Barcode: " + SystemFunctions.getProductList().get(i).getBarcode() + "\n";
                        result += "   Name: " + SystemFunctions.getProductList().get(i).getName() + "\n";
                        result += "   Amount: " + SystemFunctions.getProductList().get(i).getStock() + "\n\n";
                    }
                       
                }
                
                taProduct.setText(result);
            }
        });
        
    }
    
    private void fillTheTable() {
        int index = 0;
        
        tabbedPaneShow.addTab("Future Operations", panelInstant);
        tabbedPaneShow.addTab("Instant Operations", panelFuture);
        
        DefaultTableModel model1 = (DefaultTableModel)databasetable.getModel();
        DefaultTableModel model2 = (DefaultTableModel)databasetable2.getModel();
        
        //at beginning there will be no row at all.
        model1.setRowCount(0);
        model2.setRowCount(0);
        
        ArrayList<InstantOperation> instantOperations = new ArrayList<>();
        ArrayList<FutureOperation> futureOperations = new ArrayList<>();
        
        for (int i = 0; i < SystemFunctions.getOperationList().size(); i++) {
            
            InstantOperation opp = (InstantOperation) SystemFunctions.getOperationList().get(i);
            
            if (opp instanceof FutureOperation)
                futureOperations.add((FutureOperation)opp);
            else
                instantOperations.add(opp);
        }
        
        while (futureOperations.size() > index) {
           model1.addRow(new Object[]{futureOperations.get(index).getOperationType(), futureOperations.get(index).getProduct().getName(), futureOperations.get(index).getProduct().getBarcode(), futureOperations.get(index).getProduct().getStock(), futureOperations.get(index).getProduct().getPrice()}); 
           index++;
        }
        index=0;
        while (instantOperations.size() > index) {
            model2.addRow(new Object[]{instantOperations.get(index).getOperationType(), instantOperations.get(index).getProduct().getName(), instantOperations.get(index).getProduct().getBarcode(), instantOperations.get(index).getProduct().getStock(), instantOperations.get(index).getProduct().getPrice()}); 
           index++;
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

        jPanel1 = new javax.swing.JPanel();
        panelCompanyInfo = new javax.swing.JPanel();
        lblCompanyName = new javax.swing.JLabel();
        lblCompanyOwner = new javax.swing.JLabel();
        lblCompanyPhoneNumber = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelDate = new javax.swing.JLabel();
        cbSearch = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        taProduct = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        btnBuy = new javax.swing.JButton();
        btnClaim = new javax.swing.JButton();
        btnDebt = new javax.swing.JButton();
        btnSell = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        labelBalance = new javax.swing.JLabel();
        labelDebt = new javax.swing.JLabel();
        labelClaim = new javax.swing.JLabel();
        lblDebt = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        lblClaim = new javax.swing.JLabel();
        btnSettings = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        tabbedPaneShow = new javax.swing.JTabbedPane();
        panelInstant = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        databasetable = new javax.swing.JTable();
        panelFuture = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        databasetable2 = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 250));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelCompanyInfo.setBackground(new java.awt.Color(255, 255, 255));
        panelCompanyInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblCompanyName.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        lblCompanyOwner.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        lblCompanyPhoneNumber.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelCompanyInfoLayout = new javax.swing.GroupLayout(panelCompanyInfo);
        panelCompanyInfo.setLayout(panelCompanyInfoLayout);
        panelCompanyInfoLayout.setHorizontalGroup(
            panelCompanyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompanyInfoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelCompanyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCompanyName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCompanyOwner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCompanyPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        panelCompanyInfoLayout.setVerticalGroup(
            panelCompanyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompanyInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCompanyOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCompanyPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Date", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        labelDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        cbSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSearchActionPerformed(evt);
            }
        });

        taProduct.setEditable(false);
        taProduct.setColumns(20);
        taProduct.setRows(5);
        jScrollPane2.setViewportView(taProduct);

        btnBuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/İmage/Buy.png"))); // NOI18N
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        btnClaim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/İmage/Claim.png"))); // NOI18N
        btnClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClaimActionPerformed(evt);
            }
        });

        btnDebt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/İmage/Debt.png"))); // NOI18N
        btnDebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebtActionPerformed(evt);
            }
        });

        btnSell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/İmage/Sell.png"))); // NOI18N
        btnSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSellActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        jLabel1.setText("Sell");

        jLabel2.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        jLabel2.setText("Buy");

        jLabel3.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        jLabel3.setText("Claim");

        jLabel4.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        jLabel4.setText("Debt");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnClaim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuy)
                            .addComponent(btnDebt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSell, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDebt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClaim, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        labelBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBalance.setText("BALANCE");

        labelDebt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDebt.setText("DEBT");

        labelClaim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelClaim.setText("CLAIM");
        labelClaim.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblDebt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDebt.setText(" ");

        lblBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBalance.setText(" ");

        lblClaim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClaim.setText(" ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBalance)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelDebt))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(labelClaim)))
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblClaim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDebt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelBalance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBalance)
                .addGap(9, 9, 9)
                .addComponent(labelDebt)
                .addGap(9, 9, 9)
                .addComponent(lblDebt)
                .addGap(18, 18, 18)
                .addComponent(labelClaim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblClaim)
                .addGap(22, 22, 22))
        );

        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/İmage/Settings.png"))); // NOI18N
        btnSettings.setText("   Settings");
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/İmage/Help.png"))); // NOI18N
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        tabbedPaneShow.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        panelInstant.setLayout(new javax.swing.OverlayLayout(panelInstant));

        databasetable.setBorder(new javax.swing.border.MatteBorder(null));
        databasetable.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        databasetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Operation", "Product Name", "Barcode No", "Amount", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        databasetable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(databasetable);

        panelInstant.add(jScrollPane1);

        tabbedPaneShow.addTab("tab2", panelInstant);

        panelFuture.setLayout(new javax.swing.OverlayLayout(panelFuture));

        databasetable2.setBorder(new javax.swing.border.MatteBorder(null));
        databasetable2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        databasetable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Operation", "Product Name", "Barcode No", "Amount", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        databasetable2.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(databasetable2);

        panelFuture.add(jScrollPane4);

        tabbedPaneShow.addTab("tab1", panelFuture);

        jRadioButton1.setText("jRadioButton1");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/İmage/logo.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPaneShow, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelCompanyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(107, 107, 107))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelCompanyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnHelp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSettings, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2))
                        .addComponent(tabbedPaneShow, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClaimActionPerformed
        
        SystemFunctions.changeToFrame(new ClaimFrame(), this);
    }//GEN-LAST:event_btnClaimActionPerformed

    private void btnDebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebtActionPerformed
        
        SystemFunctions.changeToFrame(new DebtFrame(), this);
    }//GEN-LAST:event_btnDebtActionPerformed

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSellActionPerformed
        
        SystemFunctions.changeToFrame(new InstantClaimFrame(), this);
    }//GEN-LAST:event_btnSellActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        
        SystemFunctions.changeToFrame(new InstantDebtFrame(), this);
    }//GEN-LAST:event_btnBuyActionPerformed

    private void cbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSearchActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        // TODO add your handling code here:
        SystemFunctions.changeToFrame(new SettingsFrame(), this);
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
        
        SystemFunctions.changeToFrame(new HelpFrame(), this);
    }//GEN-LAST:event_btnHelpActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnClaim;
    private javax.swing.JButton btnDebt;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnSell;
    private javax.swing.JButton btnSettings;
    private javax.swing.JComboBox<String> cbSearch;
    private javax.swing.JTable databasetable;
    private javax.swing.JTable databasetable2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelBalance;
    private javax.swing.JLabel labelClaim;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelDebt;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblClaim;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblCompanyOwner;
    private javax.swing.JLabel lblCompanyPhoneNumber;
    private javax.swing.JLabel lblDebt;
    private javax.swing.JPanel panelCompanyInfo;
    private javax.swing.JPanel panelFuture;
    private javax.swing.JPanel panelInstant;
    private javax.swing.JTextArea taProduct;
    private javax.swing.JTabbedPane tabbedPaneShow;
    // End of variables declaration//GEN-END:variables
}

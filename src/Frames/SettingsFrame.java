/*
 * POWERED BY
 * 
 * OKAN ÜLKER - 17050111024
 * EMRE KÖRÜS - 16050111041
 * MEHMET ALİ CABİOĞLU - 16050111044
 */
package Frames;

import Models.Company;
import Utils.SystemFunctions;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.WindowConstants;


public class SettingsFrame extends javax.swing.JFrame {
    
    public SettingsFrame() {
        initComponents();
        setTitle("OEM Accounting");
        tfCompanyName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfOwner.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPhoneNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfTaxNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        
        tfCompanyName.setText(SystemFunctions.getCompany().getCompanyName());
        tfOwner.setText(SystemFunctions.getCompany().getCompanyOwner());
        tfPhoneNumber.setText(SystemFunctions.getCompany().getCompanyPhoneNumber());
        tfEmail.setText(SystemFunctions.getCompany().getCompanyEmail());
        tfTaxNumber.setText(SystemFunctions.getCompany().getCompanyTaxNumber().toString());
        
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                SystemFunctions.changeToFrame(new MainFrame(), SettingsFrame.this);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        tfCompanyName = new javax.swing.JTextField();
        tfOwner = new javax.swing.JTextField();
        tfPhoneNumber = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        tfTaxNumber = new javax.swing.JTextField();
        btnChange = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(800, 250));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(153, 153, 153));
        lblTitle.setText("Company Information");

        tfCompanyName.setText("Company Name");
        tfCompanyName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));
        tfCompanyName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfCompanyNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCompanyNameFocusLost(evt);
            }
        });
        tfCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCompanyNameActionPerformed(evt);
            }
        });

        tfOwner.setText("Owner");
        tfOwner.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));
        tfOwner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfOwnerFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfOwnerFocusLost(evt);
            }
        });
        tfOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOwnerActionPerformed(evt);
            }
        });

        tfPhoneNumber.setText("Phone Number");
        tfPhoneNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));
        tfPhoneNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPhoneNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPhoneNumberFocusLost(evt);
            }
        });
        tfPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPhoneNumberActionPerformed(evt);
            }
        });

        tfEmail.setText("E-Mail");
        tfEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));
        tfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfEmailFocusLost(evt);
            }
        });
        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });

        tfTaxNumber.setText("TaxNumber");
        tfTaxNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));
        tfTaxNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfTaxNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTaxNumberFocusLost(evt);
            }
        });
        tfTaxNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTaxNumberActionPerformed(evt);
            }
        });

        btnChange.setBackground(new java.awt.Color(153, 153, 153));
        btnChange.setText("Change");
        btnChange.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 5, true));
        btnChange.setBorderPainted(false);
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        jRadioButton1.setText("jRadioButton1");

        jButton1.setText("Change Balance-Claim-Debt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(422, 422, 422))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTaxNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(4, 4, 4)
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(tfCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTaxNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCompanyNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCompanyNameFocusGained
        tfCompanyName.setText("");
    }//GEN-LAST:event_tfCompanyNameFocusGained

    private void tfCompanyNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCompanyNameFocusLost
        if (tfCompanyName.getText().equalsIgnoreCase("")) {
            

            tfCompanyName.setText(SystemFunctions.getCompany().getCompanyName());
        }
    }//GEN-LAST:event_tfCompanyNameFocusLost

    private void tfCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCompanyNameActionPerformed
        // TODO add your handling code here:
        tfCompanyName.setText("");
    }//GEN-LAST:event_tfCompanyNameActionPerformed

    private void tfOwnerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfOwnerFocusGained
        tfOwner.setText("");
    }//GEN-LAST:event_tfOwnerFocusGained

    private void tfOwnerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfOwnerFocusLost
        if (tfOwner.getText().equalsIgnoreCase("")) {

            tfOwner.setText(SystemFunctions.getCompany().getCompanyOwner());
        }
    }//GEN-LAST:event_tfOwnerFocusLost

    private void tfOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOwnerActionPerformed
        tfOwner.setText("");
    }//GEN-LAST:event_tfOwnerActionPerformed

    private void tfPhoneNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPhoneNumberFocusGained
        tfPhoneNumber.setText("");
    }//GEN-LAST:event_tfPhoneNumberFocusGained

    private void tfPhoneNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPhoneNumberFocusLost
        if (tfPhoneNumber.getText().equalsIgnoreCase("")) {

            tfPhoneNumber.setText(SystemFunctions.getCompany().getCompanyPhoneNumber());
        }
    }//GEN-LAST:event_tfPhoneNumberFocusLost

    private void tfPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPhoneNumberActionPerformed
        tfPhoneNumber.setText("");
    }//GEN-LAST:event_tfPhoneNumberActionPerformed

    private void tfEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmailFocusGained
        tfEmail.setText("");
    }//GEN-LAST:event_tfEmailFocusGained

    private void tfEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmailFocusLost
        if (tfEmail.getText().equalsIgnoreCase("")) {

            tfEmail.setText(SystemFunctions.getCompany().getCompanyEmail());
        }
    }//GEN-LAST:event_tfEmailFocusLost

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        tfEmail.setText("");
    }//GEN-LAST:event_tfEmailActionPerformed

    private void tfTaxNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTaxNumberFocusGained
        tfTaxNumber.setText("");
    }//GEN-LAST:event_tfTaxNumberFocusGained

    private void tfTaxNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTaxNumberFocusLost
        if (tfTaxNumber.getText().equalsIgnoreCase("")) {

            tfTaxNumber.setText(SystemFunctions.getCompany().getCompanyTaxNumber().toString());
        }
    }//GEN-LAST:event_tfTaxNumberFocusLost

    private void tfTaxNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTaxNumberActionPerformed
        tfTaxNumber.setText("");
    }//GEN-LAST:event_tfTaxNumberActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        Company newCompany = new Company(tfCompanyName.getText(), tfOwner.getText(), tfPhoneNumber.getText(), tfEmail.getText(), Long.parseLong(tfTaxNumber.getText()));
        
        newCompany.setBalance(SystemFunctions.getCompany().getBalance());
        newCompany.setDebt(SystemFunctions.getCompany().getDebt());
        newCompany.setClaim(SystemFunctions.getCompany().getClaim());

        SystemFunctions.setCompany(newCompany);
        SystemFunctions.saveCompanyToDatabase();
        SystemFunctions.changeToFrame(new MainFrame(), this);
    }//GEN-LAST:event_btnChangeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        SystemFunctions.changeToFrame(new AdminSettingsFrame(), this);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SettingsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SettingsFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField tfCompanyName;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfOwner;
    private javax.swing.JTextField tfPhoneNumber;
    private javax.swing.JTextField tfTaxNumber;
    // End of variables declaration//GEN-END:variables

}
package Main.Swings;

import Calculation.AutoSetIcon;
import Calculation.CloseController;
import Calculation.GUIDimension;
import Events.LoginButton;
import Events.PasswordButton;
import Events.SignupButton;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Sijan Bhandari
 */
public final class Login extends JFrame {

    LoginButton login = new LoginButton();

    public Login() {

        initComponents();
        toEdge();
        setIcon();
        setCloseIcon();
        pass.setOpaque(false);
        user.setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        startBar();

    }

    void startBar() {
        CloseController.changePosition(this.getBounds());
        MessageDialog.fram = this;
    }

    void setCloseIcon() {
        //new AutoSetIcon(closelabel, "/resources/close.png");
    }

    void setIcon() {
        new AutoSetIcon(label, "/resources/user.png");
    }

    void toEdge() {
        new GUIDimension(this, "login");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp1 = new com.raven.swing.RoundPanel();
        user = new RSMaterialComponent.RSTextFieldMaterial();
        pass = new RSMaterialComponent.RSPasswordMaterial();
        lgbtn = new custom.LoginButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HamroShare");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setType(java.awt.Window.Type.UTILITY);

        jp1.setBackground(new java.awt.Color(51, 51, 51));

        user.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        user.setColorMaterial(new java.awt.Color(0, 0, 204));
        user.setOpaque(false);
        user.setPlaceholder("  Username");
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        pass.setColorMaterial(new java.awt.Color(0, 0, 204));
        pass.setOpaque(false);
        pass.setPlaceholder("  Password");
        pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passFocusLost(evt);
            }
        });

        lgbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lgbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lgbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(lgbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lgbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgbtnMouseClicked
        new LoginButton().clicked(this);

    }//GEN-LAST:event_lgbtnMouseClicked

    private void passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFocusGained
        new PasswordButton(label, "clicked", "userpass.png");
    }//GEN-LAST:event_passFocusGained

    private void passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFocusLost
        new PasswordButton(label, "notclicked", "user.png");
    }//GEN-LAST:event_passFocusLost

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    public static void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.raven.swing.RoundPanel jp1;
    public javax.swing.JLabel label;
    private custom.LoginButton lgbtn;
    public RSMaterialComponent.RSPasswordMaterial pass;
    public RSMaterialComponent.RSTextFieldMaterial user;
    // End of variables declaration//GEN-END:variables
}

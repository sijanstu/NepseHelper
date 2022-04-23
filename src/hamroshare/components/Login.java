package hamroshare.components;

import hamroshare.Calculation.AutoSetIcon;
import hamroshare.Calculation.CloseController;
import hamroshare.Calculation.GUIDimension;
import hamroshare.Calculation.LastBounds;
import hamroshare.Events.Info;
import hamroshare.Events.LoginButton;
import hamroshare.customswings.PasswordButton;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sijan Bhandari
 */
public final class Login extends JFrame {

    LoginButton login = new LoginButton();
    private Point currentLocation;

    public Login() {

        initComponents();

        toEdge();
        setIcon();
        setCloseIcon();
        usern.setBackground(new Color(0, 0, 0, 0));
        usern.setForeground(Color.white);
        usern.setPhColor(Color.white);
        usern.setCaretColor(Color.white);
        passn.setBackground(new Color(0, 0, 0, 0));
        passn.setForeground(Color.white);
        passn.setPhColor(Color.white);
        passn.setCaretColor(Color.white);
        setBackground(new Color(0, 0, 0, 0));

        setDraggable(jp1, this.getBounds());
        setBounds(LastBounds.getBounds(this));
        startBar();
    }
    JFrame jf = this;

    public void setDraggable(JPanel panel, Rectangle bounds) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentLocation = e.getPoint();
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point currentScreenLocation = e.getLocationOnScreen();
                setLocation(currentScreenLocation.x - currentLocation.x, currentScreenLocation.y - currentLocation.y);
                CloseController.changePosition(jf);

                // System.out.println("dragged");
            }
        });
    }

    void startBar() {
        CloseController.changePosition(this);
        MessageDialog.fram = this;
    }

    void setCloseIcon() {
        //new AutoSetIcon(closelabel, "/resources/close.png");
    }

    void setIcon() {
        AutoSetIcon autoSetIcon = new AutoSetIcon(label, "/icon/user.png");
    }

    void toEdge() {
        GUIDimension guiDimension = new GUIDimension(this, "login");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp1 = new hamroshare.customswings.RoundPanel();
        usern = new RSMaterialComponent.RSTextFieldMaterial();
        passn = new RSMaterialComponent.RSPasswordMaterial();
        lgbtn = new hamroshare.customswings.LoginButton();
        label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HamroShare");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setType(java.awt.Window.Type.UTILITY);

        jp1.setBackground(new java.awt.Color(51, 51, 51));
        jp1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 1, true));
        jp1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usern.setBackground(new java.awt.Color(51, 51, 51));
        usern.setForeground(new java.awt.Color(255, 255, 255));
        usern.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        usern.setColorMaterial(new java.awt.Color(0, 153, 153));
        usern.setOpaque(false);
        usern.setPhColor(new java.awt.Color(255, 255, 255));
        usern.setPlaceholder("  Username");
        usern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernActionPerformed(evt);
            }
        });
        jp1.add(usern, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 132, 170, 40));

        passn.setBackground(new java.awt.Color(51, 51, 51));
        passn.setForeground(new java.awt.Color(255, 255, 255));
        passn.setColorMaterial(new java.awt.Color(0, 153, 153));
        passn.setOpaque(false);
        passn.setPhColor(new java.awt.Color(255, 255, 255));
        passn.setPlaceholder("  Password");
        passn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passnFocusLost(evt);
            }
        });
        passn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passnActionPerformed(evt);
            }
        });
        jp1.add(passn, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 182, 170, -1));

        lgbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lgbtnMouseClicked(evt);
            }
        });
        jp1.add(lgbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 230, 170, 42));
        jp1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 120));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("or SignUp Now");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jp1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 284, 164, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lgbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgbtnMouseClicked
        try {
            new LoginButton().clicked(this);
        } catch (IOException ex) {
            Info.display(jp1, "Application Error", 0, 2000);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Info.display(jp1, "Application Error", 0, 2000);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lgbtnMouseClicked

    private void passnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passnFocusGained
        PasswordButton passwordButton = new PasswordButton(label, "clicked", "/icon/userpass.png");
    }//GEN-LAST:event_passnFocusGained

    private void passnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passnFocusLost
        PasswordButton passwordButton = new PasswordButton(label, "notclicked", "/icon/user.png");
    }//GEN-LAST:event_passnFocusLost

    private void usernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://adminhamroapi.herokuapp.com/register.php"));
        } catch (IOException e1) {
            Info.display(jp1, "signup from browser", 0, 500);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void passnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passnActionPerformed
        try {
            new LoginButton().clicked(this);
        } catch (IOException ex) {
            Info.display(jp1, "Application Error", 0, 2000);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_passnActionPerformed
    Process p;

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
    private javax.swing.JLabel jLabel2;
    public hamroshare.customswings.RoundPanel jp1;
    public javax.swing.JLabel label;
    private hamroshare.customswings.LoginButton lgbtn;
    public RSMaterialComponent.RSPasswordMaterial passn;
    public RSMaterialComponent.RSTextFieldMaterial usern;
    // End of variables declaration//GEN-END:variables
}

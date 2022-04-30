package hamroshare.ui;

import com.google.api.client.util.Base64;
import config.RegisteredUser;
import hamroshare.Events.UserRegistration;
import hamroshare.calculations.AutoSetIcon;
import hamroshare.calculations.CloseController;
import hamroshare.calculations.GUIDimension;
import hamroshare.calculations.MinimizeController;
import hamroshare.dtos.UserModel;
import hamroshare.eventhandlers.Info;
import hamroshare.uicomponents.LoginButton;
import hamroshare.uicomponents.PasswordButton;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.JSONException;

/**
 *
 * @author Sijan Bhandari
 */
public final class Login extends JFrame {

    LoginButton login = new LoginButton();
    private Point currentLocation;
    private boolean isRegistering = false;
    String imagePath = "src/icon/user.png";

    public Login() {
        initComponents();

        initLogin();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp1 = new hamroshare.uicomponents.RoundPanel();
        usern = new RSMaterialComponent.RSTextFieldMaterial();
        passn = new RSMaterialComponent.RSPasswordMaterial();
        lgbtn = new hamroshare.uicomponents.LoginButton();
        label = new javax.swing.JLabel();
        slSwitchLabel = new javax.swing.JLabel();
        emailID = new RSMaterialComponent.RSTextFieldMaterial();
        fullName = new RSMaterialComponent.RSTextFieldMaterial();
        simage = new rojeru_san.rsbutton.RSButtonRound();
        simageavater = new hamroshare.uicomponents.ImageAvatar();
        close = new javax.swing.JLabel();
        close1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HamroShare");
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp1.setBackground(new java.awt.Color(51, 51, 51));
        jp1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 1, true));
        jp1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usern.setBackground(new java.awt.Color(51, 51, 51));
        usern.setForeground(new java.awt.Color(255, 255, 255));
        usern.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        usern.setColorMaterial(new java.awt.Color(0, 153, 153));
        usern.setOpaque(false);
        usern.setPhColor(new java.awt.Color(255, 255, 255));
        usern.setPlaceholder("Username");
        usern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernActionPerformed(evt);
            }
        });
        jp1.add(usern, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 170, 40));

        passn.setBackground(new java.awt.Color(51, 51, 51));
        passn.setForeground(new java.awt.Color(255, 255, 255));
        passn.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        passn.setColorMaterial(new java.awt.Color(0, 153, 153));
        passn.setOpaque(false);
        passn.setPhColor(new java.awt.Color(255, 255, 255));
        passn.setPlaceholder("Password");
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
        jp1.add(passn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 182, 170, -1));

        lgbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lgbtnMouseClicked(evt);
            }
        });
        jp1.add(lgbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 230, 170, 42));
        jp1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 150, 120));

        slSwitchLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        slSwitchLabel.setForeground(new java.awt.Color(0, 204, 204));
        slSwitchLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        slSwitchLabel.setText("or SignUp Now");
        slSwitchLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slSwitchLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slSwitchLabelMouseClicked(evt);
            }
        });
        jp1.add(slSwitchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 284, 164, -1));

        emailID.setBackground(new java.awt.Color(51, 51, 51));
        emailID.setForeground(new java.awt.Color(255, 255, 255));
        emailID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        emailID.setColorMaterial(new java.awt.Color(0, 153, 153));
        emailID.setOpaque(false);
        emailID.setPhColor(new java.awt.Color(255, 255, 255));
        emailID.setPlaceholder("Email Address");
        emailID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailIDActionPerformed(evt);
            }
        });
        jp1.add(emailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 170, 40));

        fullName.setBackground(new java.awt.Color(51, 51, 51));
        fullName.setForeground(new java.awt.Color(255, 255, 255));
        fullName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fullName.setColorMaterial(new java.awt.Color(0, 153, 153));
        fullName.setOpaque(false);
        fullName.setPhColor(new java.awt.Color(255, 255, 255));
        fullName.setPlaceholder("Full Name");
        fullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNameActionPerformed(evt);
            }
        });
        jp1.add(fullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, 40));

        simage.setText("Select Image");
        simage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simageActionPerformed(evt);
            }
        });
        jp1.add(simage, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 120, 30));

        simageavater.setForeground(new java.awt.Color(231, 231, 231));
        simageavater.setBorderSize(2);
        simageavater.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        jp1.add(simageavater, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 60, 50));

        getContentPane().add(jp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 185, 316));

        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 20));

        close1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close1MouseExited(evt);
            }
        });
        getContentPane().add(close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 20, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents
public byte[] extractBytes(String ImageName) throws IOException {
        Path path = Paths.get(ImageName);
        byte[] data = Files.readAllBytes(path);
        return data;
    }
    private void lgbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgbtnMouseClicked
        startLoginCotroller();
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

    private void slSwitchLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slSwitchLabelMouseClicked
        isRegistering(!isRegistering);
    }//GEN-LAST:event_slSwitchLabelMouseClicked

    private void passnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passnActionPerformed
        startLoginCotroller();

    }//GEN-LAST:event_passnActionPerformed

    private void emailIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailIDActionPerformed

    private void fullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullNameActionPerformed

    private void simageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simageActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int res = file.showSaveDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File selFile = file.getSelectedFile();
            String path = selFile.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(path);
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(simageavater.getHeight(), simageavater.getWidth(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon newImageIcon = new ImageIcon(newimg);
            simageavater.setIcon(newImageIcon);
            imagePath=path;
        }

    }//GEN-LAST:event_simageActionPerformed

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
        MinimizeController.clicked(this);
    }//GEN-LAST:event_close1MouseClicked

    private void close1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseEntered
        MinimizeController.hovered(close1);
    }//GEN-LAST:event_close1MouseEntered

    private void close1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseExited
        MinimizeController.exitHover(close1);
    }//GEN-LAST:event_close1MouseExited

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        CloseController.clicked(this.getBounds());
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        CloseController.hovered(close);
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        CloseController.exitHover(close);
    }//GEN-LAST:event_closeMouseExited
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
    public javax.swing.JLabel close;
    public javax.swing.JLabel close1;
    public RSMaterialComponent.RSTextFieldMaterial emailID;
    public RSMaterialComponent.RSTextFieldMaterial fullName;
    public hamroshare.uicomponents.RoundPanel jp1;
    public javax.swing.JLabel label;
    private hamroshare.uicomponents.LoginButton lgbtn;
    public RSMaterialComponent.RSPasswordMaterial passn;
    private rojeru_san.rsbutton.RSButtonRound simage;
    public hamroshare.uicomponents.ImageAvatar simageavater;
    private javax.swing.JLabel slSwitchLabel;
    public RSMaterialComponent.RSTextFieldMaterial usern;
    // End of variables declaration//GEN-END:variables
   void startLoginCotroller() {
        UserModel userModel = new UserModel();
        userModel.setEmailID(emailID.getText());
        userModel.setName(fullName.getText());
        userModel.setUsername(usern.getText());
        userModel.setPassword(passn.getText());
        userModel.setImageUrl(userModel.getUsername() + ".txt");
        try {
            userModel.setImage(Base64.encodeBase64String(extractBytes(imagePath)));
        } catch (IOException ex) {
            userModel.setImage(null);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (isRegistering) {
            if (userModel.getName().equals("")
                    || userModel.getEmailID().equals("")
                    || userModel.getUsername().equals("")
                    || userModel.getPassword().equals("")) {
                Info.display(jp1, "Enter Required data", 0, 2000);
            } else {
                UserRegistration.register(this, userModel);
            }
        } else {
            if (userModel.getUsername().equals("")
                    || userModel.getPassword().equals("")) {
                Info.display(jp1, "Enter Required data", 0, 2000);
            } else {
                //new hamroshare.Events.LoginButton().clicked(this);
                RegisteredUser reguser = new RegisteredUser();
                reguser.setUsername(usern.getText());
                reguser.setPassword(passn.getText());
                try {
                    RegisteredUser reguser1 = reguser.authUser();
                    if (reguser1.getUid() != null) {
                        RegisteredUser.registeredUser = reguser1;
                        Info.display(jp1, "Success", 0, 2000);
                        Dash.main();
                        dispose();
                    } else {
                        Info.display(jp1, "Not Found", 0, 2000);
                        System.out.println("Not found");
                    }

                } catch (JSONException ex) {
                    System.out.println("jsonException line 32");
                } catch (Throwable ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    void initLogin() {
        MessageDialog.fram = this;
        new AutoSetIcon().set(close, "/icon/close.png");
        new AutoSetIcon().set(close1, "/icon/minimize.png");
        isRegistering(false);
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
        startBar();
    }

    void isRegistering(Boolean bool) {
        emailID.setVisible(bool);
        fullName.setVisible(bool);
        label.setVisible(!bool);
        simage.setVisible(bool);
        simageavater.setVisible(bool);
        isRegistering = bool;
        if (bool) {
            slSwitchLabel.setText("or Login Now");
            lgbtn.value = 1;
            lgbtn.repaint();
            fullName.requestFocus(true);
        } else {
            slSwitchLabel.setText("or SignUp Now");
            lgbtn.value = 0;
            lgbtn.repaint();
        }
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
                setLocation(currentScreenLocation.x - currentLocation.x, currentScreenLocation.y - currentLocation.y - close.getHeight());
                // System.out.println("dragged");
            }
        });
    }

    void startBar() {
        MessageDialog.fram = this;
    }

    void setCloseIcon() {
        //new AutoSetIcon(closelabel, "/resources/close.png");
    }

    void setIcon() {
        new AutoSetIcon().set(label, "/icon/user.png");
    }

    void toEdge() {
        GUIDimension guiDimension = new GUIDimension(this, "login");
    }

    void RegisterUser() {
        //User user=new User();

    }

}

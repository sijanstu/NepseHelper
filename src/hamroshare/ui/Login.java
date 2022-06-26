package hamroshare.ui;

import com.formdev.flatlaf.FlatLaf;
import com.google.api.client.util.Base64;
import com.google.gson.Gson;
import hamroshare.calculations.AutoSetIcon;
import hamroshare.calculations.CloseController;
import hamroshare.calculations.GUIDimension;
import hamroshare.calculations.MinimizeController;
import hamroshare.dataalgorithms.MD5;
import hamroshare.dtos.UserDto;
import hamroshare.dtos.UserLoginDto;
import hamroshare.eventhandlers.Info;
import hamroshare.login.LoginController;
import hamroshare.uicomponents.LoginButton;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Rectangle rect = new Rectangle(3, 7, 55, 55);

        initLogin();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp1 = new hamroshare.uicomponents.RoundPanel();
        usern = new RSMaterialComponent.RSTextFieldMaterial();
        passn = new RSMaterialComponent.RSPasswordMaterial();
        lgbtn = new hamroshare.uicomponents.LoginButton();
        slSwitchLabel = new javax.swing.JLabel();
        emailID = new RSMaterialComponent.RSTextFieldMaterial();
        fullName = new RSMaterialComponent.RSTextFieldMaterial();
        simage = new rojeru_san.rsbutton.RSButtonRound();
        avatar2 = new hamroshare.ui.Avatar();
        close = new javax.swing.JLabel();
        close1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HamroShare");
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp1.setBackground(new java.awt.Color(51, 51, 51));
        jp1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 1, true));
        jp1.setLayout(null);

        usern.setBackground(new java.awt.Color(51, 51, 51));
        usern.setForeground(new java.awt.Color(255, 255, 255));
        usern.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        usern.setToolTipText("");
        usern.setColorMaterial(new java.awt.Color(0, 153, 153));
        usern.setOpaque(false);
        usern.setPhColor(new java.awt.Color(255, 255, 255));
        usern.setPlaceholder("Username");
        usern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernActionPerformed(evt);
            }
        });
        jp1.add(usern);
        usern.setBounds(10, 140, 170, 40);

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
        jp1.add(passn);
        passn.setBounds(10, 182, 170, 42);

        lgbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lgbtnMouseClicked(evt);
            }
        });
        jp1.add(lgbtn);
        lgbtn.setBounds(7, 230, 170, 42);

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
        jp1.add(slSwitchLabel);
        slSwitchLabel.setBounds(13, 284, 164, 19);

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
        jp1.add(emailID);
        emailID.setBounds(10, 100, 170, 40);

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
        jp1.add(fullName);
        fullName.setBounds(10, 60, 170, 40);

        simage.setText("Select Image");
        simage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simageActionPerformed(evt);
            }
        });
        jp1.add(simage);
        simage.setBounds(60, 20, 120, 30);
        jp1.add(avatar2);
        avatar2.setBounds(30, 20, 120, 89);

        getContentPane().add(jp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 185, 310));

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
        //PasswordButton passwordButton = new PasswordButton(label, "clicked", "/icon/userpass.png");
    }//GEN-LAST:event_passnFocusGained

    private void passnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passnFocusLost
        //  PasswordButton passwordButton = new PasswordButton(label, "notclicked", "/icon/user.png");
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
            imagePath = path;
            try {
                ResizeImage.resize(imagePath, "user.png");
                imagePath = "user.png";
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageIcon imageIcon = new ImageIcon("user.png");
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(avatar2.getHeight(), avatar2.getWidth(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon newImageIcon = new ImageIcon(newimg);
            Avatar.imageAvatar2.setIcon(newImageIcon);
            FlatLaf.updateUI();
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
    private hamroshare.ui.Avatar avatar2;
    public javax.swing.JLabel close;
    public javax.swing.JLabel close1;
    public RSMaterialComponent.RSTextFieldMaterial emailID;
    public RSMaterialComponent.RSTextFieldMaterial fullName;
    public hamroshare.uicomponents.RoundPanel jp1;
    private hamroshare.uicomponents.LoginButton lgbtn;
    public RSMaterialComponent.RSPasswordMaterial passn;
    private rojeru_san.rsbutton.RSButtonRound simage;
    private javax.swing.JLabel slSwitchLabel;
    public RSMaterialComponent.RSTextFieldMaterial usern;
    // End of variables declaration//GEN-END:variables
   void startLoginCotroller() {
        try {
            UserDto userModel = new UserDto();
            userModel.setEmailID(emailID.getText());
            userModel.setFullName(fullName.getText());
            userModel.setUsername(usern.getText());
            userModel.setPassword(MD5.generate(passn.getText()));
            userModel.setImage(Base64.encodeBase64URLSafeString(Files.readAllBytes(Paths.get(imagePath))));
            if (isRegistering) {
                if (userModel.getFullName().equals("")
                        || userModel.getEmailID().equals("")
                        || userModel.getUsername().equals("")
                        || userModel.getPassword().equals("")) {
                    Info.display(jp1, "Enter Required data", 0, 2000);
                } else {
                    UserDto userDto = LoginController.register(userModel);
                    System.out.println(userDto);
                    if (userDto.getId() != null) {
                        Info.display(jp1, "Success", 0, 2000);
                        Dash.main();
                        Avatar.imageAvatar2.setIcon(LoginController.userIcon);
                        dispose();
                    }
                }
            } else {
                if (userModel.getUsername().equals("")
                        || userModel.getPassword().equals("")) {
                    Info.display(jp1, "Enter Required data", 0, 2000);
                } else {
                    UserLoginDto userLoginDto = new UserLoginDto();
                    userLoginDto.setUsername(String.valueOf(usern.getText()));
                    userLoginDto.setPassword(String.valueOf(MD5.generate(passn.getText())));
                    try {
                        UserDto userDto = LoginController.login(userLoginDto);
                        System.out.println(userDto);
                        if (userDto.getId() != null) {
                            Info.display(jp1, "Success", 0, 2000);
                            Dash.main();
                            Avatar.imageAvatar2.setIcon(LoginController.userIcon);
                            dispose();
                        } else {
                            Info.display(jp1, "Not Found", 0, 2000);
                            System.out.println("Not found");
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                        Info.display(jp1, "Try Again", 0, 2000);
                        //  Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
        // setBackground(new Color(0, 0, 0, 0));
        setDraggable(jp1, this.getBounds());
        startBar();
    }

    void isRegistering(Boolean bool) {
        emailID.setVisible(bool);
        fullName.setVisible(bool);
        simage.setVisible(bool);
        isRegistering = bool;
        if (bool) {
            Rectangle rect = new Rectangle(3, 7, 55, 55);
            avatar2.setBounds(rect);
            slSwitchLabel.setText("or Login Now");
            lgbtn.value = 1;
            lgbtn.repaint();
            fullName.requestFocus(true);

        } else {
            Rectangle rect = new Rectangle(30, 20, 120, 110);
            avatar2.setBounds(rect);
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
        // new AutoSetIcon().set(label, "/icon/user.png");
    }

    void toEdge() {
        GUIDimension guiDimension = new GUIDimension(this, "login");
    }

    void RegisterUser() {
        //User user=new User();

    }
}

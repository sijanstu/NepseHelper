package hamroshare.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.google.api.client.util.Base64;
import hamroshare.dtos.UserDto;
import hamroshare.eventhandlers.Info;
import hamroshare.login.LoginController;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Sijan
 */
public class Settings extends javax.swing.JPanel {

    /**
     * Creates new form Profile
     */
    public Settings() {
        initComponents();
        simageavater.setIcon(LoginController.userIcon);

        //simageavater.setIcon(RegisteredUser.getProfileIconResized(new Rectangle(140, 150)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new hamroshare.uicomponents.RoundPanel();
        simage = new rojeru_san.rsbutton.RSButtonRound();
        simageavater = new hamroshare.uicomponents.ImageAvatar();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        simage.setText("Change");
        simage.setFocusPainted(false);
        simage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simageActionPerformed(evt);
            }
        });
        roundPanel1.add(simage, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 80, 30));

        simageavater.setForeground(new java.awt.Color(231, 231, 231));
        simageavater.setBorderSize(2);
        simageavater.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        roundPanel1.add(simageavater, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 90));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Theme :");
        roundPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 150, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Settings                                        Hamro Share");
        roundPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 30));
        roundPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 100, 10));
        roundPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 300, 10));
        roundPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 100, 10));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sijan Bhandari");
        roundPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 300, 40));

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Dark Theme");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        roundPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 140, 40));

        add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 420));
    }// </editor-fold>//GEN-END:initComponents

    private void simageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simageActionPerformed
      new ImageChanger().start();
      
    }//GEN-LAST:event_simageActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        try {
            if (jRadioButton1.isSelected()) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        FlatLaf.updateUI();
    }//GEN-LAST:event_jRadioButton1ActionPerformed
    String imagePath;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private hamroshare.uicomponents.RoundPanel roundPanel1;
    private rojeru_san.rsbutton.RSButtonRound simage;
    public static hamroshare.uicomponents.ImageAvatar simageavater;
    // End of variables declaration//GEN-END:variables
class ImageChanger extends Thread{
    @Override
    public void run(){
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
            imagePath = path;
            UserDto user = LoginController.userDto;
            try {
                Info.display(roundPanel1, "uploading", 1, 1000);
                user.setImage(Base64.encodeBase64URLSafeString(Files.readAllBytes(Paths.get(imagePath))));
                UserDto newUser = LoginController.register(user);
                LoginController.userDto.setImageUrl(newUser.getImageUrl());
                LoginController.storeObject(LoginController.userDto);
                LoginController.setImageIcon(newUser);
                URL url = new URL(newUser.getImageUrl());
                Image image1 = ImageIO.read(url);
                Dash.dashAvatar.setIcon(new ImageIcon(image1));
                LoginController.signOutUser();
                Info.display(roundPanel1, "Restart for changes", 1, 2000);
                // LoginController.signOutUser();

            } catch (IOException ex) {
                Info.display(roundPanel1, "Task Failed, IO error", 0, 2000);
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Info.display(roundPanel1, "Task Failed, something wrong", 0, 2000);
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
}

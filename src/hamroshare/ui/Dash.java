package hamroshare.ui;

import hamroapi.StockPrices;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import hamroshare.dataalgorithms.DashBoardAlgo;
import hamroshare.dataalgorithms.LiveDataAlgo;
import hamroshare.calculations.AutoSetIcon;
import hamroshare.calculations.CloseController;
import hamroshare.calculations.GUIDimension;
import hamroshare.calculations.MinimizeController;
import hamroshare.eventhandlers.EventMenu;
import hamroshare.login.LoginController;
import static hamroshare.ui.Notes.imageAvatar1;
import static hamroshare.ui.Profile.simageavater;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Sijan Bhandari
 */
public final class Dash extends javax.swing.JFrame {

    public static Dash dash;

    /**
     * Creates new form Dash
     */
    public Dash() {
        initComponents();
        dash = this;
        new StartDash().start();
    }

    static void signOut() {
        //dispose();
        LoginController.signOutUser();
        Login.main();
    }

    void changeMenu(int index) {

        switch (index) {
            case 0 -> {
                dash0.setVisible(true);
                dash1.setVisible(false);
                dash2.setVisible(false);
                dash3.setVisible(false);
                dash7.setVisible(false);
                notes.setVisible(false);
            }
            case 1 -> {
                dash0.setVisible(false);
                dash1.setVisible(true);
                dash2.setVisible(false);
                dash3.setVisible(false);
                dash7.setVisible(false);
                notes.setVisible(false);
            }
            case 2 -> {
                dash0.setVisible(false);
                dash1.setVisible(false);
                dash2.setVisible(true);
                dash3.setVisible(false);
                dash7.setVisible(false);
                notes.setVisible(false);
            }
            case 3 -> {
                dash0.setVisible(false);
                dash1.setVisible(false);
                dash2.setVisible(false);
                dash3.setVisible(true);
                notes.setVisible(false);
                dash7.setVisible(false);
            }
            case 4 -> {
                dash0.setVisible(false);
                dash1.setVisible(false);
                dash2.setVisible(false);
                dash3.setVisible(false);
                dash7.setVisible(false);
                notes.setVisible(true);
            }
            case 7 -> {
                dash0.setVisible(false);
                dash1.setVisible(false);
                dash2.setVisible(false);
                dash3.setVisible(false);
                notes.setVisible(false);
                dash7.setVisible(true);
            }
            default ->
                throw new AssertionError();
        }
    }

    void passmesdialogue() {
        GUIDimension guiDimension = new GUIDimension(this, "login");
        //setBounds(LastBounds.getBounds(this));
        MessageDialog.fram = this;
    }
    private Point currentLocation;
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
                //CloseController.changePosition(jf);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashAvatar = new hamroshare.uicomponents.ImageAvatar();
        dash2 = new hamroshare.ui.Profile();
        dash3 = new hamroshare.ui.Technical();
        notes = new hamroshare.ui.Notes();
        dash7 = new hamroshare.ui.Settings();
        menud = new hamroshare.ui.Menu();
        dash0 = new hamroshare.ui.Home();
        dash1 = new hamroshare.ui.LiveTable();
        close = new javax.swing.JLabel();
        close1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.jpg"))); // NOI18N
        getContentPane().add(dashAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, 50));
        getContentPane().add(dash2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, -1));
        getContentPane().add(dash3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));
        getContentPane().add(notes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));
        getContentPane().add(dash7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));
        getContentPane().add(menud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, 430));
        getContentPane().add(dash0, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, 420));

        dash1.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                dash1VetoableChange(evt);
            }
        });
        getContentPane().add(dash1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, 430));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        //CloseController.bar.setVisible(false);
    }//GEN-LAST:event_formWindowIconified

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // CloseController.bar.setVisible(true);
    }//GEN-LAST:event_formWindowOpened

    private void dash1VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_dash1VetoableChange
    }//GEN-LAST:event_dash1VetoableChange

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
       new CloseUI().start();
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        CloseController.hovered(close);
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        CloseController.exitHover(close);
    }//GEN-LAST:event_closeMouseExited

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
        MinimizeController.clicked(this);
    }//GEN-LAST:event_close1MouseClicked

    private void close1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseEntered
        MinimizeController.hovered(close1);
    }//GEN-LAST:event_close1MouseEntered

    private void close1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseExited
        MinimizeController.exitHover(close1);
    }//GEN-LAST:event_close1MouseExited
    void switchToWindowsTheme() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dash.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void main() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                    FlatLaf.updateUI();

                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Profile.class
                            .getName()).log(Level.SEVERE, null, ex);

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dash.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Dash().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel close;
    public javax.swing.JLabel close1;
    private hamroshare.ui.Home dash0;
    private hamroshare.ui.LiveTable dash1;
    private hamroshare.ui.Profile dash2;
    private hamroshare.ui.Technical dash3;
    private hamroshare.ui.Settings dash7;
    public static hamroshare.uicomponents.ImageAvatar dashAvatar;
    private hamroshare.ui.Menu menud;
    private hamroshare.ui.Notes notes;
    // End of variables declaration//GEN-END:variables
class StartDash extends Thread {

        @Override
        public void run() {

            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
            FlatLaf.updateUI();
            simageavater.setIcon(LoginController.userIcon);
            dashAvatar.setIcon(LoginController.userIcon);
            // System.out.println(Byte.valueOf(RegisteredUser.getProfileIcon().getImage().toString()));
            Avatar.imageAvatar2.setIcon(LoginController.userIcon);
            //Notes.jLabel2.setIcon(RegisteredUser.getProfileIconResized(jLabel2.getBounds()));
            //add(Menu.avatar2);
            //FlatLaf.updateUI();
            // jLabel1.setIcon(RegisteredUser.getProfileIconResized(jLabel1.getBounds()));
            //avatar1.repaint();
            Menu.user2.setText(LoginController.userDto.getFullName());
            StockPrices.fetchCompaniesInJComboBox(Technical.companyComboBox1);
            LiveDataAlgo.init();
            DashBoardAlgo.init();
            new AutoSetIcon().set(close, "/icon/close.png");
            new AutoSetIcon().set(close1, "/icon/minimize.png");
            //changeMenu(1);
            changeMenu(0);
            setDraggable(menud, dash.getBounds());
            EventMenu event;
            event = new EventMenu() {
                @Override
                public void selected(int index) {
                    switch (index) {
                        case 0: {
                            changeMenu(0);
                            break;
                        }
                        case 1: {
                            changeMenu(1);
                            break;
                        }
                        case 2: {
                            changeMenu(2);
                            break;
                        }
                        case 3: {
                            changeMenu(3);
                            break;
                        }
                        case 4: {
                            changeMenu(4);
                            break;
                        }
                        case 7: {
                            changeMenu(7);
                            break;
                        }
                        case 8: {
                            dispose();
                            LoginController.signOutUser();
                            Login.main();
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }
            };
            dash.setBackground(new Color(0, 0, 0, 0));
            menud.setBackground(new Color(5, 5, 5, 5));
            //jp3.setOpaque(false);
            //jp3.setBackground (
            //new Color(0, 0, 0, 0));
            passmesdialogue();
            menud.initMenu(event);
        }
    }

    class CloseUI extends Thread {

        @Override
        public void run() {
            switchToWindowsTheme();
            CloseController.clicked(Dash.dash.getBounds());
        }
    }
}

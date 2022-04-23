package hamroshare.components;

import Algorithms.DashBoard;
import Algorithms.RefreshLiveData;
import hamroshare.Calculation.CloseController;
import hamroshare.Calculation.GUIDimension;
import hamroshare.Calculation.LastBounds;
import hamroshare.DataBase.LoginController;
import hamroshare.Events.Info;
import hamroshare.Events.EventMenu;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Sijan Bhandari
 */
public final class Dash extends javax.swing.JFrame {

    /**
     * Creates new form Dash
     */
    public static String username;

    public Dash() {
        File file = new File("user.txt");
        if (!file.exists()) {
            try {
                try ( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                    bufferedWriter.write(LoginController.user.getID() + "\n" + LoginController.user.getUsername());
                }
            } catch (IOException ex) {
                Logger.getLogger(Dash.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        initComponents();
        changeMenu(1);
        changeMenu(0);
        setDraggable(menu, this.getBounds());
        Info.display(menu, "Login Success", 1, 500);
        EventMenu event;
        event = (int index) -> {
            switch (index) {
                case 0 -> {
                    changeMenu(0);
                }
                case 1 -> {
                    changeMenu(1);
                }
                case 8 -> {
                    dispose();
                    LastBounds.storedBound = this.getBounds();
                    Login.main();
                }
                default -> {

                }
            }
        };

        this.setBackground(new Color(0, 0, 0, 0));
        menu.setBackground(new Color(5, 5, 5, 5));
        //jp3.setOpaque(false);
        //jp3.setBackground (

        //new Color(0, 0, 0, 0));
        passmesdialogue();

        menu.user2.setText(LoginController.user.getUsername());
        startBar();

        menu.initMenu(event);

    }

    void changeMenu(int index) {
        switch (index) {
            case 0 -> {
                Home.gauch.setValueWithAnimation(0);
                DashBoard.gaugeChart = Home.gauch;
                new DashBoard().start();
                dash1.setVisible(false);
                dash0.setVisible(true);
            }
            case 1 -> {
                JTable table = LiveTable.tbl;
                RefreshLiveData.tbl = table;
                new RefreshLiveData().start();
                dash0.setVisible(false);
                dash1.setVisible(true);
            }
            default ->
                throw new AssertionError();
        }
    }

    void startBar() {
        CloseController.changePosition(this);
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
                setLocation(currentScreenLocation.x - currentLocation.x, currentScreenLocation.y - currentLocation.y);
                CloseController.changePosition(jf);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new hamroshare.components.Menu();
        dash1 = new hamroshare.components.LiveTable();
        dash0 = new hamroshare.components.Home();

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
        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 8, 170, 420));

        dash1.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                dash1VetoableChange(evt);
            }
        });
        getContentPane().add(dash1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));
        getContentPane().add(dash0, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        CloseController.bar.setVisible(false);
    }//GEN-LAST:event_formWindowIconified

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CloseController.bar.setVisible(true);
    }//GEN-LAST:event_formWindowOpened

    private void dash1VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_dash1VetoableChange
    }//GEN-LAST:event_dash1VetoableChange

    public static void main() {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Dash().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hamroshare.components.Home dash0;
    private hamroshare.components.LiveTable dash1;
    private hamroshare.components.Menu menu;
    // End of variables declaration//GEN-END:variables
}

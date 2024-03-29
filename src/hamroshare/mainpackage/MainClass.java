package hamroshare.mainpackage;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import hamroshare.calculations.CloseController;
import hamroshare.databases.CheckConnection;
import hamroshare.calculations.GUIDimension;
import hamroshare.eventhandlers.JFrameCloser;
import hamroshare.ui.MessageDialog;
import hamroshare.ui.Settings;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Sijan Bhandari
 */
public final class MainClass extends javax.swing.JFrame {

    /**
     * Creates new form Start
     */
    public MainClass() {
//        File file = new File("user.txt");
//        if (false) {
//            try {
//                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//                LoginController.user = new User(bufferedReader.readLine(), bufferedReader.readLine());
//                LastBounds.storedBound = lg.getBounds();
//                Dash.main();
//                dispose();
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        GUIDimension guiDimension = new GUIDimension(this, "login");
        setIcon();
        startBar();
        MessageDialog.fram = this;
        try {

            startTimer();
            CheckConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void startTimer() {
        JFrameCloser.open(this, true);
    }

    void startBar() {
        CloseController.initBar();
    }

    void setIcon() {
        j1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loading.gif")).getImage().
                getScaledInstance(j1.getWidth(), j1.getHeight(), Image.SCALE_DEFAULT)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp2 = new hamroshare.uicomponents.RoundPanel();
        jLabel3 = new javax.swing.JLabel();
        j1 = new javax.swing.JLabel();
        j2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp2.setBackground(new java.awt.Color(51, 51, 51));
        jp2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HamroShare");

        j2.setBackground(new java.awt.Color(204, 153, 0));
        j2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        j2.setForeground(new java.awt.Color(255, 255, 255));
        j2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        j2.setText("Starting");

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jp2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jp2Layout.setVerticalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        getContentPane().add(jp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
     public static void main(String args[]) {
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } else {
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainClass().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel j1;
    public javax.swing.JLabel j2;
    private javax.swing.JLabel jLabel3;
    public hamroshare.uicomponents.RoundPanel jp2;
    // End of variables declaration//GEN-END:variables
}

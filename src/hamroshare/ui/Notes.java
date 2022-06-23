/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hamroshare.ui;

import config.RegisteredUser;

/**
 *
 * @author Sijan
 */
public class Notes extends javax.swing.JPanel {

    /**
     * Creates new form Profile
     */
    public Notes() {
        initComponents();
        
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
        imageAvatar1 = new hamroshare.uicomponents.ImageAvatar();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        roundPanel1.add(imageAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Notes                                        Hamro Share");
        roundPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 30));
        roundPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 130, 10));
        roundPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 300, 10));
        roundPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 130, 10));

        add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 420));
    }// </editor-fold>//GEN-END:initComponents
    String imagePath;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static hamroshare.uicomponents.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private hamroshare.uicomponents.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}

package hamroshare.ui;

import hamroshare.login.LoginController;

/**
 *
 * @author Sijan
 */
public class Notes extends javax.swing.JPanel {

    /**
     * Creates new form Profile
     */
    public static Notes noteInstance;
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

        rSButtonCustom1 = new rojeru_san.rsbutton.RSButtonCustom();
        createNote = new hamroshare.ui.notes.CreateNote();
        notePanel = new hamroshare.ui.notes.ViewNote();
        noteList = new hamroshare.ui.notes.NoteList();
        rSButtonIconUno2 = new RSMaterialComponent.RSButtonIconUno();
        rSButtonIconUno1 = new RSMaterialComponent.RSButtonIconUno();
        roundPanel1 = new hamroshare.uicomponents.RoundPanel();
        imageAvatar1 = new hamroshare.uicomponents.ImageAvatar();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        rSButtonCustom1.setText("rSButtonCustom1");

        setOpaque(false);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(createNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        add(notePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 290, 360));
        add(noteList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 330, 310));

        rSButtonIconUno2.setBackground(new java.awt.Color(51, 51, 51));
        rSButtonIconUno2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_BOX);
        rSButtonIconUno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconUno2ActionPerformed(evt);
            }
        });
        add(rSButtonIconUno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 50, 40));

        rSButtonIconUno1.setBackground(new java.awt.Color(51, 51, 51));
        rSButtonIconUno1.setBackgroundHover(new java.awt.Color(51, 51, 51));
        rSButtonIconUno1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REFRESH);
        rSButtonIconUno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconUno1ActionPerformed(evt);
            }
        });
        add(rSButtonIconUno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 40, 40));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        roundPanel1.add(imageAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Notes                                Hamro Share");
        roundPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 30));
        roundPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 330, 10));
        roundPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 300, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Your Notes");
        roundPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 330, 40));

        add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 420));
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonIconUno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconUno2ActionPerformed
      createNote.setVisible(true);
      createNote.createNote();
    }//GEN-LAST:event_rSButtonIconUno2ActionPerformed

    private void rSButtonIconUno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconUno1ActionPerformed
        noteList.RefreshNotes();
    }//GEN-LAST:event_rSButtonIconUno1ActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
       createNote.setVisible(false);
        noteInstance=this;
        imageAvatar1.setIcon(LoginController.userIcon);
        notePanel.setVisible(false);
        noteList.setViewPanel(notePanel);
        noteList.RefreshNotes();
    }//GEN-LAST:event_formComponentAdded
    String imagePath;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hamroshare.ui.notes.CreateNote createNote;
    public static hamroshare.uicomponents.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public static hamroshare.ui.notes.NoteList noteList;
    private hamroshare.ui.notes.ViewNote notePanel;
    private rojeru_san.rsbutton.RSButtonCustom rSButtonCustom1;
    private RSMaterialComponent.RSButtonIconUno rSButtonIconUno1;
    private RSMaterialComponent.RSButtonIconUno rSButtonIconUno2;
    private hamroshare.uicomponents.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}

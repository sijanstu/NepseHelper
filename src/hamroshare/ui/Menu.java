package hamroshare.ui;

import hamroshare.eventhandlers.EventMenu;
import hamroshare.uicomponents.ButtonMenu;
import hamroshare.uicomponents.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {
ScrollBarCustom sb;
    private EventMenu event;
    public Menu() {
        initComponents();
        setOpaque(false);
        
        //user.setText(LoginController.user.getUsername());
        //sb = new ScrollBarCustom();
        //sp1.setVerticalScrollBar(sb);
        //sb.doLayout();
        pm1.setLayout(new MigLayout("wrap, fillx, inset 3", "[fill]", "[]0[]"));
        //sp1.setBackground(new Color(100,0,0,100));
       // rp1.setBackground(new Color(100,0,0,100));
        //pm1.setBackground(new Color(100,0,0,100));
    }

    public void initMenu(EventMenu event) {
        this.event = event;
        addMenu(new ImageIcon(getClass().getResource("/icon/1.png")), "Dashboard", 0);
        addMenu(new ImageIcon(getClass().getResource("/icon/2.png")), "Live Market", 1);
        addMenu(new ImageIcon(getClass().getResource("/icon/3.png")), "Profile", 2);
        addMenu(new ImageIcon(getClass().getResource("/icon/4.png")), "Analysis", 3);
        addMenu(new ImageIcon(getClass().getResource("/icon/5.png")), "Note", 4);
        addMenu(new ImageIcon(getClass().getResource("/icon/6.png")), "Export", 5);
        addMenu(new ImageIcon(getClass().getResource("/icon/7.png")), "Import", 6);
        addMenu(new ImageIcon(getClass().getResource("/icon/8.png")), "Setting", 7);
        addEmpty();
        addMenu(new ImageIcon(getClass().getResource("/icon/logout.png")), "Logout", 8);
        this.setFocusable(false);
    }

    private void addEmpty() {
        pm1.add(new JLabel(), "push");
    }

    private void addMenu(Icon icon, String text, int index) {
        ButtonMenu menu = new ButtonMenu();
        menu.setIcon(icon);
        //menu.setFocusable(false);
        menu.setFocusPainted(false);
        menu.setText("  " + text);
        pm1.add(menu);
        menu.addActionListener((ActionEvent ae) -> {
            event.selected(index);
            setSelected(menu);
        });
    }

    private void setSelected(ButtonMenu menu) {
        for (Component com : pm1.getComponents()) {
            if (com instanceof ButtonMenu b) {
                b.setSelected(false);
            }
        }
        menu.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rp1 = new hamroshare.uicomponents.RoundPanel();
        sp1 = new javax.swing.JScrollPane();
        pm1 = new javax.swing.JPanel();
        roundPanel1 = new hamroshare.uicomponents.RoundPanel();
        user2 = new javax.swing.JLabel();
        user1 = new javax.swing.JLabel();
        buttonBadges1 = new hamroshare.uicomponents.ButtonBadges();
        buttonBadges2 = new hamroshare.uicomponents.ButtonBadges();
        avatar2 = new hamroshare.ui.Avatar();

        setPreferredSize(new java.awt.Dimension(165, 420));
        setLayout(null);

        rp1.setBackground(new java.awt.Color(51, 51, 51));

        sp1.setBorder(null);
        sp1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pm1.setBackground(new java.awt.Color(51, 51, 51));
        pm1.setFocusable(false);
        pm1.setRequestFocusEnabled(false);
        pm1.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout pm1Layout = new javax.swing.GroupLayout(pm1);
        pm1.setLayout(pm1Layout);
        pm1Layout.setHorizontalGroup(
            pm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );
        pm1Layout.setVerticalGroup(
            pm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        sp1.setViewportView(pm1);

        javax.swing.GroupLayout rp1Layout = new javax.swing.GroupLayout(rp1);
        rp1.setLayout(rp1Layout);
        rp1Layout.setHorizontalGroup(
            rp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rp1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sp1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        rp1Layout.setVerticalGroup(
            rp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rp1Layout.createSequentialGroup()
                .addComponent(sp1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(rp1);
        rp1.setBounds(0, 95, 164, 325);

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setFocusable(false);
        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        user2.setForeground(new java.awt.Color(224, 224, 224));
        user2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user2.setText("Username");
        roundPanel1.add(user2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, 160, 20));

        user1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        user1.setForeground(new java.awt.Color(224, 224, 224));
        user1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user1.setText("HamroShare App");
        roundPanel1.add(user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 160, -1));

        buttonBadges1.setBackground(new java.awt.Color(25, 25, 25));
        buttonBadges1.setForeground(new java.awt.Color(9, 129, 233));
        buttonBadges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/noti.png"))); // NOI18N
        buttonBadges1.setBadges(5);
        buttonBadges1.setFocusable(false);
        buttonBadges1.setRequestFocusEnabled(false);
        roundPanel1.add(buttonBadges1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 40, 30));

        buttonBadges2.setBackground(new java.awt.Color(25, 25, 25));
        buttonBadges2.setForeground(new java.awt.Color(247, 58, 58));
        buttonBadges2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/message.png"))); // NOI18N
        buttonBadges2.setBadges(15);
        buttonBadges2.setFocusable(false);
        buttonBadges2.setRequestFocusEnabled(false);
        roundPanel1.add(buttonBadges2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));
        roundPanel1.add(avatar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 50));

        add(roundPanel1);
        roundPanel1.setBounds(0, 0, 164, 89);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static hamroshare.ui.Avatar avatar2;
    private hamroshare.uicomponents.ButtonBadges buttonBadges1;
    private hamroshare.uicomponents.ButtonBadges buttonBadges2;
    private javax.swing.JPanel pm1;
    private hamroshare.uicomponents.RoundPanel roundPanel1;
    private hamroshare.uicomponents.RoundPanel rp1;
    private javax.swing.JScrollPane sp1;
    public javax.swing.JLabel user1;
    public static javax.swing.JLabel user2;
    // End of variables declaration//GEN-END:variables
}

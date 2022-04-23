package hamroshare.components;

import hamroshare.Events.EventMenu;
import hamroshare.customswings.ButtonMenu;
import hamroshare.customswings.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    private EventMenu event;
    public Menu() {
        initComponents();
        setOpaque(false);

        //user.setText(LoginController.user.getUsername());
        ScrollBarCustom sb = new ScrollBarCustom();
        sb.setForeground(new Color(130, 130, 130, 100));
        sp1.setVerticalScrollBar(sb);
        pm1.setLayout(new MigLayout("wrap, fillx, inset 3", "[fill]", "[]0[]"));
        sp1.setBackground(new Color(100,0,0,100));
       // rp1.setBackground(new Color(100,0,0,100));
        //pm1.setBackground(new Color(100,0,0,100));
    }

    public void initMenu(EventMenu event) {
        this.event = event;
        addMenu(new ImageIcon(getClass().getResource("/icon/1.png")), "Dashboard", 0);
        addMenu(new ImageIcon(getClass().getResource("/icon/2.png")), "Live Market", 1);
        addMenu(new ImageIcon(getClass().getResource("/icon/3.png")), "Portfolio", 2);
        addMenu(new ImageIcon(getClass().getResource("/icon/4.png")), "Report", 3);
        addMenu(new ImageIcon(getClass().getResource("/icon/5.png")), "Note", 4);
        addMenu(new ImageIcon(getClass().getResource("/icon/6.png")), "Export", 5);
        addMenu(new ImageIcon(getClass().getResource("/icon/7.png")), "Import", 6);
        addMenu(new ImageIcon(getClass().getResource("/icon/8.png")), "Setting", 7);
        addEmpty();
        addMenu(new ImageIcon(getClass().getResource("/icon/logout.png")), "Logout", 8);
    }

    private void addEmpty() {
        pm1.add(new JLabel(), "push");
    }

    private void addMenu(Icon icon, String text, int index) {
        ButtonMenu menu = new ButtonMenu();
        menu.setIcon(icon);
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

        rp1 = new hamroshare.customswings.RoundPanel();
        sp1 = new javax.swing.JScrollPane();
        pm1 = new javax.swing.JPanel();
        roundPanel1 = new hamroshare.customswings.RoundPanel();
        imageAvatar2 = new hamroshare.customswings.ImageAvatar();
        user2 = new javax.swing.JLabel();
        user1 = new javax.swing.JLabel();

        rp1.setBackground(new java.awt.Color(51, 51, 51));

        sp1.setBorder(null);
        sp1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pm1.setBackground(new java.awt.Color(51, 51, 51));

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
                .addComponent(sp1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        rp1Layout.setVerticalGroup(
            rp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rp1Layout.createSequentialGroup()
                .addComponent(sp1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        imageAvatar2.setForeground(new java.awt.Color(231, 231, 231));
        imageAvatar2.setBorderSize(2);
        imageAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.jpg"))); // NOI18N

        user2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        user2.setForeground(new java.awt.Color(224, 224, 224));
        user2.setText("Username");

        user1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        user1.setForeground(new java.awt.Color(224, 224, 224));
        user1.setText("HamroShare App");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(user2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(user1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(user2))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rp1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(rp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public hamroshare.customswings.ImageAvatar imageAvatar2;
    private javax.swing.JPanel pm1;
    private hamroshare.customswings.RoundPanel roundPanel1;
    private hamroshare.customswings.RoundPanel rp1;
    private javax.swing.JScrollPane sp1;
    public javax.swing.JLabel user1;
    public javax.swing.JLabel user2;
    // End of variables declaration//GEN-END:variables
}

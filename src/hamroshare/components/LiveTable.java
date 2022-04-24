package hamroshare.components;

import Algorithms.SearchLiveData;
import hamroshare.customswings.ScrollBarCustom;
import java.awt.Color;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Sijan Bhandari
 */
public class LiveTable extends javax.swing.JPanel {

    /**
     * Creates new form Dash1
     */
    public LiveTable() {
        initComponents();
        tbl.setDefaultRenderer(Object.class, new MyTableCellRenderer());
        ScrollBarCustom sb = new ScrollBarCustom();
        sb.setForeground(Color.white);
        sp1.setVerticalScrollBar(sb);
        //sp1.setLayout(new MigLayout("wrap, fillx, inset 3", "[fill]", "[]0[]"));
        sp1.setBackground(new Color(100, 0, 0, 100));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashpanel = new hamroshare.customswings.RoundPanel();
        sp1 = new javax.swing.JScrollPane();
        tbl = new rojerusan.RSTableMetro();
        srchText = new rojeru_san.rsfield.RSTextMaterial();

        setOpaque(false);

        dashpanel.setBackground(new java.awt.Color(51, 51, 51));
        dashpanel.setForeground(new java.awt.Color(102, 102, 102));
        dashpanel.setPreferredSize(new java.awt.Dimension(162, 418));
        dashpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sp1.setForeground(new java.awt.Color(51, 51, 51));
        sp1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sp1.setEnabled(false);
        sp1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                sp1ComponentResized(evt);
            }
        });

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Symbol", "Market Price", "Change", "Difference"
            }
        ));
        tbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbl.setAutoscrolls(false);
        tbl.setEnabled(false);
        tbl.setFocusable(false);
        sp1.setViewportView(tbl);

        dashpanel.add(sp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 390, 390));

        srchText.setBackground(new java.awt.Color(51, 51, 51));
        srchText.setForeground(new java.awt.Color(255, 255, 255));
        srchText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        srchText.setColorMaterial(new java.awt.Color(255, 255, 255));
        srchText.setOpaque(true);
        srchText.setPlaceholder("Search Company");
        srchText.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                srchTextCaretUpdate(evt);
            }
        });
        dashpanel.add(srchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(dashpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(dashpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sp1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_sp1ComponentResized
        tbl.scrollRectToVisible(tbl.getCellRect(0, 0, true));
    }//GEN-LAST:event_sp1ComponentResized

    private void srchTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_srchTextCaretUpdate
        String key = srchText.getText();
        SearchLiveData.displayToTable(key);
    }//GEN-LAST:event_srchTextCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hamroshare.customswings.RoundPanel dashpanel;
    private javax.swing.JScrollPane sp1;
    private rojeru_san.rsfield.RSTextMaterial srchText;
    public static rojerusan.RSTableMetro tbl;
    // End of variables declaration//GEN-END:variables
}

class MyTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Color getBackground() {
        return super.getBackground();
    }
}

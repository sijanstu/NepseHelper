package hamroshare.ui.notes;

import hamroshare.config.HamroFetcher;
import hamroshare.config.HamroPath;
import hamroshare.dtos.Note;
import hamroshare.ui.Notes;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijan Bhandari
 */
public class NoteItem extends javax.swing.JPanel {

    /**
     * Creates new form NoteItem
     */
    private Note note;
    public NoteItem() {
        initComponents();
        edit.setVisible(false);
    }
    public NoteItem(Note note) {
        initComponents();
        this.note=note;
        title.setText(note.getTitle());
        edit.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        rSButtonIconUno1 = new RSMaterialComponent.RSButtonIconUno();
        edit = new RSMaterialComponent.RSButtonIconUno();

        setBackground(new java.awt.Color(51, 51, 51));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Example Title");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 50));

        rSButtonIconUno1.setBackground(new java.awt.Color(255, 153, 153));
        rSButtonIconUno1.setForegroundText(new java.awt.Color(255, 0, 0));
        rSButtonIconUno1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        rSButtonIconUno1.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        rSButtonIconUno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconUno1ActionPerformed(evt);
            }
        });
        add(rSButtonIconUno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 7, -1, -1));

        edit.setBackground(new java.awt.Color(255, 255, 102));
        edit.setForeground(new java.awt.Color(0, 204, 204));
        edit.setForegroundText(new java.awt.Color(0, 204, 51));
        edit.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        edit.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 7, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
     
    }//GEN-LAST:event_editActionPerformed

    private void rSButtonIconUno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconUno1ActionPerformed
        new ThreadNoteDeleter().start();
    }//GEN-LAST:event_rSButtonIconUno1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonIconUno edit;
    private RSMaterialComponent.RSButtonIconUno rSButtonIconUno1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
class ThreadNoteDeleter extends Thread{
    @Override 
    public void run(){
        try {
            String url=HamroPath.ApiHome+"/user/note/delete/"+note.getId();
            HamroFetcher.getData(url);
            Notes.noteList.RefreshNotes();
        } catch (IOException ex) {
            Logger.getLogger(NoteItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
}

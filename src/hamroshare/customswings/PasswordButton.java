package hamroshare.customswings;

import hamroshare.components.Login;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Sijan Bhandari
 */
public class PasswordButton {

    String imgname;

    public PasswordButton(JLabel label, String evt, String name) {
        imgname = name;
        switch (evt) {
            case "clicked": {
                setIconPass(label);break;
            }
            default:
                setIconNormal(label);
        }
    }

    final void setIconPass(JLabel label) {
        label.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(imgname)).getImage().
                getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
    }

    private void setIconNormal(JLabel label) {
        label.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(imgname)).getImage().
                getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
    }

}

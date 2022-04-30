package hamroshare.calculations;

import hamroshare.ui.MessageDialog;
import java.awt.Color;
import java.awt.Rectangle;
import static java.lang.System.exit;
import javax.swing.JLabel;

/**
 *
 * @author Sijan Bhandari
 */
public class CloseController {

    public static void initBar() {
        //bar = new Bar();
        // bar.setVisible(true);
        // bar.init();
        // bar.setBackground(new Color(0, 0, 0, 0));
        // System.out.println("done");
    }

    public static void clicked(Rectangle rect) {
        MessageDialog obj = new MessageDialog();
        obj.setBounds(rect.x - 50, rect.y - 50, rect.width - 6, rect.height - 6);
        obj.showMessage("Are You Sure?", "You can also minimize for later...");
        obj.background1.setBackground(Color.BLACK);
        obj.background1.setForeground(Color.WHITE);
        if (obj.getMessageType() == MessageDialog.MessageType.OK) {
            exit(0);
        } else {
            System.out.println("Canceled");
        }
    }

    public static void hovered(JLabel close) {
        new AutoSetIcon().set(close, "/icon/close.png", false, 5);
    }

    public static void exitHover(JLabel close) {
        new AutoSetIcon().set(close, "/icon/close.png");
    }
}

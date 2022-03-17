package hamroshare.Calculation;

import hamroshare.components.Bar;
import hamroshare.components.MessageDialog;
import java.awt.Color;
import java.awt.Rectangle;
import static java.lang.System.exit;
import javax.swing.JFrame;

/**
 *
 * @author Sijan Bhandari
 */
public class CloseController {

    public static Bar bar;
    private static Rectangle bound;

    public static void changePosition(JFrame jf) {
        CloseController.bound = jf.getBounds();
        int width = bar.getWidth();
        int height = bar.getHeight();
        int X = bound.x - width + 5;
        int Y = bound.y - height + 5;

        if (Y < 5 && X > 5) {
            bar.setBounds(X, Y + jf.getHeight(), width, height);
        } else if (X < 5 && Y > 5) {
            bar.setBounds(X + jf.getWidth() + width, Y, width, height);
        } else if (X < 5 && Y < 5) {
            bar.setBounds(X+bound.width+width-5, Y+bound.height-5, width, height);
            System.out.println(bar.getBounds());
        } else {
            bar.setBounds(X, Y, width, height);
        }
    }

    public static void initBar() {
        bar = new Bar();
        bar.setVisible(true);
        bar.init();
        bar.setBackground(new Color(0, 0, 0, 0));
        System.out.println("done");
    }

    public static void clicked() {
        MessageDialog obj = new MessageDialog();
        obj.setBounds(bound.x - 50, bound.y - 50, bound.width - 6, bound.height - 6);
        obj.showMessage("Are You Sure?", "Please save any data before closing");
        obj.background1.setBackground(Color.BLACK);
        obj.background1.setForeground(Color.WHITE);
        if (obj.getMessageType() == MessageDialog.MessageType.OK) {
            exit(0);
        } else {
            System.out.println("Canceled");
        }
    }

    public static void hovered() {
        new AutoSetIcon(bar.close, "/icon/close.png", false, 5);
    }

    public static void exitHover() {
        new AutoSetIcon(bar.close, "/icon/close.png");
    }
}

package Calculation;

import Main.Swings.Bar;
import Main.Swings.MessageDialog;
import java.awt.Color;
import java.awt.Rectangle;
import static java.lang.System.exit;

/**
 *
 * @author Sijan Bhandari
 */
public class CloseController {

    public static Bar bar;
    private static Rectangle bound;

    public static void changePosition(Rectangle bound) {
        CloseController.bound = bound;
        int width = bar.getWidth();
        int height = bar.getHeight();
        int X = bound.x - width;
        int Y = bound.y - height;
        bar.setBounds(X, Y, width, height);
        System.out.println("done");
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
        new AutoSetIcon(bar.close, "/resources/close.png", false, 5);
    }

    public static void exitHover() {
        new AutoSetIcon(bar.close, "/resources/close.png");
    }
}

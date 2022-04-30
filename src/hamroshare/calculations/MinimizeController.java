package hamroshare.calculations;

import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Sijan Bhandari
 */
public class MinimizeController {
    public static void clicked(JFrame frame) {
        frame.setState(Frame.ICONIFIED);
    }

    public static void hovered(JLabel close) {
        new AutoSetIcon().set(close, "/icon/minimize.png", false, 5);
    }

    public static void exitHover(JLabel close) {
        new AutoSetIcon().set(close, "/icon/minimize.png");
    }
}

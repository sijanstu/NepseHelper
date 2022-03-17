package hamroshare.Calculation;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sijan Bhandari
 */
public class GUIDimension {

    Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    int scrheight = scrsize.height;
    int scrwidth = scrsize.width;
    int taskheight = (int) (scrsize.getHeight() - winSize.height);

    public GUIDimension(JFrame jframe, String type) {
        switch (type) {
            case "login":
                int height = jframe.getHeight();
                int width = jframe.getWidth();
                jframe.setBounds(scrwidth - 5 - width, scrheight - 5 - height - taskheight, width, height);
                break;
            case "dashboard":

            default:
        }

    }
    private static Point currentLocation;


}

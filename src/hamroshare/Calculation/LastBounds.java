
package hamroshare.Calculation;

import java.awt.Rectangle;
import javax.swing.JFrame;

/**
 *
 * @author Sijan Bhandari
 */
public class LastBounds {
    public static Rectangle bound;
    static public Rectangle getBounds(JFrame frame){
        
        if(bound==null){
            return frame.getBounds();
        }
        return bound;
    }
}

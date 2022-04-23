
package hamroshare.Calculation;

import java.awt.Rectangle;
import javax.swing.JFrame;

/**
 *
 * @author Sijan Bhandari
 */
public class LastBounds {
    public static Rectangle storedBound;
    static public Rectangle getBounds(JFrame frame){
        
        if(storedBound==null){
            return frame.getBounds();
        }
        Rectangle newBound=new Rectangle();
        newBound.x=storedBound.x;
        newBound.y=storedBound.y;
        newBound.width=frame.getWidth();
        newBound.height=frame.getHeight();
        return newBound;
    }
}

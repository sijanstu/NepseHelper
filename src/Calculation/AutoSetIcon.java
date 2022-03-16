package Calculation;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Sijan Bhandari
 */
public class AutoSetIcon {

    public AutoSetIcon(JLabel jl, String url) {
        jl.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(url)).getImage().
                getScaledInstance(jl.getWidth(), jl.getHeight(), Image.SCALE_DEFAULT)));

    }

    public AutoSetIcon(JLabel jl, String url, Boolean increase, int i) {
        int width, height;
        if (increase) {
            width = jl.getWidth() + i;
            height = jl.getHeight() + i;
        } else {
            width = jl.getWidth() - i;
            height = jl.getHeight() - i;
        }
        jl.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(url)).getImage().
                getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    }
}

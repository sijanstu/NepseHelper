package custom;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.JLabel;

/**
 *
 * @author Sijan Bhandari
 */
public class LoginButton extends JLabel {

    int value = 0;
    Graphics2D g2;
    final Color[] loginButtonColors = {UIUtils.COLOR_INTERACTIVE, Color.white};

    public LoginButton() {
        setBackground(UIUtils.COLOR_BACKGROUND);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = UIUtils.get2dGraphics(g);
        super.paintComponent(g2);

        Insets insets = getInsets();
        int w = getWidth() - insets.left - insets.right;
        int h = getHeight() - insets.top - insets.bottom;
        g2.setColor(loginButtonColors[0]);
        g2.fillRoundRect(insets.left, insets.top, w, h, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

        FontMetrics metrics = g2.getFontMetrics(UIUtils.FONT_GENERAL_UI);
        int x2 = (getWidth() - metrics.stringWidth(UIUtils.BUTTON_TEXT_LOGIN)) / 2;
        int y2 = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g2.setFont(UIUtils.FONT_GENERAL_UI);
        g2.setColor(loginButtonColors[1]);
        String text;

        if (value == 0) {
            text = "Login";
        } else {
            text = "SignUp";
        }
        g2.drawString(text, x2, y2);
    }

    public void toSignUp() {
        value=1;
    }
}

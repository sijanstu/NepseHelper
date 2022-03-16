package Events;

import Calculation.CloseController;
import DataBase.Connector;
import Main.Start;
import Main.Swings.Login;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class JFrameCloser extends TimerTask {

    static Start j1;
    static Timer timer;
    static boolean repeat = true;
    static boolean isfirst = true;

    @Override
    public void run() {
        if (!isfirst) {
            System.out.println("retrying");
            j1.j2.setText("Retrying");
        }
        isfirst = false;
        if (Connector.isconnected) {
            System.out.println("opened Login");
            close(j1);
            new Login();
            Login.main();
            timer.cancel();
        }
    }

    public static void open(Start jframe1, boolean isthread) {
        if (isthread) {
            j1 = jframe1;
            timer = new Timer();
            if (!Connector.isconnected) {
                timer.cancel();
                timer = new Timer();
                timer.schedule(new JFrameCloser(), 1700, 500);
            } else {
                timer.cancel();
                timer = new Timer();
                timer.schedule(new JFrameCloser(), 500);
            }
        } else {
            close(jframe1);
        }

    }

    public static void close(JFrame jframe) {
        jframe.dispose();
    }
}

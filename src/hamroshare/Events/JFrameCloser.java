package hamroshare.eventhandlers;

import hamroshare.databases.CheckConnection;
import hamroshare.dtos.UserDto;
import hamroshare.login.LoginController;
import hamroshare.mainpackage.MainClass;
import hamroshare.ui.Avatar;
import hamroshare.ui.Dash;
import hamroshare.ui.Login;
import hamroshare.uicomponents.ImageAvatar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class JFrameCloser extends TimerTask {

    static MainClass j1;
    static Timer timer;
    static boolean repeat = true;
    static boolean isfirst = true;

    @Override
    public void run() {
        if (!isfirst) {
            System.out.println("retrying");
            j1.j2.setText("Waking server");
            CheckConnection con = new CheckConnection();
            con.start();
        }
        isfirst = false;
        if (CheckConnection.isConnected) {
            System.out.println("opened Login");
            close(j1);
            UserDto user = LoginController.checkLogin();
            if (user != null) {
                Dash.main();
                Avatar.imageAvatar2=new ImageAvatar();
                       Avatar.imageAvatar2.setIcon(LoginController.userIcon);
            } else {
                Login.main();
            }
            timer.cancel();
        }
    }

    public static void open(MainClass jframe1, boolean isthread) {
        if (isthread) {
            j1 = jframe1;
            timer = new Timer();
            if (!CheckConnection.isConnected) {
                timer.cancel();
                timer = new Timer();
                timer.schedule(new JFrameCloser(), 1700, 1000);
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

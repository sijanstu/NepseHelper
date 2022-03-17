package hamroshare.Events;

import hamroshare.customswings.Toaster;
import javax.swing.JPanel;

/**
 *
 * @author Sijan Bhandari
 */
public class Info {

    private static String[] messes;
    static private Toaster toast;

    public static void display(JPanel jpanel, String mess, int type, int time) {
        messes = new String[10];
        messes[0] = mess;
        toast = new Toaster(jpanel);
        toast.stime = time;
        switch (type) {
            case 0:
                toast.error(mess);break;
            case 1:
                toast.success(mess);break;
            case 2:
                toast.info(messes);break;
            case 3:
                toast.warn(messes);break;
            default:
                toast.error(mess);
        }
    }

    static void initMessage(Toaster toast) {

    }

}

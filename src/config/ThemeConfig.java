package config;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijan
 */
public class ThemeConfig {

    public FlatLaf get() {
        return readTheme();
    }

    public boolean set(FlatLaf flatLaf) {
        if (flatLaf.equals(new FlatDarkLaf())) {
            return storeTheme("1");
        } else {
            return storeTheme("0");
        }
    }

    private FlatLaf readTheme() {
        File file = new File("themes/flatlaf.txt");

        try {
            if (!file.exists()) {
                file.mkdir();
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/themes/flatlaf.txt")));
            String value = bufferedReader.readLine();
            if (value.equals("1")) {
                bufferedReader.close();
                return new FlatDarkLaf();
            }
            if (value.equals("0")) {
                bufferedReader.close();
                return new FlatLightLaf();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ThemeConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThemeConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private boolean storeTheme(String value) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File("themes/flatlaf.txt")));
            bufferedWriter.write(value);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ThemeConfig.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(ThemeConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}

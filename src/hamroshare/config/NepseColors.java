package hamroshare.config;

import java.awt.Color;
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
 * @author Sijan Bhandari
 */
public final class NepseColors {

    public static NepseColors ncolors = new NepseColors();
    private Color red = new Color(247,58,58);
    private Color green = new Color(0, 144, 50);
    File colorFile = new File("colors.txt");

    public NepseColors() {
        initColor();
        storeColors();
    }

    public void initColor() {

        if (colorFile.exists()) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(colorFile));
                String firstString = bufferedReader.readLine();
                System.out.println(firstString);
                if (!"".equals(firstString)) {
                    setGreen(new Color(
                            Integer.parseInt(firstString),
                            Integer.parseInt(bufferedReader.readLine()),
                            Integer.parseInt(bufferedReader.readLine())
                    ));
                    setRed(new Color(
                            Integer.parseInt(bufferedReader.readLine()),
                            Integer.parseInt(bufferedReader.readLine()),
                            Integer.parseInt(bufferedReader.readLine())
                    ));
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NepseColors.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(NepseColors.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException | NullPointerException ex) {
                    Logger.getLogger(NepseColors.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            red = new Color(247,58,58);
            green = new Color(0, 144, 50);
        }
    }

    void storeColors() {
        try ( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(colorFile))) {
            bufferedWriter.write(
                    green.getRed() + "\n"
                    + green.getGreen() + "\n"
                    + green.getBlue() + "\n"
                    + red.getRed() + "\n"
                    + red.getGreen() + "\n"
                    + red.getBlue()
            );
        } catch (IOException ex) {
            Logger.getLogger(NepseColors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Color getRed() {
        return red;
    }

    public void setRed(Color red) {
        this.red = red;
        storeColors();
    }

    public Color getGreen() {
        return green;
    }

    public void setGreen(Color green) {
        this.green = green;
        storeColors();
    }

    @Override
    public String toString() {
        return "NepseColors{" + "red=" + red + ", green=" + green + '}';
    }

}

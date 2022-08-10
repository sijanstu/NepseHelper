package hamroshare.login;

import com.google.gson.Gson;
import hamroshare.config.HamroPath;
import hamroshare.dataalgorithms.MD5;
import hamroshare.dtos.StoreDto;
import hamroshare.dtos.UserDto;
import hamroshare.dtos.UserLoginDto;
import hamroshare.ui.Avatar;
import hamroshare.uicomponents.ImageAvatar;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.apache.commons.io.IOUtils;

public class LoginController {

    public static UserDto userDto;
    public static ImageIcon userIcon = new ImageIcon("src/hamroshare/images/user.png");

    static public UserDto login(UserLoginDto userLoginDto) throws Exception {
        String urlPost = HamroPath.ApiHome+"/auth/login";
        return postMethod(urlPost, userLoginDto);
    }

    static public UserDto register(UserDto userDto) throws Exception {
        String urlPost = HamroPath.ApiHome+"/user";
        return postMethod(urlPost, userDto);
    }

    static private UserDto postMethod(String url, Object user) throws Exception {
        String json = new Gson().toJson(user);
        System.out.println(json);
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla")
                .header("content-type", "application/json")
                .header("accept", "application/json")
                .requestBody(json)
                .ignoreContentType(true).post();

        System.out.println(doc.documentType());
        userDto = new Gson().fromJson(doc.text(), UserDto.class);
        setImageIcon(userDto);
        signOutUser();
        storeObject(userDto);
        return userDto;
    }

    static public UserDto getUserWithId(Long id) throws IOException {
        String url = HamroPath.ApiHome+"/user/" + id;
        System.out.println(id);
        // Document doc = Jsoup.parse();
        userDto = new Gson().fromJson(IOUtils.toString(new URL(url).openStream()), UserDto.class);
        setImageIcon(userDto);
        return userDto;
    }

    public static void setImageIcon(UserDto userDto) {
        if (userDto.getImageUrl() != null) {
            try {
                userIcon = new ImageIcon(new URL(userDto.getImageUrl()));
                Avatar.imageAvatar2 = new ImageAvatar();
                Avatar.imageAvatar2.setIcon(LoginController.userIcon);
            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean signOutUser() {
        File file = new File(HamroPath.SystemPath+"/user.dat");
        if (file.exists()) {
            file.deleteOnExit();
            file.delete();
        }
        return true;
    }

    public static UserDto checkLogin() {
        try {
            UserDto localUserDto = readObject();
            if (localUserDto.getMID().equals(getMachineID())) {
                if (localUserDto.getId() != null) {
                    //userDto=getUserWithId(localUserDto.getId());
                    System.out.println(localUserDto.getImageUrl());
                    userDto = localUserDto;
                    //setImageIcon(userDto);
                    return userDto;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            signOutUser();
            return null;

        }
        signOutUser();
        return null;
    }

    public static boolean storeObject(UserDto user) throws IOException {
        StoreDto storeDto = new StoreDto();
        byte[] imageByte=getImage(user.getImageUrl());
        ByteArrayInputStream bais = new ByteArrayInputStream(imageByte);
        BufferedImage image = ImageIO.read(bais);
        userIcon = new ImageIcon(image);
        storeDto.setIcon(userIcon);
        FileOutputStream fos = new FileOutputStream(HamroPath.SystemPath+"/user.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        user.setMID(getMachineID());
        storeDto.setUser(user);
        oos.writeObject(storeDto);
        return false;
    }

    public static UserDto readObject() throws ClassCastException, ClassNotFoundException, FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(HamroPath.SystemPath+"/user.dat");
        ObjectInputStream oos = new ObjectInputStream(fis);
        StoreDto storeDto = (StoreDto) oos.readObject();
        //ByteArrayInputStream bais = new ByteArrayInputStream(storeDto.getIcon());
        //BufferedImage image = ImageIO.read(bais);
        userIcon = storeDto.getIcon();
        userDto = storeDto.getUser();
        return userDto;
    }

    private static String getMachineID() throws IOException {
        String command = "wmic csproduct get UUID";
        StringBuilder output = new StringBuilder();
        Process SerNumProcess = Runtime.getRuntime().exec(command);
        BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
        String line;
        while ((line = sNumReader.readLine()) != null) {
            output.append(line).append("\n");
        }
        String MachineID = output.toString().substring(output.indexOf("\n"), output.length()).trim();
        return MD5.generate(MachineID);
    }

    static byte[] getImage(String u) throws IOException {
        URL url = new URL(u);
        url.openConnection().getContentLength();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = null;
        try {
            is = url.openStream();
            byte[] byteChunk = new byte[4096]; // Or whatever size you want to read in at a time.
            int n;

            while ((n = is.read(byteChunk)) > 0) {
                baos.write(byteChunk, 0, n);
            }
        } catch (IOException e) {
            System.err.printf("Failed while reading bytes from %s: %s", url.toExternalForm(), e.getMessage());
            // Perform any other exception handling that's appropriate.
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return baos.toByteArray();
    }
}

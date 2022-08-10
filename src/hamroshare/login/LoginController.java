package hamroshare.login;

import com.google.gson.Gson;
import hamroshare.dataalgorithms.MD5;
import hamroshare.dtos.UserDto;
import hamroshare.dtos.UserLoginDto;
import hamroshare.ui.Avatar;
import hamroshare.uicomponents.ImageAvatar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.apache.commons.io.IOUtils;

public class LoginController {

    public static UserDto userDto;
    public static ImageIcon userIcon = new ImageIcon("src/hamroshare/images/user.png");

    static public UserDto login(UserLoginDto userLoginDto) throws Exception {
        String urlPost = "https://hamroapi.sijanbhandari.com.np/auth/login";
        return postMethod(urlPost, userLoginDto);
    }

    static public UserDto register(UserDto userDto) throws Exception {
        String urlPost = "https://hamroapi.sijanbhandari.com.np/user";
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
        String url = "https://hamroapi.sijanbhandari.com.np/user/" + id;
        System.out.println(id);
       // Document doc = Jsoup.parse();
        userDto = new Gson().fromJson(IOUtils.toString(new URL(url).openStream()), UserDto.class);
        setImageIcon(userDto);
        return userDto;
    }

   public static void setImageIcon(UserDto userDto) {
       if(userDto.getImageUrl()!=null){
           try {
               userIcon=new ImageIcon(new URL(userDto.getImageUrl()));
               Avatar.imageAvatar2=new ImageAvatar();
                       Avatar.imageAvatar2.setIcon(LoginController.userIcon);
           } catch (MalformedURLException ex) {
               Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }

    public static boolean signOutUser() {
        File file = new File("user.dat");
        if (file.exists()) {
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
                   userDto=localUserDto;
                   setImageIcon(userDto);
                   return userDto;
                }
            }
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        signOutUser();
        return null;
    }

    public static boolean storeObject(UserDto user) throws IOException {
        FileOutputStream fos = new FileOutputStream("user.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        user.setMID(getMachineID());
        oos.writeObject(user);
        return false;
    }

    public static UserDto readObject() throws ClassNotFoundException, FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("user.dat");
        ObjectInputStream oos = new ObjectInputStream(fis);
        return (UserDto) oos.readObject();
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
}

package hamroapi;

import com.google.gson.Gson;
import hamroshare.dtos.UserDto;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
public class PostUser {

    public static UserDto createUser(UserDto user) throws Exception {
        URL obj = new URL("http://hamroapi.herokuapp.com/user");
        String json = new Gson().toJson(new UserDto());
        System.out.println(json);
        byte[] postDataBytes = json.getBytes("UTF-8");
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;) {
            sb.append((char) c);
        }
        String response = sb.toString();
        System.out.println(response);
        return null;
    }
    
    public static void loginUser(UserDto user){
        
    }
}

package hamroshare.mainpackage;

import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import hamroshare.dtos.UserLoginDto;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Sijan
 */
public class TestClass {

    public static void main(String[] args) throws IOException {
        String url = "https://hamroapi.herokuapp.com/user/list";
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla")
                .header("content-type", "application/json")
                .header("accept", "application/json")
                .ignoreContentType(true).get();
        String json = doc.text();
        System.out.println(json);
        tryPost();
    }

    static void tryPost() {
        try {
            UserLoginDto userLoginDto=new UserLoginDto();
            userLoginDto.setUsername("ssssss");
            userLoginDto.setPassword("9F6E6800CFAE7749EB6C486619254B9C");
            String json = new Gson().toJson(userLoginDto,UserLoginDto.class);
            System.out.println(json);
            String url = "https://hamroapi.herokuapp.com/auth/login";
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .header("content-type", "application/json")
                    .header("accept", "application/json")
                    .requestBody(json)
                    .ignoreContentType(true).post();
            System.out.println(doc.text());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

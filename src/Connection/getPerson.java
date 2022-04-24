package Connection;

import com.google.api.client.util.Data;
import com.google.gson.*;
import com.google.gson.reflect.*;
import hamroshare.Model.Company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author Sijan Bhandari
 */
public class getPerson {

    private static final String URL = "https://hamroapi.herokuapp.com/freshcompanies";

    public static void main(String[] args) throws MalformedURLException, IOException, Exception {

        NepseApi nepseApi = new NepseApi();
        nepseApi.startPage();
        System.out.println(Arrays.toString(nepseApi.getAllIndexNames()));
        nepseApi.getAllIndexes();
        //System.out.println(nepseApi.getNepseIndex());

//        String data = readUrl(URL);
//        JSONArray jsonArray = new JSONArray(data);
//        System.out.println(jsonArray);
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}

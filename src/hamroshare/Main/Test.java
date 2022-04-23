package hamroshare.Main;

import Connection.NepseApi;
import hamroshare.Model.Company;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Sijan Bhandari
 */
public class Test {

    public static void main(String[] args) throws IOException {
        NepseApi nepseApi=new NepseApi();
        Company[] companies=nepseApi.getAllCompanyDirectly();
        System.out.println(Arrays.toString(companies));
        
    }
}

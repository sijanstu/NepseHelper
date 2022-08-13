package hamroshare.config;

/**
 *
 * @author Sijan Bhandari
 */
public class HamroPath {
    public static String SystemPath=System.getProperty("user.home");
    public static String ApiHome="https://hamroapi2.herokuapp.com";
    public static String HistoricNepse="https://github.com/Aabishkar2/nepse-data/blob/main/data/company-wise/";
    public static String NepalStock="http://www.nepalstock.com/";
    public void setHerokuServer(boolean heroku ){
        if(heroku){
            ApiHome="https://hamroapi2.herokuapp.com";
        }else{
            ApiHome="https://hamroapi2.sijanbhandari.com.np";
        }
    } 
}

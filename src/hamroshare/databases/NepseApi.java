package hamroshare.databases;

import hamroshare.dtos.Index;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import hamroshare.dtos.Company;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Sijan Bhandari
 */
public final class NepseApi {

    private static final int TIMEOUT = 10000;
    private static Document page=null;
    private static Element table;
    private static Elements head, row;

    public void init() throws IOException {
        startPage();
        RefreshData();
    }

    public static String getDateString() throws IOException {
        //startPage();
        return page.getElementById("market_status").getAllElements().get(0).child(0).text();

    }

    static void deleteAll() {
        for (String comp : getAllcompany()) {
            DBFirebase.databaseFirestore.collection("companies").document(comp).delete();
        }
    }

    public String[] getAllIndexNames() {
        Elements indexElements = page.getElementsByClass("indexTicker_basic-info");
        String[] indexList = new String[indexElements.size()];
        int count = 0;
        for (Element indexElement : indexElements) {
            indexList[count] = indexElement.getElementsByTag("span").text();
            count++;
        }
        return indexList;
    }

    public void getAllIndexes() {
        String[] indexNames = getAllIndexNames();
        //Index[] indexes = new Index[indexNames.length];
        int count = 0;
        Elements indexElements = page.getElementsByClass("indexTicker_more-info");
        System.out.println(indexElements);
        System.out.println(indexElements.size());
        for (String indexName : indexNames) {
            Index index = new Index();
            index.setName(indexName);
            index.setValue(indexElements.get(count).child(0).text());
            index.setChange(indexElements.get(count).child(2).text().replace("%", ""));
            System.out.println(index);
            count++;
        }
    }

    public Index getNepseIndex() {
        Elements indexElements = page.getElementsByClass("indexTicker_more-info");
        Element indexElement = indexElements.get(6);
        Element name = page.getElementsByClass("indexTicker_basic-info").get(6).getElementsByClass("indexTicker_itemName").get(0);
        Element value = indexElement.getElementsByClass("indexTicker_more-info").get(0).child(0);
        Element change = indexElement.getElementsByClass("indexTicker_more-info").get(0).child(2);
        return new Index(name.text(), value.text(), change.text());
    }

    static public Company[] getAllCompany() {
        try {
            ApiFuture<QuerySnapshot> query = DBFirebase.databaseFirestore.collection("companies").get();
            QuerySnapshot querySnapshot = query.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
            Company[] companies = new Company[documents.size()];
            int i = 0;
            for (QueryDocumentSnapshot document : documents) {
                companies[i] = new Company();
                companies[i].setSymbol(document.getString("Symbols"));
                companies[i].setChangePrice(document.getString("Change"));
                companies[i].setClosingprice(document.getString("Closing Price"));
                companies[i].setQuantity(document.getString("Quantity"));
                companies[i].setMinprice(document.getString("Min Price"));
                companies[i].setMaxprice(document.getString("Max Price"));
                companies[i].setDifference(document.getString("Difference"));
                companies[i].setTransaction(document.getString("No of Transaction"));
                companies[i].setLtv(document.getString("LTV"));
                companies[i].setOpenprice(document.getString("Opening Price"));
                i++;
            }
            return companies;
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(NepseApi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean RefreshData() {
        deleteAll();
        try {
            int i = 0;
            for (String comp : getAllcompany()) {
                String[] compdata = getBySymbol(comp);
                String[] headings = getHeader();
                DocumentReference docRef = DBFirebase.databaseFirestore.collection("companies").document(comp);
                Map<String, Object> data = new HashMap<>();
                data.put(headings[0], compdata[0]);
                data.put(headings[1], compdata[1]);
                data.put(headings[2], compdata[2]);
                data.put("Change", compdata[3]);
                data.put(headings[4], compdata[4]);
                data.put(headings[5], compdata[5]);
                data.put(headings[6], compdata[6]);
                data.put(headings[7], compdata[7]);
                data.put(headings[8], compdata[8]);
                data.put("Difference", compdata[9]);
                docRef.set(data);
                i++;
            }
            DocumentReference docRef = DBFirebase.databaseFirestore.collection("Market").document("Nepse");
            Map<String, Object> data = new HashMap<>();
            if (isMarketOpen()) {
                data.put("status", "Open");
            } else {
                data.put("status", "Closed");
            }
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Update time : " + result.get().getUpdateTime());
            return true;
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(NepseApi.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private boolean isMarketOpen() {
        String closed = page.getElementsByClass("marketclose").get(0).text();
        return !closed.equals("Market Closed");
    }

    private String[] getHeader() {
        String[] data = new String[10];
        head = table.select("th");
        for (int i = 0; i < head.size(); i++) {
            data[i] = head.get(i).text();
        }
        return data;
    }

    public static void startPage() throws MalformedURLException, IOException {
        page = Jsoup.connect(URL).ignoreContentType(true).get();
        table = page.getElementById("tbl_LiveStock");
        row = page.getElementsByTag("tr");
    }

    private static String[] getAllcompany() {
        if(page==null){
            try {
                startPage();
            } catch (IOException ex) {
                Logger.getLogger(NepseApi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String[] data = new String[row.size() - 1];
        for (int i = 1; i < row.size(); i++) {
            data[i - 1] = row.get(i).getElementsByTag("td").get(0).text();
        }
        return data;
    }

    private String[] getBySymbol(String sym) {
        String[] data = new String[10];
        for (int i = 1; i < row.size(); i++) {
            if (row.get(i).getElementsByTag("td").get(0).text().toLowerCase().equals(sym.toLowerCase())) {
                data[0] = row.get(i).getElementsByTag("td").get(0).text();
                data[1] = row.get(i).getElementsByTag("td").get(1).text();
                data[2] = row.get(i).getElementsByTag("td").get(2).text();
                data[3] = row.get(i).getElementsByTag("td").get(3).text();
                data[4] = row.get(i).getElementsByTag("td").get(4).text();
                data[5] = row.get(i).getElementsByTag("td").get(5).text();
                data[6] = row.get(i).getElementsByTag("td").get(6).text();
                data[7] = row.get(i).getElementsByTag("td").get(7).text();
                data[8] = row.get(i).getElementsByTag("td").get(8).text();
                data[9] = row.get(i).getElementsByTag("td").get(9).text();
            }
        }
        return data;

    }
    
    public Company[] getAllCompanyDirectly() throws IOException {
        startPage();
        String[] companiesNames = getAllcompany();
        Company[] companies = new Company[companiesNames.length];
        int count = 0;
        for (String companyName : companiesNames) {
            String[] companyDetails = getBySymbol(companyName);
            Company company = new Company();
            company.setSymbol(companyDetails[0]);
            company.setClosingprice(companyDetails[1]);
            company.setLtv(companyDetails[2]);
            company.setChangePrice(companyDetails[3]);
            company.setMaxprice(companyDetails[4]);
            company.setMaxprice(companyDetails[5]);
            company.setOpenprice(companyDetails[6]);
            company.setQuantity(companyDetails[7]);
            company.setTransaction(companyDetails[8]);
            company.setDifference(companyDetails[9]);
            companies[count] = company;
            count++;
        }
        return companies;
    }
    private static final String URL = "https://www.nepalipaisa.com/StockLive.aspx";
}

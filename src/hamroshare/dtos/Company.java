package hamroshare.dtos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sijan Bhandari
 */
@Entity
@Table(name = "companies")
public class Company implements Serializable {
    public Company(){
        
    }
    public Company(String symbol, String quantity, String openingPrice, String closingPrice, String difference,
            String latestTransactionVolume, String maxPrice, String minPrice, String noOfTransaction, String change) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.openprice = openingPrice;
        this.closingprice = closingPrice;
        this.difference = "hello";
        this.ltv = latestTransactionVolume;
        this.maxprice = maxPrice;
        this.minprice = minPrice;
        this.transaction = noOfTransaction;
        this.change = change;
    }

    public void setChangePrice(String change) {
        this.change = change;
    }

    public void setClosingprice(String closingprice) {
        this.closingprice = closingprice;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }

    public void setLtv(String ltv) {
        this.ltv = ltv;
    }

    public void setMaxprice(String maxprice) {
        this.maxprice = maxprice;
    }

    public void setMinprice(String minprice) {
        this.minprice = minprice;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public void setOpenprice(String openprice) {
        this.openprice = openprice;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    @Column(name = "change")
    public String getChangePrice() {
        return change;
    }
    @Column(name = "closingPrice")
    public String getClosingprice() {
        return closingprice;
    }
    @Column(name = "difference")
    public String getDifference() {
        return difference;
    }
    @Column(name = "ltv")
    public String getLtv() {
        return ltv;
    }
    @Column(name = "maxPrice")
    public String getMaxprice() {
        return maxprice;
    }
    @Column(name = "minPrice")
    public String getMinprice() {
        return minprice;
    }
    @Column(name = "transcation")
    public String getTransaction() {
        return transaction;
    }
    @Column(name = "openPrice")
    public String getOpenprice() {
        return openprice;
    }
    @Column(name = "quantity")
    public String getQuantity() {
        return quantity;
    }
    @Id
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "users ["
                + "Symbol=" + symbol 
                + ", change=" + change 
                + ", closingprice=" + closingprice 
                + ", ltv="+ ltv 
                + ", maxprice="+ maxprice
                + ", minprice="+ minprice
                + ", transaction="+ transaction
                + ", openprice="+ openprice
                + ", quantity="+ quantity
                + ", difference="+ difference  + "]";
    }
    private String change;
    private String closingprice;
    private String difference;
    private String ltv;
    private String maxprice;
    private String minprice;
    private String transaction;
    private String openprice;
    private String quantity;
    private String symbol;

}

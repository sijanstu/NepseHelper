package hamroshare.ui;

import com.google.firebase.FirebaseApp;
import java.io.IOException;

/**
 *
 * @author Sijan
 */
public class check {

    static FirebaseApp firebaseApp;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(calculatTax(true, 790, 5000, 5500));
    }

    static double calculatTax(boolean isSelling, int shares, double purchasePrice, double sellPrice) {
        double brokerFee;
        double sebonFee;
        double dematFee;
        double total;
        double tax = 0;
        double totalGain = shares * purchasePrice;
        if (isSelling) {
            totalGain = shares * sellPrice;
        }
        //broker fee calculation
        if (totalGain < 2500) {
            brokerFee = 10;
        } else if (totalGain <= 50000) {
            brokerFee = totalGain * (0.4 / 100);
        } else if (totalGain <= 500000) {
            brokerFee = totalGain * (0.37 / 100);
        } else if (totalGain <= 2000000) {
            brokerFee = totalGain * (0.34 / 100);
        } else if (totalGain <= 10000000) {
            brokerFee = totalGain * (0.3 / 100);
        } else {
            brokerFee = totalGain * (0.27 / 100);
        }
        //sebon fee
        sebonFee = totalGain * (0.015 / 100);

        //demat fee
        dematFee = 25;

        //total fee
        total = brokerFee + sebonFee + dematFee;

        //capital gain tax
        if (isSelling) {
            double purchasedPrice=calculatTax(!isSelling, shares, purchasePrice, sellPrice);
            double diffPrice = sellPrice - (purchasedPrice/shares);
            if (diffPrice > 0.0) {
                double perValue = (diffPrice* 0.05);
                System.out.println(perValue);
                tax = perValue * shares;
                System.out.println(diffPrice);
            }
        }

        //final amount
        System.out.println(brokerFee + " " + sebonFee + " " + dematFee);
        System.out.println("total: " + total);
        System.out.println(tax);
        double finalAmount = totalGain - total - tax;
        //keep only 2 decimal places
        finalAmount = Math.round(finalAmount * 100.0) / 100.0;
        return finalAmount;
    }
}

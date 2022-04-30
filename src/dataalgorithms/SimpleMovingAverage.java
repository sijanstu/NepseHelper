package dataalgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Sijan Bhandari
 */
public class SimpleMovingAverage {

    private final Queue<Double> window = new LinkedList<>();
    private final int period;
    private double sum;

    List prices;
    int daysInterval;

    public SimpleMovingAverage(int period) {
        this.period = period;
    }

    public void newPrice(double price) {
        sum += price;
        window.add(price);
        if (window.size() > period) {
            sum -= window.remove();
        }
    }

    public double getAverage() {
        if (window.isEmpty()) {
            return 0.0;
        }
        return sum / window.size();
    }

    public static List<Double> getMovingAverage(double[] prices, int period) {
        List<Double> averages = new ArrayList<>();
        SimpleMovingAverage ma = new SimpleMovingAverage(period);
        for (double x : prices) {
            ma.newPrice(x);
            averages.add(ma.getAverage());
        }
        return averages;
    }
}

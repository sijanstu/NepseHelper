package Model;

/**
 *
 * @author Sijan Bhandari
 */
public class Company {
    private final String Symbol;
    private final String LTP;
    private final String Closing;

    public Company(String Symbol, String LTP, String Closing) {
        this.Symbol = Symbol;
        this.LTP = LTP;
        this.Closing = Closing;
    }

    public String getSymbol() {
        return Symbol;
    }

    public String getLTP() {
        return LTP;
    }

    public String getClosing() {
        return Closing;
    }

}

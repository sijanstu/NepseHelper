package hamroshare.dtos;

/**
 *
 * @author Sijan Bhandari
 */
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class StockDto {
    private Long id;
    private String date;
    private String symbol;
    private String securityId;
    private String name;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String previousClose;
    private String fiftyTwoWeekHigh;
    private String fiftyTwoWeekLow;
    private String lastUpdatedTime;
    private String lastUpdatedPrice;
    private String totalTradedVolume;
    private String averageTradedPrice;
    private String marketCapitalization;
}
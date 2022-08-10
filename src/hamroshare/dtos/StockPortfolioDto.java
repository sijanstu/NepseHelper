package hamroshare.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Sijan Bhandari
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class StockPortfolioDto {
    private String name;
    private String total;
    private String kitta;
    private String todayGainOrLoss;
    private String totalGainOrLoss;
    private String purchasePrice;
    private String todayPrice;
}

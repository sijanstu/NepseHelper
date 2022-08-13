package hamroshare.dtos;

import com.google.gson.Gson;
import hamroshare.config.HamroFetcher;
import hamroshare.config.HamroPath;
import hamroshare.login.LoginController;
import java.io.IOException;
import java.util.List;
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
public class Portfolio {
    private String total;
    private String todayGainOrLoss;
    private String overallGainOrLoss;
    List<StockPortfolioDto> stocks;
    public static Portfolio getPortfolio() throws IOException {
        Long id=LoginController.userDto.getId();
        String url=HamroPath.ApiHome+"/user/portfolio/"+id;
        String json = HamroFetcher.getData(url);
        return new Gson().fromJson(json, Portfolio.class);
    }
}

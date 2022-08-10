package hamroshare.dtos;

import com.google.gson.Gson;
import hamroshare.login.LoginController;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.io.IOUtils;

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
        String url="https://hamroapi.sijanbhandari.com.np/user/portfolio/"+id;
        String json = IOUtils.toString(new URL(url).openStream());
        return new Gson().fromJson(json, Portfolio.class);
    }
}

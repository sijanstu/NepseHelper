package hamroshare.dtos;


import lombok.Data;

@Data
public class CompanyDto {
    private Long id;
    private String symbol;
    private String change;
    private String closingPrice;
    private String difference;
    private String ltv;
    private String maxPrice;
    private String minPrice;
    private String transaction;
    private String openPrice;
    private String quantity;
}
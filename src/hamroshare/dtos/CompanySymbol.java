package hamroshare.dtos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CompanySymbol {
    private Long id;
    private String symbol;
    private String fullName;
}
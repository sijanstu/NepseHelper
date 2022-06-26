package hamroshare.dtos;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Sijan
 */
@Data
@ToString
public class LocalUserDto implements Serializable{
    private Long id;
    private String MID;
}

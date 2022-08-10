package hamroshare.dtos;

import java.io.Serializable;
import javax.swing.ImageIcon;
import lombok.Data;

/**
 *
 * @author Sijan Bhandari
 */
@Data
public class StoreDto implements Serializable{
    UserDto user;
    ImageIcon icon;
}

package hamroshare.dtos;

/**
 *
 * @author Sijan
 */
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto implements Serializable{
    private Long id;
    private String fullName;
    private String username;
    private String password;
    private String emailID;
    private String image;
    private String imageUrl;
    private String MID;
}
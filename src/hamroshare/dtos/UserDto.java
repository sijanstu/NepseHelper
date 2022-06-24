package hamroshare.dtos;

/**
 *
 * @author Sijan
 */
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String username;
    private String password;
    private String emailID;
    private String image;
    private Status status;
}
enum Status {
    USER, ADMIN,NONE
}
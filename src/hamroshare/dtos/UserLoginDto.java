package hamroshare.dtos;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserLoginDto implements Serializable{
    private String username;
    private String password;
}

package hamroshare.dtos;

import lombok.Data;

/**
 *
 * @author Sijan Bhandari
 */
@Data
public class Note {
    private Long id;
    private Long UserId;
    private String title;
    private String Detail;
}

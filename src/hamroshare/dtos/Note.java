package hamroshare.dtos;

import lombok.Data;

/**
 *
 * @author Sijan Bhandari
 */
@Data
public class Note {
    private Long id;
    private Long userId;
    private String title;
    private String detail;
}

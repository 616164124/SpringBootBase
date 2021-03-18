package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * test
 * @author 
 */
@Data
public class Test implements Serializable {
    private Long id;

    private String name;

    private Date time;

    private static final long serialVersionUID = 1L;
}
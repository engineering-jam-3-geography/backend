package edumaps.app.domain;

import edumaps.util.GMapsFormat;
import lombok.Data;

import java.util.List;

@Data
public class Visual {

    private String id;
    private String name;
    private VisualType type;
    private List<GMapsFormat> location;
    private Boolean init;
    private Boolean hover;

}

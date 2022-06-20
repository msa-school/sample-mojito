package mojito.domain;

import java.util.Date;
import lombok.Data;
import mojito.infra.AbstractEvent;

@Data
public class AttireRecommended extends AbstractEvent {

    private Long id;
    private String location;
    private String attire;
    private String photos;
    private String key;
    private String city;
    private String weather;
}

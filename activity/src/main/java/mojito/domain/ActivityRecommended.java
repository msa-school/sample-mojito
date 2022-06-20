package mojito.domain;

import java.util.Date;
import lombok.Data;
import mojito.domain.*;
import mojito.infra.AbstractEvent;

@Data
public class ActivityRecommended extends AbstractEvent {

    private Long id;
    private String rating;
    private String photo;
    private String address;
    private String price;
    private String rating;
    private String photo;
    private String address;
    private String price;
    private String key;

    public ActivityRecommended() {
        super();
    }
    // keep

}

package mojito.domain;

import java.util.Date;
import lombok.Data;
import mojito.infra.AbstractEvent;

@Data
public class FoodRecommended extends AbstractEvent {

    private Long id;
    private String restraunt;
    private String price;
    private String address;
    private String photo;
    private String key;
    private String weather;
}

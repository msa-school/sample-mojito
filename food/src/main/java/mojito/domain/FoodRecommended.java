package mojito.domain;

import java.util.Date;
import lombok.Data;
import mojito.domain.*;
import mojito.infra.AbstractEvent;

@Data
public class FoodRecommended extends AbstractEvent {

    private Long id;
    private String restraunt;
    private Double price;
    private String address;
    private String key;

    public FoodRecommended() {
        super();
    }
    // keep

}

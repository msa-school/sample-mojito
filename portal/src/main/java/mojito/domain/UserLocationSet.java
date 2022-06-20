package mojito.domain;

import java.util.Date;
import lombok.Data;
import mojito.domain.*;
import mojito.infra.AbstractEvent;

@Data
public class UserLocationSet extends AbstractEvent {

    private String id;
    private String city;
    private String address;

    public UserLocationSet() {
        super();
    }
    // keep

}

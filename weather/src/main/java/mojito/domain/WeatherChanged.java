package mojito.domain;

import java.util.Date;
import lombok.Data;
import mojito.domain.*;
import mojito.infra.AbstractEvent;

@Data
public class WeatherChanged extends AbstractEvent {

    private Long id;
    private String weather;
    private String city;

    public WeatherChanged() {
        super();
    }
    // keep

}

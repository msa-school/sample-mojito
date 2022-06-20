package mojito.domain;

import java.util.Date;
import lombok.Data;
import mojito.infra.AbstractEvent;

@Data
public class WeatherChanged extends AbstractEvent {

    private Long id;
    private String weather;
    private String city;
}

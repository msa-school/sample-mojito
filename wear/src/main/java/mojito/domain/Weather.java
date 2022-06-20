package mojito.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;


@Embeddable
public enum Weather {
    MILD,
    COLD,
    SUNNY,
    HOT,
    RAINY,
    WINDY,
}

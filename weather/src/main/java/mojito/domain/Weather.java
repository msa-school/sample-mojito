package mojito.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mojito.WeatherApplication;
import mojito.domain.WeatherChanged;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "Weather_table")
@Data
public class Weather {

    @Id @GeneratedValue
    private Long id;

    private String weather;

    private String city;


    @PostPersist
    public void onPostPersist() {
        WeatherChanged weatherChanged = new WeatherChanged();
        BeanUtils.copyProperties(this, weatherChanged);
        weatherChanged.publishAfterCommit();
    }

    public static WeatherRepository repository() {
        WeatherRepository weatherRepository = WeatherApplication.applicationContext.getBean(
            WeatherRepository.class
        );
        return weatherRepository;
    }
    // keep

}

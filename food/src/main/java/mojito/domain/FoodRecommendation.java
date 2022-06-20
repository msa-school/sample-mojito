package mojito.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mojito.FoodApplication;
import mojito.domain.FoodRecommended;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "FoodRecommendation_table")
@Data
public class FoodRecommendation {

    @Id  @GeneratedValue
    private Long id;

    private String key;

    private String restraunt;

    private String photo;

    private Double price;

    private String weather;

    @PostPersist
    public void onPostPersist() {
        FoodRecommended foodRecommended = new FoodRecommended();
        BeanUtils.copyProperties(this, foodRecommended);
        foodRecommended.publishAfterCommit();
    }

    public static FoodRecommendationRepository repository() {
        FoodRecommendationRepository foodRecommendationRepository = FoodApplication.applicationContext.getBean(
            FoodRecommendationRepository.class
        );
        return foodRecommendationRepository;
    }
    // keep

}

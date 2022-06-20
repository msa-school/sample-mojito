package mojito.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mojito.ActivityApplication;
import mojito.domain.ActivityRecommended;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "ActivityRecommendation_table")
@Data
public class ActivityRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rating;

    private String photo;

    private String address;

    private String price;

    private String key;

    @PostPersist
    public void onPostPersist() {
        ActivityRecommended activityRecommended = new ActivityRecommended();
        BeanUtils.copyProperties(this, activityRecommended);
        activityRecommended.publishAfterCommit();
    }

    public static ActivityRecommendationRepository repository() {
        ActivityRecommendationRepository activityRecommendationRepository = ActivityApplication.applicationContext.getBean(
            ActivityRecommendationRepository.class
        );
        return activityRecommendationRepository;
    }
    // keep

}

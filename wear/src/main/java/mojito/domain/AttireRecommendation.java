package mojito.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mojito.WearApplication;
import mojito.domain.AttireRecommended;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "AttireRecommendation_table")
@Data
public class AttireRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String attire;

    @ElementCollection
    private List<Photo> photos;

    private String key;

    private String city;

    @Enumerated(EnumType.STRING)
    private Weather weather;

    @PostPersist
    public void onPostPersist() {
        AttireRecommended attireRecommended = new AttireRecommended();
        BeanUtils.copyProperties(this, attireRecommended);
        attireRecommended.publishAfterCommit();
    }

    public static AttireRecommendationRepository repository() {
        AttireRecommendationRepository attireRecommendationRepository = WearApplication.applicationContext.getBean(
            AttireRecommendationRepository.class
        );
        return attireRecommendationRepository;
    }
    // keep

}

package mojito.domain;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PersonalizedRecommendation_table")
@Data
public class PersonalizedRecommendation {

    @Id
    private String id;

    private String attireId;
    private String foodId;
    private String activityId;
    private String location;
    private String weather;
    private String key;
}

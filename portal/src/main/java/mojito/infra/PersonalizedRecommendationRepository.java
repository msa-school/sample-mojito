package mojito.infra;

import java.util.List;
import mojito.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonalizedRecommendationRepository
    extends CrudRepository<PersonalizedRecommendation, Long> {
    List<PersonalizedRecommendation> findByLocation(String location);
    List<PersonalizedRecommendation> findByKey(String key);
    // keep

}

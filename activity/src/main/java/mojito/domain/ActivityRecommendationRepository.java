package mojito.domain;

import mojito.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "activityRecommendations",
    path = "activityRecommendations"
)
public interface ActivityRecommendationRepository
    extends PagingAndSortingRepository<ActivityRecommendation, Long> {}

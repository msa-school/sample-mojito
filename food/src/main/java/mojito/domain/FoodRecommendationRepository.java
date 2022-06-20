package mojito.domain;

import mojito.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "foodRecommendations",
    path = "foodRecommendations"
)
public interface FoodRecommendationRepository
    extends PagingAndSortingRepository<FoodRecommendation, Long> {}

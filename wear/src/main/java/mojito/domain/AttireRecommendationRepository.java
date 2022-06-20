package mojito.domain;

import mojito.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "attireRecommendations",
    path = "attireRecommendations"
)
public interface AttireRecommendationRepository
    extends PagingAndSortingRepository<AttireRecommendation, Long> {}

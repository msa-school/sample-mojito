package mojito.infra;

import mojito.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class FoodRecommendationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<FoodRecommendation>> {

    @Override
    public EntityModel<FoodRecommendation> process(
        EntityModel<FoodRecommendation> model
    ) {
        return model;
    }
}

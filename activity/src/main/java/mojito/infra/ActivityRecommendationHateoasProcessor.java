package mojito.infra;

import mojito.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ActivityRecommendationHateoasProcessor
    implements
        RepresentationModelProcessor<EntityModel<ActivityRecommendation>> {

    @Override
    public EntityModel<ActivityRecommendation> process(
        EntityModel<ActivityRecommendation> model
    ) {
        return model;
    }
}

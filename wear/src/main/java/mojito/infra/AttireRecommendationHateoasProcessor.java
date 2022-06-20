package mojito.infra;

import mojito.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class AttireRecommendationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<AttireRecommendation>> {

    @Override
    public EntityModel<AttireRecommendation> process(
        EntityModel<AttireRecommendation> model
    ) {
        return model;
    }
}

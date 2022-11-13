package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Percentage;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TimeOfEffect;
@Document("promotion")
public class GlobalPromotion extends Promotion {

    GlobalPromotion(TimeOfEffect timeOfEffect, Percentage percentage) {
        super(timeOfEffect, percentage, PromotionType.GLOBAL);
    }


    GlobalPromotion(PromotionId id, TimeOfEffect timeOfEffect, Percentage percentage) {
        super(id, timeOfEffect, percentage, PromotionType.GLOBAL);
    }

    private GlobalPromotion() {
    }
}

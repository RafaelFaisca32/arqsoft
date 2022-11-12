package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Percentage;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TimeOfEffect;

public class GlobalPromotion extends Promotion {

    GlobalPromotion(TimeOfEffect timeOfEffect, Percentage percentage) {
        super(timeOfEffect, percentage,PromotionType.GLOBAL);
    }

    GlobalPromotion(PromotionId id, TimeOfEffect timeOfEffect, Percentage percentage) {
        super(id, timeOfEffect, percentage,PromotionType.GLOBAL);
    }
}

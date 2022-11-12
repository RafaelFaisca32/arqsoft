package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.EntityId;

public class PromotionId extends EntityId {

    PromotionId() {
        super();
    }

    PromotionId(String id) {
        super(id);
    }
}

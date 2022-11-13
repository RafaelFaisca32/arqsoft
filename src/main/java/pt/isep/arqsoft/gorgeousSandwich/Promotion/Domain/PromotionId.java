package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.EntityId;

public class PromotionId extends EntityId {

    PromotionId() {
        super();
    }

    public PromotionId(String id) {
        super(id);
    }
}

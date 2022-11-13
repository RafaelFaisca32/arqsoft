package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain.PromotionId;

import java.util.List;

public abstract class PromotionStrategy {

    private PromotionStrategyType type;

    public PromotionStrategy(PromotionStrategyType type) {
        this.type = type;
    }

    public PromotionStrategyType getType() {
        return type;
    }
}

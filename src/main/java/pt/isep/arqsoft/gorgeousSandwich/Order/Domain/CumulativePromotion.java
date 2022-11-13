package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain.PromotionId;

import java.util.List;

public class CumulativePromotion extends PromotionStrategy {

    private final List<PromotionId> promotions;

    public CumulativePromotion(List<PromotionId> promotions) {
        super(PromotionStrategyType.CUMULATIVE);
        this.promotions = promotions;
    }
}

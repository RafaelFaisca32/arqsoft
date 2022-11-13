package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain.PromotionId;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MostFavourablePromotion extends PromotionStrategy {

    private final PromotionId promotionId;

    public MostFavourablePromotion(PromotionId promotionId) {
        super(PromotionStrategyType.MOST_FAVOURABLE);
        this.promotionId = promotionId;
    }
}

package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain.PromotionId;

import java.util.List;

public class CreateOrderDTO {

    public final String shopId;

    public final List<ProductEntryDTO> productEntries;

    public final List<PromotionId> promotions;

    public final PromotionStrategyType promotionStrategyType;

    public CreateOrderDTO(String shopId, List<ProductEntryDTO> productEntries, List<PromotionId> promotions, PromotionStrategyType promotionStrategyType) {
        this.shopId = shopId;
        this.productEntries = productEntries;
        this.promotions = promotions;
        this.promotionStrategyType = promotionStrategyType;
    }


}

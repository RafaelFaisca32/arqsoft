package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain.PromotionId;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TotalPrice;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopId;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {

    public String id;

    public String shopId;

    public List<ProductEntryDTO> productEntries;

    public List<PromotionId> promotions;

    public PromotionStrategyType promotionStrategyType;

    public PromotionStrategy promotionStrategy;

    public double totalPrice;

    public OrderBuilder() {
        this.id = null;
        this.shopId = null;
        this.productEntries = null;
        this.promotions = null;
        this.promotionStrategyType = null;
        this.totalPrice = 0;
    }

    public OrderBuilder withShopId(String shopId) {
        this.shopId = shopId;
        return this;
    }

    public OrderBuilder withProductEntry(List<ProductEntryDTO> productEntries) {
        this.productEntries = productEntries;
        return this;
    }

    public OrderBuilder withPromotions(List<PromotionId> promotions) {
        this.promotions = promotions;
        return this;
    }

    public OrderBuilder withPromotionStrategyType(PromotionStrategyType type) {
        this.promotionStrategyType = type;
        return this;
    }

    public OrderBuilder withTotalPrice(double price) {
        this.totalPrice = price;
        return this;
    }

    public OrderBuilder withPromotionStrategy() {
        if (promotionStrategyType.name().equals(PromotionStrategyType.CUMULATIVE.name())) {
            this.promotionStrategy = new CumulativePromotion(promotions);
        }
        this.promotionStrategy = new MostFavourablePromotion(promotions.get(0));
        return this;
    }

    public Order build() throws BusinessRuleViolationException {
        List<ProductEntry> pe = new ArrayList<>();
        for (ProductEntryDTO productEntryDTO : productEntries) {
            pe.add(new ProductEntry(productEntryDTO.id, productEntryDTO.quantity));
        }
        return new Order(new ShopId(shopId), pe, promotionStrategy, new TotalPrice(totalPrice));
    }
}

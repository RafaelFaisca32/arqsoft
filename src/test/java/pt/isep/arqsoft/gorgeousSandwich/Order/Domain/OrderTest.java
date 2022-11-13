package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain.PromotionId;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.assertions.Assertions.fail;

public class OrderTest {

    private static final String ID = "orderId";

    private static final String SHOPID = "shopId";

    private static final String PROMOTIONID = "promotionId";

    private static final String SANDWICHID = "sandwichId";

    private static final int QUANTITY = 2;
    private static final int INVALID_QUANTITY = 2;

    private static final PromotionStrategyType PROMOTION_STRATEGY_TYPE = PromotionStrategyType.MOST_FAVOURABLE;

    @Test
    void businessValidation() {
        List<ProductEntry> productEntries = new ArrayList<>();
        productEntries.add(new ProductEntry(SANDWICHID, INVALID_QUANTITY));
        MostFavourablePromotion mostFavourablePromotion = new MostFavourablePromotion(new PromotionId(PROMOTIONID));
        Order o = new TestOrder(new ShopId(SHOPID), productEntries, mostFavourablePromotion);
        fail(String.format("Order accepted invalid quantity value %d", INVALID_QUANTITY));

        /**List<ProductEntry> productEntries = new ArrayList<>();
        productEntries.add(new ProductEntry(SANDWICHID, INVALID_QUANTITY));
        MostFavourablePromotion mostFavourablePromotion = new MostFavourablePromotion(new PromotionId(PROMOTIONID));
        Order o2 = new TestOrder(new ShopId(SHOPID), productEntries, mostFavourablePromotion);
        fail(String.format("Order accepted invalid quantity value %d", INVALID_QUANTITY));
         **/
    }

    private static class TestOrder extends Order {

        TestOrder(ShopId shopId, List<ProductEntry> productEntries, PromotionStrategy promotionStrategy) {
            super(shopId, productEntries, promotionStrategy);
        }

        TestOrder(OrderId id, ShopId shopId, List<ProductEntry> productEntries, PromotionStrategy promotionStrategy) {
            super(id, shopId, productEntries, promotionStrategy);
        }
    }
}

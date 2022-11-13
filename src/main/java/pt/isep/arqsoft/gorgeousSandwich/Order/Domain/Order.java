package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import lombok.SneakyThrows;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IAggregateRoot;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IEntity;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IEntityId;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TotalPrice;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopId;

import java.util.List;

@Document("order")
public class Order implements IAggregateRoot<OrderId> {
    @Id
    private OrderId id;

    private final ShopId shop;

    private List<ProductEntry> productEntries;

    private PromotionStrategy promotionStrategy;

    private TotalPrice price;

    Order(ShopId shop, List<ProductEntry> productEntries, PromotionStrategy promotionStrategy) {
        this.id = new OrderId();
        this.shop = shop;
        this.productEntries = productEntries;
        this.promotionStrategy = promotionStrategy;
        this.price = new TotalPrice();
    }

    Order(OrderId id, ShopId shop, List<ProductEntry> productEntries, PromotionStrategy promotionStrategy) {
        this.id = id;
        this.shop = shop;
        this.productEntries = productEntries;
        this.promotionStrategy = promotionStrategy;
        this.price = new TotalPrice();
    }

    private Order(OrderId id, ShopId shop, List<ProductEntry> productEntries, PromotionStrategy promotionStrategy, TotalPrice totalPrice) {
        this.id = id;
        this.shop = shop;
        this.productEntries = productEntries;
        this.promotionStrategy = promotionStrategy;
        this.price = totalPrice;
    }

    @Override
    public boolean sameAs(IEntity<? extends IEntityId> otherEntity) {
        if (otherEntity instanceof Order) {
            Order otherOrder = ((Order) otherEntity);
            return obtainId().id().equals(otherOrder.obtainId().id());
        }
        return false;
    }

    @Override
    public OrderId obtainId() {
        return id;
    }

    public OrderId getId() {
        return id;
    }

    public ShopId getShop() {
        return shop;
    }

    public List<ProductEntry> getProductEntries() {
        return productEntries;
    }

    public PromotionStrategy getPromotionStrategy() {
        return promotionStrategy;
    }

    public TotalPrice getPrice() {
        return price;
    }
}

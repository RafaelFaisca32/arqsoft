package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import org.springframework.stereotype.Component;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper implements IOrderMapper {

    @Override
    public Order CreateDTOtoDomain(CreateOrderDTO orderDTO) {
        try {
            return new OrderBuilder()
                    .withShopId(orderDTO.shopId)
                    .withProductEntry(orderDTO.productEntries)
                    .withPromotions(orderDTO.promotions)
                    .withPromotionStrategyType(orderDTO.promotionStrategyType)
                    .withPromotionStrategy()
                    .build();
        } catch (BusinessRuleViolationException e) {
            throw new RuntimeException("Cannot convert DTO to Domain!", e);
        }
    }

    @Override
    public OrderDTO toDTO(Order domain) {
        List<ProductEntryDTO> productEntryDTOs = new ArrayList<>();
        for (ProductEntry pe: domain.getProductEntries()) {
            productEntryDTOs.add(new ProductEntryDTO(pe.getSandwichId().id(), pe.getQuantity().getValue()));
        }
        return new OrderDTO(domain.getId().id(), domain.getShop().id(),
                productEntryDTOs, domain.getPrice().getTotalValue());
    }
}

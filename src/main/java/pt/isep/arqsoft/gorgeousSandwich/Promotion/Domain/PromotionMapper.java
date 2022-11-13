package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import org.springframework.stereotype.Component;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopId;

@Component
public class PromotionMapper implements IPromotionMapper {

    @Override
    public Promotion toDomain(PromotionDTO dto) {
        try {
            switch (dto.promotionType) {
                case LOCAL:
                    return new LocalPromotionBuilder().withFrom(dto.from).withTo(dto.to).withPercentage(dto.percentage)
                            .withShop(new ShopId(dto.shopId)).withId(dto.id).build();
                case GLOBAL:
                default:
                    return new GlobalPromotionBuilder().withPercentage(dto.percentage).withId(dto.id)
                            .withFrom(dto.from).withTo(dto.to).build();
            }
        } catch (BusinessRuleViolationException e) {
            throw new RuntimeException("Cannot convert DTO to Domain!", e);
        }
    }

    @Override
    public PromotionDTO toDTO(Promotion domain) {
        if (!(domain instanceof LocalPromotion)) {
            return new PromotionDTO(domain.obtainId().id(), domain.getPercentage().getPercentage(), domain.getTimeOfEffect().getFrom(), domain.getTimeOfEffect().getTo(), null, domain.getType());
        }
        ShopId shopId = ((LocalPromotion) domain).getShopId();
        return new PromotionDTO(domain.obtainId().id(), domain.getPercentage().getPercentage(), domain.getTimeOfEffect().getFrom(), domain.getTimeOfEffect().getTo(), shopId.id(), domain.getType());

    }
}

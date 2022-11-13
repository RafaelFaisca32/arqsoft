package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Percentage;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TimeOfEffect;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.ValidationException;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopId;
import pt.isep.arqsoft.gorgeousSandwich.Util.Validations;
@Document("promotion")
public class LocalPromotion extends Promotion {
    private ShopId shopId;

    LocalPromotion(TimeOfEffect timeOfEffect, Percentage percentage, ShopId shop) throws BusinessRuleViolationException {
        super(timeOfEffect, percentage, PromotionType.LOCAL);
        try {
            Validations.notNull(shop);
        } catch (ValidationException e) {
            throw new BusinessRuleViolationException("Shop id is null!", e);
        }
        Validations.notNull(shop);
        this.shopId = shop;
    }

    LocalPromotion(PromotionId shopId, TimeOfEffect timeOfEffect, Percentage percentage, ShopId shop) throws BusinessRuleViolationException {
        super(shopId, timeOfEffect, percentage, PromotionType.LOCAL);
        try {
            Validations.notNull(shop);
        } catch (ValidationException e) {
            throw new BusinessRuleViolationException("Shop id is null!", e);
        }
        Validations.notNull(shopId);
        this.shopId = shop;
    }

    private LocalPromotion(){
        super();
    }

    public ShopId getShopId() {
        return shopId;
    }


}

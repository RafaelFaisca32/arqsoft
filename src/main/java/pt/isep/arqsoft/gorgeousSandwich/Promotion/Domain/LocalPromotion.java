package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Percentage;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TimeOfEffect;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.ValidationException;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopId;
import pt.isep.arqsoft.gorgeousSandwich.Util.Validations;

public class LocalPromotion extends Promotion {
    private final ShopId shopId;

    LocalPromotion(TimeOfEffect timeOfEffect, Percentage percentage, ShopId shop) throws BusinessRuleViolationException {
        super(timeOfEffect, percentage,PromotionType.LOCAL);
        try {
            Validations.notNull(shop);
        } catch (ValidationException e) {
            throw new BusinessRuleViolationException("Shop id is null!",e);
        }
        this.shopId =shop;
    }

    LocalPromotion(PromotionId shopId, TimeOfEffect timeOfEffect, Percentage percentage, ShopId shop) throws BusinessRuleViolationException {
        super(shopId, timeOfEffect, percentage,PromotionType.GLOBAL);
        try {
            Validations.notNull(shop);
        } catch (ValidationException e) {
            throw new BusinessRuleViolationException("Shop id is null!",e);
        }
        this.shopId =shop;
    }

    public ShopId getShopId() {
        return shopId;
    }


}

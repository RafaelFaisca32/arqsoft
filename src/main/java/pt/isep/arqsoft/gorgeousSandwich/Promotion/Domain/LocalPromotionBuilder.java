package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Percentage;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TimeOfEffect;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopId;

import java.util.Date;

public class LocalPromotionBuilder {
    private String id;
    private double percentage;
    private Date from;
    private Date to;

    private ShopId shop;

    public LocalPromotionBuilder() {
        id=null;
        percentage=-1;
        from=null;
        to=null;
        this.shop=null;
    }



    public LocalPromotionBuilder withId(String id){
        this.id=id;
        return this;
    }

    public LocalPromotionBuilder withPercentage(double percentage){
        this.percentage=percentage;
        return this;
    }

    public LocalPromotionBuilder withFrom(Date from){
        this.from=from;
        return this;
    }

    public LocalPromotionBuilder withTo(Date to){
        this.to=to;
        return this;
    }

    public LocalPromotionBuilder withShop(ShopId shop){
        this.shop=shop;
        return this;
    }

    public LocalPromotion build() throws BusinessRuleViolationException {
        if (id==null){
            return new LocalPromotion(TimeOfEffect.of(from,to), Percentage.of(percentage),shop);
        }
        return new LocalPromotion(new PromotionId(id), TimeOfEffect.of(from,to), Percentage.of(percentage),shop);
    }
}

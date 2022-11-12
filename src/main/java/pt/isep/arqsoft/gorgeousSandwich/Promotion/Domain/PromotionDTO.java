package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopId;

import java.util.Date;

public class PromotionDTO {
    public String id;

    public double percentage;

    public Date from;

    public Date to;

    public ShopId shop;

    public PromotionType promotionType;


    public PromotionDTO(String id, double percentage, Date from, Date to, ShopId shop, PromotionType promotionType) {
        this.id = id;
        this.percentage = percentage;
        this.from = from;
        this.to = to;
        this.shop = shop;
        this.promotionType=promotionType;
    }
}

package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import java.util.Date;

public class PromotionDTO {
    public String id;

    public double percentage;

    public Date from;

    public Date to;

    public String shopId;

    public PromotionType promotionType;


    public PromotionDTO(String id, double percentage, Date from, Date to, String shopId, PromotionType promotionType) {
        this.id = id;
        this.percentage = percentage;
        this.from = from;
        this.to = to;
        this.shopId = shopId;
        this.promotionType=promotionType;
    }
}

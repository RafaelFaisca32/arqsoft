package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

public interface IPromotionService {

    PromotionDTO createPromotion(PromotionDTO promotion);

    Iterable<PromotionDTO> getAll();


}

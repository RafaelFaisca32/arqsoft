package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;


public interface IPromotionMapper {

    Promotion toDomain(PromotionDTO dto);

    PromotionDTO toDTO(Promotion domain);


}

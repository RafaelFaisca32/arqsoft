package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPromotionRepository extends MongoRepository<Promotion,PromotionId> {

}

package pt.isep.arqsoft.gorgeousSandwich.Shop.Domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IShopRepository extends MongoRepository<Shop, String> {

    List<Shop> findAll();


}

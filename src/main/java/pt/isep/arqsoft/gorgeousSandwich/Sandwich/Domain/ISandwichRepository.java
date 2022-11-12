package pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ISandwichRepository extends MongoRepository<Sandwich, SandwichId> {

    List<Sandwich> findAll();
}

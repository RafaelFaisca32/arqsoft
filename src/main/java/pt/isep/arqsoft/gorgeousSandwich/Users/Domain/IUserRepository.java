package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IUserRepository extends MongoRepository<User, UserId> {

    List<User> findAll();
}

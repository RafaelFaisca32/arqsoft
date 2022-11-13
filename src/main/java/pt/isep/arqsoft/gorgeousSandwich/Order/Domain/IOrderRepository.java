package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOrderRepository extends MongoRepository<Order, OrderId> {
}

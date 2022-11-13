package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

public interface IOrderService {

    OrderDTO createOrder(CreateOrderDTO order);

    Iterable<OrderDTO> getAll();
}

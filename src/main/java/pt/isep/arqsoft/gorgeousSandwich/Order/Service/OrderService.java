package pt.isep.arqsoft.gorgeousSandwich.Order.Service;

import org.springframework.stereotype.Service;
import pt.isep.arqsoft.gorgeousSandwich.Order.Domain.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final IOrderMapper mapper;

    private final IOrderRepository repository;

    public OrderService(IOrderMapper mapper, IOrderRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public OrderDTO createOrder(CreateOrderDTO dto) {
        Order order = mapper.CreateDTOtoDomain(dto);
        order = repository.save(order);
        if (order == null) {
            throw new RuntimeException("Could not save the entity to the data base!");
        }

        return mapper.toDTO(order);
    }

    @Override
    public Iterable<OrderDTO> getAll() {
        List<Order> orders = repository.findAll();
        List<OrderDTO> dtos = new ArrayList<>();
        orders.forEach(o -> dtos.add(mapper.toDTO(o)));
        return dtos;
    }
}

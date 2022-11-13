package pt.isep.arqsoft.gorgeousSandwich.Order;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pt.isep.arqsoft.gorgeousSandwich.Order.Domain.CreateOrderDTO;
import pt.isep.arqsoft.gorgeousSandwich.Order.Domain.IOrderService;
import pt.isep.arqsoft.gorgeousSandwich.Order.Domain.OrderDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final IOrderService service;

    public OrderController(IOrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@Validated @RequestBody CreateOrderDTO orderDTO) {
        //LOGGER.trace(String.format("Requesting the creation of a new order (%s)", orderDTO));
        try {
            OrderDTO dto = service.createOrder(orderDTO);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            //LOGGER.error("Could not create Order!",e);
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<OrderDTO[]> listAllOrders() {
        Iterable<OrderDTO> itr = service.getAll();
        List<OrderDTO> l = new ArrayList<>((Collection<? extends OrderDTO>) itr);
        return ResponseEntity.ok().body(l.toArray(new OrderDTO[0]));
    }
}

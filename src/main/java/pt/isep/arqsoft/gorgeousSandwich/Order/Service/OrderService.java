package pt.isep.arqsoft.gorgeousSandwich.Order.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pt.isep.arqsoft.gorgeousSandwich.Order.Domain.*;
import pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain.LocalPromotion;
import pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain.Promotion;
import pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain.PromotionType;
import pt.isep.arqsoft.gorgeousSandwich.Promotion.Service.PromotionService;
import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain.Sandwich;
import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Services.SandwichService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    private static final int MAX_PERCENTAGE = 100;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    private final IOrderMapper mapper;

    private final IOrderRepository repository;

    private final PromotionService promotionService;
    private final SandwichService sandwichService;

    public OrderService(IOrderMapper mapper, IOrderRepository repository, PromotionService promotionService, SandwichService sandwichService) {
        this.mapper = mapper;
        this.repository = repository;
        this.promotionService = promotionService;
        this.sandwichService = sandwichService;
    }

    @Override
    public OrderDTO createOrder(CreateOrderDTO dto) {
        LOGGER.debug("Creating order...");
        Order order = mapper.CreateDTOtoDomain(dto, calculateFinalTotalPrice(dto));
        LOGGER.debug("Saving order onto database...");
        LOGGER.debug(String.format("Saving order %s to database", order));
        order = repository.save(order);
        if (order == null) {
            throw new RuntimeException("Could not save the entity to the database!");
        }
        LOGGER.info("Order successfully saved onto database");
        return mapper.toDTO(order);
    }

    @Override
    public Iterable<OrderDTO> getAll() {
        LOGGER.debug("Retrieving all orders from database...");
        List<Order> orders = repository.findAll();
        LOGGER.debug("Mapping orders to DTOs...");
        List<OrderDTO> dtos = new ArrayList<>();
        orders.forEach(o -> dtos.add(mapper.toDTO(o)));
        LOGGER.info("Successfully retrieved orders from database");
        return dtos;
    }

    private double calculateFinalTotalPrice(CreateOrderDTO order) {
        double totalPrice = calculateTotalPrice(order);
        final double initialPrice = totalPrice;
        List<Optional<Promotion>> promotions = promotionService.getPromotionsByID(order.promotions);
        if (!promotions.isEmpty()) {
            for (Optional<Promotion> p : promotions) {
                if (p.isPresent() && p.get().getTimeOfEffect().getTo().after(new Date())
                        && p.get().getTimeOfEffect().getFrom().before(new Date())) {
                    if((p.get().getType().name().equals(PromotionType.GLOBAL.name())) ||
                            (p.get().getType().name().equals(PromotionType.LOCAL.name()) && order.shopId.equals(((LocalPromotion) p.get()).getShopId().id()))){
                        totalPrice -= ((p.get().getPercentage().getPercentage() / MAX_PERCENTAGE) * initialPrice);
                    }
                }
            }
        }
        return totalPrice;
    }

    private double calculateTotalPrice(CreateOrderDTO order) {
        double totalPriceWithoutPromotion = 0;
        for (ProductEntryDTO dto : order.productEntries) {
            Optional<Sandwich> sandwich = sandwichService.getSandwichByID(dto);
            if (sandwich.isPresent()) {
                totalPriceWithoutPromotion += dto.quantity * sandwich.get().getSellingPrice().getSellingPriceValue();
            }
        }

        return totalPriceWithoutPromotion;
    }
}

package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

public interface IOrderMapper {

    Order CreateDTOtoDomain(CreateOrderDTO orderDTO, double price);

    OrderDTO toDTO(Order domain);
}

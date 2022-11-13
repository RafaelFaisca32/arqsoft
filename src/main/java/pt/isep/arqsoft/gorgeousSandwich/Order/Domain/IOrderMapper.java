package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

public interface IOrderMapper {

    Order CreateDTOtoDomain(CreateOrderDTO orderDTO);

    OrderDTO toDTO(Order domain);
}

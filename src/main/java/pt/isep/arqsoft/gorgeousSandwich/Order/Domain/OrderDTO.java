package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import java.util.List;

public class OrderDTO {

    public String id;
    public String shopId;
    public List<ProductEntryDTO> productEntry;
    public double totalPrice;

    public OrderDTO(String id, String shopId, List<ProductEntryDTO> productEntry, double totalPrice) {
        this.id = id;
        this.shopId = shopId;
        this.productEntry = productEntry;
        this.totalPrice = totalPrice;
    }
}

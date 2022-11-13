package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

public class ProductEntryDTO {

    public String id;
    public int quantity;

    public ProductEntryDTO(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}

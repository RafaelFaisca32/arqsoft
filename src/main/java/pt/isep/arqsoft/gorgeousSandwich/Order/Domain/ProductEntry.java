package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain.SandwichId;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Quantity;

public class ProductEntry {

    private final SandwichId sandwichId;

    private final Quantity quantity;

    public ProductEntry(String sandwichId, int quantity) {
        this.sandwichId = new SandwichId(sandwichId);
        this.quantity = new Quantity(quantity);
    }

    public SandwichId getSandwichId() {
        return sandwichId;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}

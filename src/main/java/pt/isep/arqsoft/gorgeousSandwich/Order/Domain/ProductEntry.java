package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain.Sandwich;
import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain.SandwichId;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Quantity;

public class ProductEntry {

    private SandwichId sandwichId;

    private Quantity quantity;

    public ProductEntry(String sandwichId, int quantity) {
        this.sandwichId = new SandwichId(sandwichId);
        this.quantity = new Quantity(quantity);
    }

    private ProductEntry(SandwichId sandwichId, Quantity quantity){
        this.sandwichId=sandwichId;
        this.quantity=quantity;
    }

    private ProductEntry(){}

    public SandwichId getSandwichId() {
        return sandwichId;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}

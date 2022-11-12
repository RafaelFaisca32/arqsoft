package pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Description;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Designation;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.SellingPrice;

@Document("sandwich")
public class Sandwich {

    private SandwichId id;
    @Indexed(unique = true)
    private Designation designation;
    private SellingPrice sellingPrice;
    private Description description;

    public Sandwich(Designation designation, SellingPrice sellingPrice, Description description) {
        id = new SandwichId();
        this.designation = designation;
        this.sellingPrice = sellingPrice;
        this.description = description;
    }

    public Designation getDesignation() {
        return designation;
    }


    public SellingPrice getSellingPrice() {
        return sellingPrice;
    }

    public Description getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "id=" + id +
                ", designation=" + designation +
                ", sellingPrice=" + sellingPrice +
                ", description=" + description +
                '}';
    }
}

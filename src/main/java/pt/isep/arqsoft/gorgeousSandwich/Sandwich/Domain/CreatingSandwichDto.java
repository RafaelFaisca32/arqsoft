package pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain;

public class CreatingSandwichDto {

    public  final String designation;
    public final double sellingPrice;
    public final String description;

    public CreatingSandwichDto(String designation, double sellingPrice, String description) {
        this.designation = designation;
        this.sellingPrice = sellingPrice;
        this.description = description;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public String getDescription() {
        return description;
    }
}

package pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain;

public class SandwichDto {

    public String designation;
    public double sellingPrice;
    public String description;

    public SandwichDto(String designation, double sellingPrice, String description) {
        this.designation = designation;
        this.sellingPrice = sellingPrice;
        this.description = description;
    }
}

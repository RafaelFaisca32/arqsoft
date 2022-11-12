package pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain;

import org.springframework.stereotype.Component;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Description;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Designation;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.SellingPrice;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

@Component
public class SandwichMapper implements ISandwichMapper {

    public SandwichDto toDTO(Sandwich requestBody)
    {
        String designation = requestBody.getDesignation().getStringValue();
        double sellingPrice = requestBody.getSellingPrice().getSellingPriceValue();
        String description = requestBody.getDescription().getStringValue();
        return new SandwichDto(designation,sellingPrice,description);
    }

    public Sandwich toDomain(CreatingSandwichDto createSandwich) throws BusinessRuleViolationException {
        String designation = createSandwich.getDesignation();
        double sellingPrice = createSandwich.getSellingPrice();
        String description = createSandwich.getDescription();
        return new Sandwich(new Designation(designation), new SellingPrice(sellingPrice), new Description(description));
    }
}

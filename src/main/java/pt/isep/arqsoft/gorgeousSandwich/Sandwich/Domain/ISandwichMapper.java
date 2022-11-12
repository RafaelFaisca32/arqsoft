package pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

public interface ISandwichMapper {

    public SandwichDto toDTO(Sandwich requestBody);

    Sandwich toDomain(CreatingSandwichDto dto) throws BusinessRuleViolationException;
}

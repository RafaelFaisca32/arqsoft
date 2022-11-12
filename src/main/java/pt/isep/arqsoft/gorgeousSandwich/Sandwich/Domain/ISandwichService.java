package pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import java.util.List;

public interface ISandwichService {

    public Sandwich createSandwich(CreatingSandwichDto dto) throws BusinessRuleViolationException;
    public List<SandwichDto> getAll ();
}

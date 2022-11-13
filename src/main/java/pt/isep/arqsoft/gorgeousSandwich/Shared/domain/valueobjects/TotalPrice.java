package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.ValidationException;
import pt.isep.arqsoft.gorgeousSandwich.Util.Validations;

public class TotalPrice {

    private final double totalValue;

    public TotalPrice(){
        this.totalValue = 1;
    }

    public TotalPrice(double totalValue) throws BusinessRuleViolationException {
        try {
            Validations.notNull(totalValue);
            Validations.numberIsPositive(totalValue);
        } catch (ValidationException e) {
            throw new BusinessRuleViolationException(String.format("TotalPrice " + totalValue  + " cannot be neither null nor less than 0"));
        }
        this.totalValue = totalValue;
    }

    public double getTotalValue() {
        return totalValue;
    }
}

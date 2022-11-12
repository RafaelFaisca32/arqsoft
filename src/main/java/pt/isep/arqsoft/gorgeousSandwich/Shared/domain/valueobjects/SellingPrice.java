package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.ValidationException;
import pt.isep.arqsoft.gorgeousSandwich.Util.Validations;

public class SellingPrice {
    private final double sellingValue;


    public SellingPrice(double sellingValue) throws BusinessRuleViolationException {
        try {
            Validations.notNull(sellingValue);
            Validations.numberIsGreater(sellingValue,0);
        } catch (ValidationException e) {
            throw new BusinessRuleViolationException(String.format("SellingPrice " + sellingValue  + " cannot be neither null nor empty nor below 0"));
        }
        this.sellingValue = sellingValue;
    }

    public double getSellingPriceValue() {
        return sellingValue;
    }

}

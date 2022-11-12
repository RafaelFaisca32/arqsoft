package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.ValidationException;
import pt.isep.arqsoft.gorgeousSandwich.Util.Validations;

public class Description {
    private final String stringValue;


    public Description(String stringValue) throws BusinessRuleViolationException {
        try {
            Validations.notNull(stringValue);
            Validations.notEmpty(stringValue);
        } catch (ValidationException e) {
            throw new BusinessRuleViolationException(String.format("Description '%s' cannot be neither null nor empty", stringValue));
        }
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}

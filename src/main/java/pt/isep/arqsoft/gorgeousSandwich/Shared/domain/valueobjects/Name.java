package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IValueObject;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.Shop;
import pt.isep.arqsoft.gorgeousSandwich.Util.Validations;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.ValidationException;

public final class Name implements IValueObject {

    private final String stringValue;
    private static final Logger LOGGER = LoggerFactory.getLogger(Name.class);


    private Name(String stringValue) throws BusinessRuleViolationException {
        try {
            Validations.notNull(stringValue);
            Validations.notEmpty(stringValue);
        } catch (ValidationException e) {
            throw new BusinessRuleViolationException(String.format("Name '%s' cannot be neither null nor empty", stringValue));
        }
        this.stringValue = stringValue;
    }

    public static Name of(String name) throws BusinessRuleViolationException {
        try {
            return new Name(name);
        } catch (BusinessRuleViolationException e) {
            LOGGER.error(String.format("String %s violates Name's rules!", name),e);
            throw e;
        }
    }

    public String getStringValue() {
        return stringValue;
    }
}

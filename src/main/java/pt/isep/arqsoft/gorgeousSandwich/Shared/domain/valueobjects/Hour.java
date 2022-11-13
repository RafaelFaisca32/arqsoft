package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IValueObject;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.ValidationException;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.Shop;
import pt.isep.arqsoft.gorgeousSandwich.Util.Validations;

public final class Hour implements IValueObject {
    private final int hour;
    private static final Logger LOGGER = LoggerFactory.getLogger(Hour.class);

    public static Hour of(int hour) throws BusinessRuleViolationException {
        try {
            return new Hour(hour);
        } catch (BusinessRuleViolationException e) {
            LOGGER.error(String.format("Integer %d violates Hour's rules!", hour,e));
            throw e;
        }
    }


    private Hour(int hour) throws BusinessRuleViolationException {
        try {
            Validations.numberIsInBetween(hour,0,24);
        } catch (ValidationException exception) {
            throw new BusinessRuleViolationException(String.format("Hour must be between 0 and 24 and not %d", hour));
        }
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }


}

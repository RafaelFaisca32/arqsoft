package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IValueObject;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.ValidationException;
import pt.isep.arqsoft.gorgeousSandwich.Util.Validations;

public final class Percentage implements IValueObject {
    private final double percentage;

    private Percentage(double percentage) throws BusinessRuleViolationException {
        try {
            Validations.numberIsInBetween(percentage,0.0,100.0);
        } catch (ValidationException e) {
            throw new BusinessRuleViolationException("Could not create percentage for promotion!",e);
        }
        this.percentage = percentage;
    }


    public static Percentage of(double percentage) throws BusinessRuleViolationException {
        return new Percentage(percentage);
    }

    public double getPercentage() {
        return percentage;
    }
}

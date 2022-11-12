package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IValueObject;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Util.Validations;

import java.util.Date;

public class TimeOfEffect implements IValueObject {
    private final Date from;
    private final Date to;

    private TimeOfEffect(Date from, Date to) throws BusinessRuleViolationException {
        try {
            Validations.isTrue(from.before(to));
        } catch (Exception e) {
            throw new BusinessRuleViolationException("Date from is after to!",e);
        }
        try {
            Validations.isTrue(to.after(new Date()));
        } catch (Exception e) {
            throw new BusinessRuleViolationException("Date to is not after now!",e);
        }
        this.from = from;
        this.to = to;
    }



    public static TimeOfEffect of(Date from, Date to) throws BusinessRuleViolationException {
        return new TimeOfEffect(from,to);
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }
}

package pt.isep.arqsoft.gorgeousSandwich.Shop.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Hour;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IEntity;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IEntityId;
import pt.isep.arqsoft.gorgeousSandwich.Util.Validations;

public class DaySchedule implements IEntity<DayScheduleId> {
    private Hour closingHour;
    private Hour openingHour;

    private DayScheduleId id;

    DaySchedule(){}

    DaySchedule(Hour openingHour, Hour closingHour) throws BusinessRuleViolationException {
        try {
            Validations.numberIsGreater(closingHour.getHour(), openingHour.getHour());
            id = new DayScheduleId();
            this.closingHour = closingHour;
            this.openingHour = openingHour;
        } catch (Exception e) {
            throw new BusinessRuleViolationException(e);
        }
    }

    DaySchedule(DayScheduleId id,Hour openingHour, Hour closingHour) throws BusinessRuleViolationException {
        try {
            Validations.numberIsGreater(closingHour.getHour(), openingHour.getHour());
           this.id = id;
            this.closingHour = closingHour;
            this.openingHour = openingHour;
        } catch (Exception e) {
            throw new BusinessRuleViolationException(e);
        }
    }

    public Hour getClosingHour() {
        return closingHour;
    }

    public Hour getOpeningHour() {
        return openingHour;
    }

    @Override
    public boolean sameAs(IEntity<? extends IEntityId> otherEntity) {
        if (otherEntity instanceof DaySchedule) {
            DaySchedule otherShop = (DaySchedule) otherEntity;
            return obtainId().equals(otherShop.obtainId());
        }
        return false;
    }

    @Override
    public DayScheduleId obtainId() {
        return id;
    }
}

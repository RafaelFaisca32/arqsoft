package pt.isep.arqsoft.gorgeousSandwich.Shop.Domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Hour;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Name;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.UserId;

public class ShopBuilder {
    private final Logger LOGGER = LoggerFactory.getLogger(ShopBuilder.class);
    private String id;
    private int mondayOpening;
    private int mondayClosing;
    private int tuesdayOpening;
    private int tuesdayClosing;

    private int wednesdayOpening;
    private int wednesdayClosing;
    private int thursdayOpening;
    private int thursdayClosing;
    private int fridayOpening;
    private int fridayClosing;
    private int saturdayOpening;
    private int saturdayClosing;
    private int sundayOpening;
    private int sundayClosing;
    private String name;
    private String managerName;
    private String managerId;


    public ShopBuilder() {
        mondayOpening = -1;
        mondayClosing = -1;
        tuesdayOpening = -1;
        tuesdayClosing = -1;
        wednesdayOpening = -1;
        wednesdayClosing = -1;
        thursdayOpening = -1;
        thursdayClosing = -1;
        fridayOpening = -1;
        fridayClosing = -1;
        saturdayOpening = -1;
        saturdayClosing = -1;
        sundayOpening = -1;
        sundayClosing = -1;
        name = null;
        id = null;
        managerName = null;
        managerId = null;
    }

    public ShopBuilder withMondayOpening(int openingHour) {
        this.mondayOpening = openingHour;
        return this;
    }

    public ShopBuilder withMondayClosing(int openingHour) {
        this.mondayClosing = openingHour;
        return this;
    }

    public ShopBuilder withTuesdayOpening(int openingHour) {
        this.tuesdayOpening = openingHour;
        return this;
    }

    public ShopBuilder withTuesdayClosing(int openingHour) {
        this.tuesdayClosing = openingHour;
        return this;
    }

    public ShopBuilder withWednesdayOpening(int openingHour) {
        this.wednesdayOpening = openingHour;
        return this;
    }

    public ShopBuilder withWednesdayClosing(int openingHour) {
        this.wednesdayClosing = openingHour;
        return this;
    }

    public ShopBuilder withThursdayOpening(int openingHour) {
        this.thursdayOpening = openingHour;
        return this;
    }

    public ShopBuilder withThursdayClosing(int openingHour) {
        this.thursdayClosing = openingHour;
        return this;
    }

    public ShopBuilder withFridayOpening(int openingHour) {
        this.fridayOpening = openingHour;
        return this;
    }

    public ShopBuilder withFridayClosing(int openingHour) {
        this.fridayClosing = openingHour;
        return this;
    }

    public ShopBuilder withSaturdayOpening(int openingHour) {
        this.saturdayOpening = openingHour;
        return this;
    }

    public ShopBuilder withSaturdayClosing(int openingHour) {
        this.saturdayClosing = openingHour;
        return this;
    }

    public ShopBuilder withSundayOpening(int openingHour) {
        this.sundayOpening = openingHour;
        return this;
    }

    public ShopBuilder withSundayClosing(int openingHour) {
        this.sundayClosing = openingHour;
        return this;
    }

    public ShopBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Shop build() throws BusinessRuleViolationException {
        try {
            ShopId shopId;
            if (id==null){
                shopId=new ShopId();
            }else{
                shopId=new ShopId(id);
            }
            return new Shop(shopId, new DaySchedule(Hour.of(mondayOpening), Hour.of(mondayClosing)),
                    new DaySchedule(Hour.of(tuesdayOpening), Hour.of(tuesdayClosing)), new DaySchedule(Hour.of(wednesdayOpening),
                    Hour.of(wednesdayClosing)),
                    new DaySchedule(Hour.of(thursdayOpening), Hour.of(thursdayClosing)), new DaySchedule(Hour.of(fridayOpening),
                    Hour.of(fridayClosing)),
                    new DaySchedule(Hour.of(saturdayOpening), Hour.of(saturdayClosing)), new DaySchedule(Hour.of(sundayOpening), Hour.of(sundayClosing)), Name.of(name),
                    new Manager(Name.of(managerName), new UserId(managerId)));
        } catch (BusinessRuleViolationException e) {
            LOGGER.error("Could not build Shop", e);
            throw e;
        }
    }

    public ShopBuilder withId(String id) {
        this.id = id;
        return this;
    }


    public ShopBuilder withManagerName(String managerName) {
        this.managerName = managerName;
        return this;
    }

    public ShopBuilder withManagerId(String managerId) {
        this.managerId = managerId;
        return this;
    }
}

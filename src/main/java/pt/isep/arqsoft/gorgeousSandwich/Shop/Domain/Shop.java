package pt.isep.arqsoft.gorgeousSandwich.Shop.Domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IAggregateRoot;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IEntity;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IEntityId;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Name;

@Document("shop")
public class Shop implements IAggregateRoot<ShopId> {
    private final static Logger LOGGER = LoggerFactory.getLogger(Shop.class);
   @Id
   private ShopId id;
    private DaySchedule monday;
    private DaySchedule tuesday;
    private DaySchedule wednesday;
    private DaySchedule thursday;
    private DaySchedule friday;
    private DaySchedule saturday;
    private DaySchedule sunday;

    private Name name;

    private Manager manager;

    Shop(Name name, DaySchedule monday, DaySchedule tuesday,
         DaySchedule wednesday, DaySchedule thursday, DaySchedule friday, DaySchedule saturday, DaySchedule sunday) {
        id = new ShopId();
        this.name = name;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public Shop(ShopId id, DaySchedule monday, DaySchedule tuesday, DaySchedule wednesday, DaySchedule thursday, DaySchedule friday, DaySchedule saturday, DaySchedule sunday, Name name, Manager manager) {
        this.id = id;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.name = name;
        this.manager = manager;
    }

    private Shop() {

    }

    public ShopId getId() {
        return id;
    }

    public DaySchedule getMonday() {
        return monday;
    }

    public DaySchedule getTuesday() {
        return tuesday;
    }

    public DaySchedule getWednesday() {
        return wednesday;
    }

    public DaySchedule getThursday() {
        return thursday;
    }

    public DaySchedule getFriday() {
        return friday;
    }

    public DaySchedule getSaturday() {
        return saturday;
    }

    public DaySchedule getSunday() {
        return sunday;
    }

    public Name getName() {
        return name;
    }

    @Override
    public ShopId obtainId() {
        return id;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public boolean sameAs(IEntity<? extends IEntityId> otherEntity) {
        if (otherEntity instanceof Shop) {
            Shop otherShop = (Shop) otherEntity;
            return obtainId().equals(otherShop.obtainId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                ", saturday=" + saturday +
                ", sunday=" + sunday +
                ", name=" + name +
                '}';
    }


}

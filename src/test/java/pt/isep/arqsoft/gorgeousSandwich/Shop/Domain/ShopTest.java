package pt.isep.arqsoft.gorgeousSandwich.Shop.Domain;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Hour;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Name;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.UserId;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {


    @Test
    void constructor() {
        try {
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test Shop"), new Manager(Name.of("Test"), new UserId()));
            assertNotNull(shop);
        } catch (BusinessRuleViolationException e) {
            fail("Valid shop was created, yet test failed");

        }
        try {
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(25)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test Shop"), new Manager(Name.of("Test"), new UserId()));
            fail("Invalid shop was created,yet constructor created something, invalid hours, 25h accepted");
        } catch (BusinessRuleViolationException e) {

        }
        try {
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(-1), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test Shop"), new Manager(Name.of("Test"), new UserId()));
            fail("Invalid shop was created,yet constructor created something, invalid hours, negative accepted");
        } catch (BusinessRuleViolationException e) {
        }
        try {
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(25)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), null, new Manager(Name.of("Test"), new UserId()));
            fail("Invalid shop was created,yet constructor created something, null name");
        } catch (BusinessRuleViolationException e) {
        }
        try {
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(25)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), Name.of(""), new Manager(Name.of("Test"), new UserId()));
            fail("Invalid shop was created,yet constructor created something, empty name");
        } catch (BusinessRuleViolationException e) {
        }
        try {
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(25)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), Name.of(""), new Manager(Name.of(""), new UserId()));
            fail("Invalid shop was created,yet constructor created something, invalid manager");
        } catch (BusinessRuleViolationException e) {
        }
    }


    @Test
    void getId() {
        try {
            ShopId id = new ShopId();
            Shop shop = new Shop(id, new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"), new UserId()));
            assertNotNull(shop);
            assertEquals(id.id(), shop.obtainId().id());
            shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"), new UserId()));
            assertNotNull(shop);
            assertNotEquals(id.id(), shop.obtainId().id());
        } catch (BusinessRuleViolationException e) {
            fail("Method getId should not faill");
        }
    }

    @Test
    void getMonday() {
        try {
            DaySchedule monday = new DaySchedule(Hour.of(9), Hour.of(21));
            Shop shop = new Shop(new ShopId(), monday, new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9),
                    Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"), new UserId()));
            assertNotNull(shop);
            assertTrue(monday.getOpeningHour().getHour() == shop.getMonday().getOpeningHour().getHour() && monday.getClosingHour().getHour() == shop.getMonday().getClosingHour().getHour());
            shop = new Shop(new ShopId(), new DaySchedule(Hour.of(10), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"), new UserId()));
            assertFalse(monday.getOpeningHour().getHour() == shop.getMonday().getOpeningHour().getHour() && monday.getClosingHour().getHour() == shop.getMonday().getClosingHour().getHour());
        } catch (BusinessRuleViolationException e) {
            fail("Method getId should not faill");
        }
    }

    @Test
    void getTuesday() {
        try {
            DaySchedule teusday = new DaySchedule(Hour.of(9), Hour.of(21));
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), teusday,
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertNotNull(shop);
            assertTrue(teusday.getOpeningHour().getHour() == shop.getTuesday().getOpeningHour().getHour() && teusday.getClosingHour().getHour() == shop.getTuesday().getClosingHour().getHour());
            shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(15), Hour.of(20)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertFalse(teusday.getOpeningHour().getHour() == shop.getTuesday().getOpeningHour().getHour() && teusday.getClosingHour().getHour() == shop.getTuesday().getClosingHour().getHour());
        } catch (BusinessRuleViolationException e) {
            fail("Method getId should not faill");
        }
    }

    @Test
    void getWednesday() {
        try {
            DaySchedule hour = new DaySchedule(Hour.of(9), Hour.of(21));
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), hour, new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertNotNull(shop);
            assertTrue(hour.getOpeningHour().getHour() == shop.getWednesday().getOpeningHour().getHour() && hour.getClosingHour().getHour() == shop.getWednesday().getClosingHour().getHour());
            shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(15), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertFalse(hour.getOpeningHour().getHour() == shop.getWednesday().getOpeningHour().getHour() && hour.getClosingHour().getHour() == shop.getWednesday().getClosingHour().getHour());
        } catch (BusinessRuleViolationException e) {
            fail("Method getId should not faill");
        }
    }

    @Test
    void getThursday() {
        try {
            DaySchedule hour = new DaySchedule(Hour.of(9), Hour.of(21));
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), hour,
                    new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertNotNull(shop);
            assertTrue(hour.getOpeningHour().getHour() == shop.getThursday().getOpeningHour().getHour() && hour.getClosingHour().getHour() == shop.getThursday().getClosingHour().getHour());
            shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(15), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertFalse(hour.getOpeningHour().getHour() == shop.getThursday().getOpeningHour().getHour() && hour.getClosingHour().getHour() == shop.getThursday().getClosingHour().getHour());
        } catch (BusinessRuleViolationException e) {
            fail("Method getId should not faill");
        }
    }

    @Test
    void getFriday() {
        try {
            DaySchedule hour = new DaySchedule(Hour.of(9), Hour.of(21));
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), hour, new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertNotNull(shop);
            assertTrue(hour.getOpeningHour().getHour() == shop.getFriday().getOpeningHour().getHour() && hour.getClosingHour().getHour() == shop.getFriday().getClosingHour().getHour());
            shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(10), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertFalse(hour.getOpeningHour().getHour() == shop.getFriday().getOpeningHour().getHour() && hour.getClosingHour().getHour() == shop.getFriday().getClosingHour().getHour());
        } catch (BusinessRuleViolationException e) {
            fail("Method getId should not faill");
        }
    }

    @Test
    void getSaturday() {
        try {
            DaySchedule hour = new DaySchedule(Hour.of(9), Hour.of(21));
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    hour, new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertNotNull(shop);
            assertTrue(hour.getOpeningHour().getHour() == shop.getSaturday().getOpeningHour().getHour() && hour.getClosingHour().getHour() == shop.getSaturday().getClosingHour().getHour());
            shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(6), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertFalse(hour.getOpeningHour().getHour() == shop.getSaturday().getOpeningHour().getHour() && hour.getClosingHour().getHour() == shop.getSaturday().getClosingHour().getHour());
        } catch (BusinessRuleViolationException e) {
            fail("Method getId should not faill");
        }
    }

    @Test
    void getSunday() {
        try {
            DaySchedule hour = new DaySchedule(Hour.of(9), Hour.of(21));
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    hour, new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertNotNull(shop);
            assertTrue(hour.getOpeningHour().getHour() == shop.getSunday().getOpeningHour().getHour() && hour.getClosingHour().getHour() == shop.getSunday().getClosingHour().getHour());
            shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(10), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertFalse(hour.getOpeningHour().getHour() == shop.getSunday().getOpeningHour().getHour() && hour.getClosingHour().getHour() == shop.getSunday().getClosingHour().getHour());
        } catch (BusinessRuleViolationException e) {
            fail("Method getId should not faill");
        }
    }

    @Test
    void getName() {
        try {
            Name name = Name.of("Dummy");
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), name, new Manager(Name.of("Test"),
                    new UserId()));
            assertNotNull(shop);
            assertEquals(name.getStringValue(), shop.getName().getStringValue());
            shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(10), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertNotEquals(name.getStringValue(), shop.getName().getStringValue());
        } catch (
                BusinessRuleViolationException e) {
            fail("Method getId should not faill");
        }

    }

    @Test
    void obtainId() {
        try {
            ShopId id = new ShopId();
            Shop shop = new Shop(id, new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertNotNull(shop);
            assertEquals(id.id(), shop.obtainId().id());
            shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(10), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertNotEquals(id.id(), shop.obtainId().id());
        } catch (
                BusinessRuleViolationException e) {
            fail("Method getId should not faill");
        }
    }

    @Test
    void getManager() {
        try {
            Manager manager = new Manager(Name.of("JUnit"), new UserId());
            Shop shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), manager);
            assertNotNull(shop);
            assertTrue(manager.sameAs(shop.getManager()));
            shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(10), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertFalse(manager.sameAs(shop.getManager()));
        } catch (
                BusinessRuleViolationException e) {
            fail("Method getId should not faill");
        }
    }

    @Test
    void sameAs() {
        try {
            ShopId id = new ShopId();
            Shop real = new Shop(id, new DaySchedule(Hour.of(10), Hour.of(22)),
                    new DaySchedule(Hour.of(10), Hour.of(22)), new DaySchedule(Hour.of(10), Hour.of(22)),
                    new DaySchedule(Hour.of(10), Hour.of(22)), new DaySchedule(Hour.of(10), Hour.of(22)),
                    new DaySchedule(Hour.of(10), Hour.of(22)), new DaySchedule(Hour.of(10), Hour.of(22)), Name.of("Junit"), new Manager(Name.of("Junit"),new UserId()));
            Shop shop = new Shop(id, new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),new UserId()));
            assertNotNull(shop);
            assertTrue(real.sameAs(shop));
            shop = new Shop(new ShopId(), new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(9), Hour.of(21)), new DaySchedule(Hour.of(9), Hour.of(21)),
                    new DaySchedule(Hour.of(10), Hour.of(21)), Name.of("Test"), new Manager(Name.of("Test"),
                    new UserId()));
            assertFalse(real.sameAs(shop));
        } catch (
                BusinessRuleViolationException e) {
            fail("Method getId should not faill");
        }
    }
}
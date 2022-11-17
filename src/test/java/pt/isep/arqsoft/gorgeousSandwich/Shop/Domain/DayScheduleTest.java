package pt.isep.arqsoft.gorgeousSandwich.Shop.Domain;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Hour;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Name;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.ValidationException;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.UserId;

import static org.junit.jupiter.api.Assertions.*;

class DayScheduleTest {
    int opening = 9;
    int closing = 20;
    int invalidNegative = -10;
    int invalidPositive = 25;
    int boundaryL = 0;
    int boundaryH = 24;

    DayScheduleId id = new DayScheduleId();

    @Test
    void contructor() {

        try {
            DaySchedule ds = new DaySchedule(Hour.of(opening), Hour.of(closing));
            assertNotNull(ds);
        } catch (BusinessRuleViolationException e) {
            fail("Valid DaySchedule could not be created");
        }
        try {
            DaySchedule ds = new DaySchedule(Hour.of(closing), Hour.of(opening));
            fail("Invalid DaySchedule was created, closing hour is before opening hour");
        } catch (BusinessRuleViolationException e) {
        }
        try {
            DaySchedule ds = new DaySchedule(Hour.of(opening), Hour.of(invalidPositive));
            fail("Invalid DaySchedule was created, hours cannot be greater that 24");
        } catch (BusinessRuleViolationException e) {
        }
        try {
            DaySchedule ds = new DaySchedule(Hour.of(invalidNegative), Hour.of(closing));
            fail("Invalid DaySchedule was created, hours cannot be smaller that 0");
        } catch (BusinessRuleViolationException e) {
        }
        try {
            DaySchedule ds = new DaySchedule(Hour.of(boundaryL), Hour.of(closing));
            assertNotNull(ds);
        } catch (BusinessRuleViolationException e) {
            fail("Valid DaySchedule could not be created, boundary 0 must be allowed");
        }
        try {
            DaySchedule ds = new DaySchedule(Hour.of(opening), Hour.of(boundaryH));
            assertNotNull(ds);
        } catch (BusinessRuleViolationException e) {
            fail("Valid DaySchedule could not be created, boundary 24 must be allowed");
        }
        try {
            DaySchedule ds = new DaySchedule(Hour.of(boundaryL), Hour.of(boundaryH));
            assertNotNull(ds);
        } catch (BusinessRuleViolationException e) {
            fail("Valid DaySchedule could not be created, 24h shops must be allowed");
        }
        try {
            DaySchedule ds = new DaySchedule(id,Hour.of(boundaryL), Hour.of(boundaryH));
            assertNotNull(ds);
        } catch (BusinessRuleViolationException e) {
            fail("Valid DaySchedule could not be created, passing id as parameters");
        }
    }


    @Test
    void getClosingHour() {
        try {
            DaySchedule ds = new DaySchedule(Hour.of(opening), Hour.of(closing));
            assertNotNull(ds);
            assertEquals(closing,ds.getClosingHour().getHour());
            ds = new DaySchedule(Hour.of(opening), Hour.of(boundaryH));
            assertNotNull(ds);
            assertEquals(boundaryH,ds.getClosingHour().getHour());
        } catch (BusinessRuleViolationException e) {
            fail("Valid DaySchedule could not be created");
        }
    }

    @Test
    void getOpeningHour() {
        try {
            DaySchedule ds = new DaySchedule(Hour.of(opening), Hour.of(closing));
            assertNotNull(ds);
            assertEquals(opening,ds.getOpeningHour().getHour());
            ds = new DaySchedule(Hour.of(boundaryL), Hour.of(closing));
            assertNotNull(ds);
            assertEquals(boundaryL,ds.getOpeningHour().getHour());
        } catch (BusinessRuleViolationException e) {
            fail("Valid DaySchedule could not be created");
        }
    }

    @Test
    void sameAs() {
        try {
            DaySchedule ds = new DaySchedule(id,Hour.of(boundaryL), Hour.of(boundaryH));
            assertNotNull(ds);
            assertFalse(new DaySchedule(Hour.of(0),Hour.of(10)).sameAs(ds));
            assertTrue(new DaySchedule(id,Hour.of(0),Hour.of(10)).sameAs(ds));
        } catch (BusinessRuleViolationException e) {
            fail("Valid DaySchedule could not be created, passing id as parameters");
        }
    }

    @Test
    void obtainId() {
        try {
            DaySchedule ds = new DaySchedule(id,Hour.of(boundaryL), Hour.of(boundaryH));
            assertNotNull(ds);
            assertFalse(new DaySchedule(Hour.of(0),Hour.of(10)).sameAs(ds));
            assertTrue(new DaySchedule(id,Hour.of(0),Hour.of(10)).sameAs(ds));
            assertFalse(ds.sameAs(new Manager(Name.of("A"),new UserId(ds.obtainId().id()))));
        } catch (BusinessRuleViolationException e) {
            fail("Valid DaySchedule could not be created, passing id as parameters");
        }
    }
}
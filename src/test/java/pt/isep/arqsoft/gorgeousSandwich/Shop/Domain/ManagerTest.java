package pt.isep.arqsoft.gorgeousSandwich.Shop.Domain;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Name;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.UserId;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void constructor() {
        Manager m = null;
        try {
            m = new Manager(Name.of("Julia"), new UserId());
        } catch (BusinessRuleViolationException e) {
            fail("Valid manager was not created");
        }
        try {
            m = new Manager(Name.of(""), new UserId());
            fail("Invalid manager created, empty name");
        } catch (BusinessRuleViolationException e) {

        }
        try {
            m = new Manager(Name.of(null), new UserId());
            fail("Invalid manager created, null name");
        } catch (BusinessRuleViolationException e) {

        }
    }


    @Test
    void getName() {
        try {
            Name name = Name.of("Robert");
            Manager manager = new Manager(name, new UserId());
            assertEquals(name.getStringValue(), manager.getName().getStringValue());
            manager = new Manager(Name.of("Bruce"), new UserId());
            assertNotEquals(name.getStringValue(), manager.getName().getStringValue());
        } catch (BusinessRuleViolationException e) {
            fail("Should not have failed, all creations are valid", e);
        }

    }

    @Test
    void sameAs() {
        try {
            Name name = Name.of("Robert");
            UserId id = new UserId();
            Manager manager = new Manager(name, id);
            Manager m2 = new Manager(Name.of("Charlote"), id);
            assertTrue(manager.sameAs(m2));
            manager = new Manager(Name.of("Charlote"), new UserId());
            assertFalse(manager.sameAs(m2));
        } catch (BusinessRuleViolationException e) {
            fail("Should not have failed, all creations are valid", e);
        }
    }

    @Test
    void obtainId() {
        try {
            Name name = Name.of("Robert");
            UserId id = new UserId();
            Manager manager = new Manager(name, id);
            assertEquals(id.id(), manager.obtainId().id());
            manager = new Manager(name, new UserId());
            assertNotEquals(id.id(), manager.obtainId().id());
        } catch (BusinessRuleViolationException e) {
            fail("Should not have failed, all creations are valid", e);
        }
    }
}
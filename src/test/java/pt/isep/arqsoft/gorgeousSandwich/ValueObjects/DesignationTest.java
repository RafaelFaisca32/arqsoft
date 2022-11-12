package pt.isep.arqsoft.gorgeousSandwich.ValueObjects;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Designation;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import static com.mongodb.assertions.Assertions.assertTrue;
import static com.mongodb.assertions.Assertions.fail;

class DesignationTest {
    String invalidString = null;
    String validStringDesignation = "BigMac";


    @Test
    void businessValidation() {

        try {
            Designation p = new TestDesignation(invalidString);
            fail(String.format("Designation '%s' cannot be neither null nor empty", invalidString));
        } catch (BusinessRuleViolationException ignored) {
        }


    }


    @Test
    void getDesignationValue() {
        try {
            Designation p = new TestDesignation(validStringDesignation);
            assertTrue(p.getStringValue() == validStringDesignation);
        } catch (BusinessRuleViolationException ignored) {
        }
    }


    private static class TestDesignation extends Designation {

        TestDesignation(String des) throws BusinessRuleViolationException {
            super(des);
        }
    }


}
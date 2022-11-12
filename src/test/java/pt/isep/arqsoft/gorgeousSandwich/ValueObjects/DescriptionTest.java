package pt.isep.arqsoft.gorgeousSandwich.ValueObjects;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Description;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import static com.mongodb.assertions.Assertions.assertTrue;
import static com.mongodb.assertions.Assertions.fail;

class DescriptionTest {
    String invalidString = null;
    String validStringDescription = "two burgers ,  double of flavour";


    @Test
    void businessValidation() {

        try {
            Description p = new TestDescription(invalidString);
            fail(String.format("Description '%s' cannot be neither null nor empty", invalidString));
        } catch (BusinessRuleViolationException ignored) {
        }


    }


    @Test
    void getDescriptionValue() {
        try {
            Description p = new TestDescription(validStringDescription);
            assertTrue(p.getStringValue() == validStringDescription);
        } catch (BusinessRuleViolationException ignored) {
        }
    }


    private static class TestDescription extends Description {

        TestDescription(String des) throws BusinessRuleViolationException {
            super(des);
        }
    }


}
package pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Description;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Designation;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.SellingPrice;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import static com.mongodb.assertions.Assertions.assertTrue;
import static com.mongodb.assertions.Assertions.fail;

class SandwichTest {
    String invalidString = "";
    String validStringDesignation = "BigMac";
    String validStringDescription = "two burgers ,  double the flavour";
    double invalidDoublePrice = -10.5;
    double validDoublePrice = 10;


    @Test
    void businessValidation() {

        try {
            Sandwich p = new TestSandwich(new Designation(invalidString), new SellingPrice(validDoublePrice), new Description(validStringDescription));
            fail(String.format("Designation '%s' cannot be neither null nor empty", invalidString));
        } catch (BusinessRuleViolationException ignored) {
        }

        try {
            Sandwich p = new TestSandwich(new Designation(validStringDesignation), new SellingPrice(invalidDoublePrice), new Description(validStringDescription));
            fail(String.format("SellingPrice " + invalidDoublePrice  + " cannot be neither null nor empty nor below 0", invalidDoublePrice));
        } catch (BusinessRuleViolationException ignored) {
        }

        try {
            Sandwich p = new TestSandwich(new Designation(validStringDesignation), new SellingPrice(validDoublePrice), new Description(invalidString));
            fail(String.format("Description '%s' cannot be neither null nor empty", invalidString));
        } catch (BusinessRuleViolationException ignored) {
        }
    }


    @Test
    void getDesignation() {
        try {
            Designation de = new Designation(validStringDesignation);
            Sandwich p = new TestSandwich(de, new SellingPrice(validDoublePrice), new Description(validStringDescription));
            assertTrue(de.equals(p.getDesignation()));
        } catch (BusinessRuleViolationException e) {
            fail();
        }

    }

    @Test
    void getSellingPrice() {
        try {
            SellingPrice sp = new SellingPrice(validDoublePrice);
            Sandwich p = new TestSandwich(new Designation(validStringDesignation), sp, new Description(validStringDescription));
            assertTrue(sp.equals(p.getSellingPrice()));
        } catch (BusinessRuleViolationException e) {
            fail();
        }
    }

    @Test
    void getDescription() {
        try {
            Description de = new Description(validStringDescription);
            Sandwich p = new TestSandwich(new Designation(validStringDesignation), new SellingPrice(validDoublePrice), de);
            assertTrue(de.equals(p.getDescription()));
        } catch (BusinessRuleViolationException e) {
            fail();
        }
    }

    private static class TestSandwich extends Sandwich {

        TestSandwich(Designation designation, SellingPrice sellingPrice, Description description) {
            super(designation, sellingPrice, description);
        }


    }
}


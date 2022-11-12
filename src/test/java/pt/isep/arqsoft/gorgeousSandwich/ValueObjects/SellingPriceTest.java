package pt.isep.arqsoft.gorgeousSandwich.ValueObjects;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import static com.mongodb.assertions.Assertions.assertTrue;
import static com.mongodb.assertions.Assertions.fail;

class SellingPriceTest {
    double invalidDoublePrice = -10.5;
    double validDoublePrice = 10;

    @Test
    void businessValidation() {

        try {
            SellingPrice p = new TestSellingPrice(invalidDoublePrice);
            fail(String.format("SellingPrice " + invalidDoublePrice  + " cannot be neither null nor empty nor below 0", invalidDoublePrice));
        } catch (BusinessRuleViolationException ignored) {
        }
    }

    @Test
    void getSellingPriceValue() {
        try {
            SellingPrice p = new TestSellingPrice(validDoublePrice);
            assertTrue(p.getSellingPriceValue() == validDoublePrice);
        } catch (BusinessRuleViolationException ignored) {
        }
    }


    private static class TestSellingPrice extends SellingPrice {

        TestSellingPrice(double sel) throws BusinessRuleViolationException {
            super(sel);
        }
    }


}

package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import static org.junit.jupiter.api.Assertions.*;

class PercentageTest {
    double invalidPercentageNegative = -10.5;
    double invalidPercentagePositive = 100.65;
    double percentageBoundaryG = 100.00;
    double percentageBoundaryL = 0; // Useless promotion but must be tested

    @Test
    void of() {
        try {
            Percentage.of(invalidPercentageNegative);
            fail("Invalid percentage was created with negative numbers");
        } catch (BusinessRuleViolationException e) {
        }
        try {
            Percentage.of(invalidPercentagePositive);
            fail("Invalid percentage was created with numbers greater than 100");
        } catch (BusinessRuleViolationException e) {
        }

        try {
            Percentage.of(percentageBoundaryG);
            fail("Invalid percentage was created with 100 percentage");
        } catch (BusinessRuleViolationException e) {
        }
        try {
            Percentage.of(percentageBoundaryL);
            fail("Invalid percentage was created~with 0 percentage");
        } catch (BusinessRuleViolationException e) {
        }
        try {
            Percentage.of(10);
        } catch (BusinessRuleViolationException e) {
            fail("Valid percentage was not created");
        }
    }

    @Test
    void getPercentage() {
        try {
            Percentage p = Percentage.of(10);
            assertEquals(10,p.getPercentage());
            p = Percentage.of(25);
            assertEquals(25,p.getPercentage());
            Percentage.of(30);
            assertNotEquals(30, p.getPercentage(), 0.0);
        } catch (BusinessRuleViolationException e) {
            fail("Should not faill");
        }
    }
}
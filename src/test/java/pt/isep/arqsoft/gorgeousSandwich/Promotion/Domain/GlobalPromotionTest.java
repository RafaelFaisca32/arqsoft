package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Percentage;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TimeOfEffect;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import static com.mongodb.assertions.Assertions.assertNull;
import static com.mongodb.assertions.Assertions.fail;
import static org.junit.jupiter.api.Assertions.*;

class GlobalPromotionTest {

    Date before = new Date(new Date().getTime() - 1000000);
    Date after = new Date(new Date().getTime() + 1000000);

    Date before2 = new Date(new Date().getTime()-1000);

    double invalidPercentageNegative = -10.5;
    double invalidPercentagePositive = 100.65;
    double percentageBoundaryG = 100.00;
    double percentageBoundaryL = 0; // Useless promotion but must be tested
    
    @Test
    void validateConstructor(){
        try {
            Promotion p = new GlobalPromotion(TimeOfEffect.of(before, after), Percentage.of(invalidPercentagePositive));
            fail(String.format("Promotion accepted invalid percentage value %f", invalidPercentagePositive));
        } catch (BusinessRuleViolationException ignored) {
        }

        try {
            Promotion p = new GlobalPromotion(TimeOfEffect.of(before, after), Percentage.of(invalidPercentageNegative));
            fail(String.format("Promotion accepted invalid percentage value %f", invalidPercentageNegative));
        } catch (BusinessRuleViolationException ignored) {
        }

        try {
            Promotion p = new GlobalPromotion(TimeOfEffect.of(before, after), Percentage.of(percentageBoundaryG));
            fail(String.format("Promotion accepted when invalid percentage value %f", percentageBoundaryG));
        } catch (BusinessRuleViolationException e) {
        }

        try {
            Promotion p = new GlobalPromotion(TimeOfEffect.of(before, after), Percentage.of(percentageBoundaryL));
            fail(String.format("Promotion accepted when invalid percentage value %f", percentageBoundaryL));
        } catch (BusinessRuleViolationException e) {
        }

        try {
            Promotion p = new GlobalPromotion(TimeOfEffect.of(after, before), Percentage.of(invalidPercentageNegative));
            fail(String.format("Promotion accepted invalid range of dates: limit is after start", invalidPercentageNegative));
        } catch (BusinessRuleViolationException ignored) {
        }

        try {
            Promotion p = new GlobalPromotion(TimeOfEffect.of(before, before2), Percentage.of(invalidPercentageNegative));
            fail(String.format("Promotion accepted invalid range of dates: limit is past due", invalidPercentageNegative));
        } catch (BusinessRuleViolationException ignored) {
        }

        for (double percentage = 0.01; percentage < 100; percentage += 0.01) {
            try {
                Promotion p = new GlobalPromotion(TimeOfEffect.of(before, after), Percentage.of(percentage));
                assertSame(PromotionType.GLOBAL,p.getType());
            } catch (BusinessRuleViolationException e) {
                e.printStackTrace();
                fail(String.format("Promotion rejected when valid percentage value %f", percentage));
            }
        }
        try {
            Constructor<GlobalPromotion> constructor = GlobalPromotion.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Promotion p = constructor.newInstance();
            assertNotNull(p);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            fail("Could not build default constructor");
        }
    }


}
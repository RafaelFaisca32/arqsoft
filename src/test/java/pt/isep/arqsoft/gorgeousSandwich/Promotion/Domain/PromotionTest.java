package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Name;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Percentage;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TimeOfEffect;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.Manager;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.UserId;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.mongodb.assertions.Assertions.*;

class PromotionTest {
    Date oct20th2022 = new GregorianCalendar(2022, Calendar.OCTOBER, 20).getGregorianChange();
    Date jul13th3000 = new GregorianCalendar(3000, Calendar.JULY, 13).getGregorianChange();
    Date jan1st2022 = new GregorianCalendar(2022, Calendar.JANUARY, 1).getGregorianChange();

    Date before = new Date(new Date().getTime() - 1000000);
    Date after = new Date(new Date().getTime() + 1000000);

    double invalidPercentageNegative = -10.5;
    double invalidPercentagePositive = 100.65;
    double percentageBoundaryG = 100.00;
    double percentageBoundaryL = 0; // Useless promotion but must be tested

    @Test
    void businessValidation() {

        try {
            Promotion p = new TestPromotion(TimeOfEffect.of(jan1st2022, jul13th3000), Percentage.of(invalidPercentagePositive), PromotionType.GLOBAL);
            fail(String.format("Promotion accepted invalid percentage value %f", invalidPercentagePositive));
        } catch (BusinessRuleViolationException ignored) {
        }

        try {
            Promotion p = new TestPromotion(TimeOfEffect.of(jan1st2022, jul13th3000), Percentage.of(invalidPercentageNegative), PromotionType.GLOBAL);
            fail(String.format("Promotion accepted invalid percentage value %f", invalidPercentageNegative));
        } catch (BusinessRuleViolationException ignored) {
        }

        try {
            Promotion p = new TestPromotion(TimeOfEffect.of(jan1st2022, jul13th3000), Percentage.of(percentageBoundaryG), PromotionType.GLOBAL);
            fail(String.format("Promotion accepted when invalid percentage value %f", percentageBoundaryG));
        } catch (BusinessRuleViolationException e) {
        }

        try {
            Promotion p = new TestPromotion(TimeOfEffect.of(jan1st2022, jul13th3000), Percentage.of(percentageBoundaryL), PromotionType.GLOBAL);
            fail(String.format("Promotion accepted when invalid percentage value %f", percentageBoundaryL));
        } catch (BusinessRuleViolationException e) {
        }

        try {
            Promotion p = new TestPromotion(TimeOfEffect.of(jul13th3000, jan1st2022), Percentage.of(invalidPercentageNegative), PromotionType.GLOBAL);
            fail(String.format("Promotion accepted invalid range of dates: limit is after start", invalidPercentageNegative));
        } catch (BusinessRuleViolationException ignored) {
        }

        try {
            Promotion p = new TestPromotion(TimeOfEffect.of(jan1st2022, oct20th2022), Percentage.of(invalidPercentageNegative), PromotionType.GLOBAL);
            fail(String.format("Promotion accepted invalid range of dates: limit is past due", invalidPercentageNegative));
        } catch (BusinessRuleViolationException ignored) {
        }

        for (double percentage = 0.01; percentage < 100; percentage += 0.01) {
            try {
                Promotion p = new TestPromotion(TimeOfEffect.of(before, after), Percentage.of(percentage), PromotionType.GLOBAL);
            } catch (BusinessRuleViolationException e) {
                e.printStackTrace();
                fail(String.format("Promotion rejected when valid percentage value %f", percentage));
            }
        }
    }

    @Test
    void sameAs() {
        PromotionId id = new PromotionId();
        try {
            Promotion p = new TestPromotion(id, TimeOfEffect.of(before, after), Percentage.of(25), PromotionType.GLOBAL);
            Promotion p2 = new TestPromotion(id, TimeOfEffect.of(before, after), Percentage.of(30), PromotionType.LOCAL);
            assertTrue(p.sameAs(p2));
            p = new TestPromotion(new PromotionId(), TimeOfEffect.of(before, after), Percentage.of(25), PromotionType.GLOBAL);
            assertFalse(p.sameAs(p2));
            assertFalse(p.sameAs(new Manager(Name.of("Teste"),new UserId())));
        } catch (BusinessRuleViolationException e) {
            fail("Error while trying to compare entties: " + e.getMessage());
        }
    }

    @Test
    void obtainId() {
        PromotionId id = new PromotionId();
        try {
            Promotion p = new TestPromotion(id, TimeOfEffect.of(before, after), Percentage.of(25), PromotionType.GLOBAL);
            assertTrue(id.id().equals(p.obtainId().id()));
            p = new TestPromotion(TimeOfEffect.of(before, after), Percentage.of(25), PromotionType.GLOBAL);
            assertFalse(id.id().equals(p.obtainId().id()));
        } catch (BusinessRuleViolationException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void getTimeOfEffect() {
        try {
            TimeOfEffect te = TimeOfEffect.of(before, after);
            Promotion p = new TestPromotion(te, Percentage.of(25), PromotionType.GLOBAL);
            assertTrue(te.equals(p.getTimeOfEffect()));
        } catch (BusinessRuleViolationException e) {
            fail();
        }

    }

    @Test
    void getPercentage() {
        try {
            Percentage pe = Percentage.of(35);
            Promotion p = new TestPromotion(TimeOfEffect.of(before, after), pe, PromotionType.GLOBAL);
            assertTrue(pe.equals(p.getPercentage()));
        } catch (BusinessRuleViolationException e) {
            fail();
        }
    }

    @Test
    void getType() {
        try {
            Promotion p = new TestPromotion(TimeOfEffect.of(before, after), Percentage.of(10), PromotionType.GLOBAL);
            assertTrue(p.getType() == PromotionType.GLOBAL);
        } catch (BusinessRuleViolationException e) {
            fail();
        }
    }

    private static class TestPromotion extends Promotion {

        TestPromotion(TimeOfEffect timeOfEffect, Percentage percentage, PromotionType type) {
            super(timeOfEffect, percentage, type);
        }

        TestPromotion(PromotionId id, TimeOfEffect timeOfEffect, Percentage percentage, PromotionType type) {
            super(id, timeOfEffect, percentage, type);
        }
    }
}
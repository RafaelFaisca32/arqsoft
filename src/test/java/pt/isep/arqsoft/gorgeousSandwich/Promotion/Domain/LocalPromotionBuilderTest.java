package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopId;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LocalPromotionBuilderTest {
    Date before = new Date(new Date().getTime() - 1000000);
    Date after = new Date(new Date().getTime() + 1000000);

    Date before2 = new Date(new Date().getTime() - 1000);

    ShopId idShop = new ShopId();

    double invalidPercentageNegative = -10.5;
    double invalidPercentagePositive = 100.65;
    double percentageBoundaryG = 100.00;
    double percentageBoundaryL = 0; // Useless promotion but must be tested


    @Test
    void build() {
        LocalPromotionBuilder b = new LocalPromotionBuilder();
        try {
            LocalPromotion p = b.withFrom(before).withTo(after).withPercentage(10).withShop(idShop).build();
        } catch (BusinessRuleViolationException e) {
            fail("Valid information yet, promotion was not built correctly!");
        }

        b = new LocalPromotionBuilder();
        try {
            b.withFrom(after).withTo(before).withShop(idShop).withPercentage(10).build();
            fail("Before date is after after date yet build was successful");
        } catch (BusinessRuleViolationException e) {
        }
        b = new LocalPromotionBuilder();
        try {
            b.withFrom(before).withTo(before2).withShop(idShop).withPercentage(10).build();
            fail("After date is already due!");
        } catch (BusinessRuleViolationException e) {
        }
        b = new LocalPromotionBuilder();
        try {
            b.withFrom(after).withTo(before).withShop(null).withPercentage(10).build();
            fail("ShopId is null yet build was successful");
        } catch (BusinessRuleViolationException e) {
        }
        b = new LocalPromotionBuilder();
        try {
            b.withFrom(after).withTo(before).withShop(idShop).withPercentage(invalidPercentageNegative).build();
            fail("Percentage is invalid yet build was successful");
        } catch (BusinessRuleViolationException e) {
        }

    }
}
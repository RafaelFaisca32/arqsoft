package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopId;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GlobalPromotionBuilderTest {
    Date before = new Date(new Date().getTime() - 1000000);
    Date after = new Date(new Date().getTime() + 1000000);

    Date before2 = new Date(new Date().getTime()-1000);

    ShopId idShop = new ShopId();

    double invalidPercentageNegative = -10.5;




    @Test
    void build() {
        GlobalPromotionBuilder b = new GlobalPromotionBuilder();
        try {
            GlobalPromotion p = b.withFrom(before).withTo(after).withPercentage(10).build();
            assertNotNull(p);
        } catch (BusinessRuleViolationException e) {
            fail("Valid information yet, promotion was not built correctly!");
        }

        b=new GlobalPromotionBuilder();
        try {
            b.withFrom(after).withTo(before).withPercentage(10).build();
            fail("Before date is after after date yet build was successful");
        } catch (BusinessRuleViolationException e) {
        }
        b=new GlobalPromotionBuilder();
        try {
            b.withFrom(before).withTo(before2).withPercentage(10).build();
            fail("After date is already due!");
        } catch (BusinessRuleViolationException e) {
        }
        b=new GlobalPromotionBuilder();
        try {
            b.withFrom(after).withTo(before).withPercentage(10).build();
            fail("ShopId is null yet build was successful");
        } catch (BusinessRuleViolationException e) {
        }
        b=new GlobalPromotionBuilder();
        try {
            b.withFrom(after).withTo(before).withPercentage(invalidPercentageNegative).build();
            fail("Percentage is invalid yet build was successful");
        } catch (BusinessRuleViolationException e) {
        }

    }

}
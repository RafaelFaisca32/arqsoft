package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Percentage;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TimeOfEffect;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopId;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PromotionMapperTest {
    Date before = new Date(new Date().getTime() - 1000000);
    Date after = new Date(new Date().getTime() + 1000000);

    Promotion local;

    PromotionDTO localDTO;
    Promotion global;

    PromotionDTO globalDTO;

    ShopId shopId = new ShopId();

    @BeforeEach
    void setUp() {
        try {
            local = new LocalPromotion(TimeOfEffect.of(before, after), Percentage.of(25), shopId);
            global = new GlobalPromotion(TimeOfEffect.of(before, after), Percentage.of(25));
        } catch (BusinessRuleViolationException e) {
            throw new RuntimeException(e);
        }
        localDTO = new PromotionDTO(local.obtainId().id(), 25, before, after, shopId.id(), PromotionType.LOCAL);
        globalDTO = new PromotionDTO(global.obtainId().id(), 25, before, after, null, PromotionType.GLOBAL);
    }


    @Test
    void toDomain() {
        Promotion p = new PromotionMapper().toDomain(localDTO);
        assertEquals(before, p.getTimeOfEffect().getFrom());
        assertEquals(after, p.getTimeOfEffect().getTo());
        assertEquals(25, p.getPercentage().getPercentage());
        assertSame(PromotionType.LOCAL, p.getType());
        p = new PromotionMapper().toDomain(globalDTO);
        assertEquals(before, p.getTimeOfEffect().getFrom());
        assertEquals(after, p.getTimeOfEffect().getTo());
        assertEquals(25, p.getPercentage().getPercentage());
        assertSame(PromotionType.GLOBAL, p.getType());
        try {
            localDTO.shopId = null;
            p = new PromotionMapper().toDomain(localDTO);
            fail("Conversion to domain should have failed because id violates restrictions");
        } catch (Exception e) {
            localDTO.shopId = shopId.id();
        }
        try {
            localDTO.promotionType = PromotionType.GLOBAL;
            localDTO.id="Fail fast plz";
            localDTO.percentage=-100;
            p = new PromotionMapper().toDomain(localDTO);
            fail("Conversion to domain should have failed because id violates restrictions");
        } catch (Exception e) {
            localDTO.shopId = shopId.id();
        }
    }

    @Test
    void toDTO() {
        PromotionDTO dto = new PromotionMapper().toDTO(local);
        assertEquals(before, dto.from);
        assertEquals(after, dto.to);
        assertEquals(25, dto.percentage);
        assertEquals(shopId.id(), dto.shopId);
        assertSame(PromotionType.LOCAL, dto.promotionType);
        dto = new PromotionMapper().toDTO(global);
        assertEquals(before, dto.from);
        assertEquals(after, dto.to);
        assertEquals(25, dto.percentage);
        assertNull(dto.shopId);
        assertSame(PromotionType.GLOBAL, dto.promotionType);
    }
}
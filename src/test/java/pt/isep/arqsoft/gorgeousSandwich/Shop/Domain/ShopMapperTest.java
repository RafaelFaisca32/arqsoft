package pt.isep.arqsoft.gorgeousSandwich.Shop.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Hour;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Name;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.UserId;

import static org.junit.jupiter.api.Assertions.*;

class ShopMapperTest {
    Shop shop;
    ShopDTO dto;
    DaySchedule daySchedule;
    Name name;
    ShopId id;
    Manager manager;

    @BeforeEach
    void setUp() {
        try {
            daySchedule = new DaySchedule(Hour.of(9), Hour.of(21));
            name = Name.of("Test");
            id = new ShopId();
            manager = new Manager(Name.of("Test"), new UserId());
            shop = new Shop(id, daySchedule, daySchedule, daySchedule, daySchedule, daySchedule,
                    daySchedule, daySchedule, name, manager);

            dto = new ShopDTO(9, 21, 9, 21, 9, 21,
                    9, 21, 9, 21, 9, 21, 9,
                    21, "Test", id.id(), "Test", manager.obtainId().id());

        } catch (BusinessRuleViolationException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    void toDomain() {
        Shop s = new ShopMapper().toDomain(dto);
        assertNotNull(s);
        assertTrue(s.sameAs(shop));
        assertEquals(s.getMonday().getOpeningHour().getHour(), shop.getMonday().getOpeningHour().getHour());
        assertEquals(s.getMonday().getClosingHour().getHour(), shop.getMonday().getClosingHour().getHour());
        assertEquals(s.getName().getStringValue(), shop.getName().getStringValue());
        assertTrue(s.getManager().sameAs(shop.getManager()));
        try {
            dto.id = "l";
            Shop newShop = new ShopMapper().toDomain(dto);
            fail("Construction of invalid Shop, invalid id");
        } catch (Exception e) {

        }
        try {
            dto.managerName = "";
            Shop newShop = new ShopMapper().toDomain(dto);
            fail("Construction of invalid Shop, invalid manager");
        } catch (Exception e) {

        }
        try {
            dto.mondayClosing = 27;
            Shop newShop = new ShopMapper().toDomain(dto);
            fail("Construction of invalid Shop, invalid monday schedule");
        } catch (Exception e) {

        }
        try {
            dto.name = null;
            Shop newShop = new ShopMapper().toDomain(dto);
            fail("Construction of invalid Shop, name is null");
        } catch (Exception e) {

        }
    }

    @Test
    void toDTO() {
        ShopDTO shopDTO = new ShopMapper().toDTO(shop);
        assertNotNull(shopDTO);
        assertEquals(dto.id, shopDTO.id);
        assertEquals(dto.name, shopDTO.name);
        assertEquals(dto.managerName, shopDTO.managerName);
        assertEquals(dto.managerId, shopDTO.managerId);
        assertEquals(dto.mondayOpening, shopDTO.mondayOpening);
        assertEquals(dto.mondayClosing, shopDTO.mondayClosing);
        assertEquals(dto.tuesdayOpening, shopDTO.tuesdayOpening);
        assertEquals(dto.tuesdayClosing, shopDTO.tuesdayClosing);
        assertEquals(dto.wednesdayOpening, shopDTO.wednesdayOpening);
        assertEquals(dto.wednesdayClosing, shopDTO.wednesdayClosing);
        assertEquals(dto.thursdayOpening, shopDTO.thursdayOpening);
        assertEquals(dto.thursdayClosing, shopDTO.thursdayClosing);
        assertEquals(dto.saturdayOpening, shopDTO.saturdayOpening);
        assertEquals(dto.saturdayClosing, shopDTO.saturdayClosing);
        assertEquals(dto.sundayOpening, shopDTO.sundayOpening);
        assertEquals(dto.sundayClosing, shopDTO.sundayClosing);
    }

}
package pt.isep.arqsoft.gorgeousSandwich.Shop.Domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

@Component
public class ShopMapper implements IShopMapper {
    private final Logger LOGGER = LoggerFactory.getLogger(ShopMapper.class);

    @Override
    public Shop toDomain(ShopDTO dto) {
        ShopBuilder shopBuilder = new ShopBuilder();
        try {
            if (dto.id != null) {
                shopBuilder.withId(dto.id);
            }
            return shopBuilder.withName(dto.name).withMondayOpening(dto.mondayOpening).withMondayClosing(dto.mondayClosing).
                    withTuesdayOpening(dto.tuesdayOpening).withTuesdayClosing(dto.tuesdayClosing).withWednesdayOpening(dto.wednesdayOpening).
                    withWednesdayClosing(dto.wednesdayClosing).withThursdayOpening(dto.thursdayOpening).
                    withThursdayClosing(dto.thursdayClosing).withFridayOpening(dto.fridayOpening).withFridayClosing(dto.fridayClosing).
                    withSaturdayOpening(dto.saturdayOpening).withSaturdayClosing(dto.saturdayClosing).withSundayOpening(dto.sundayOpening).
                    withSundayClosing(dto.sundayClosing).withManagerName(dto.managerName).withManagerId(dto.managerId).build();
        } catch (BusinessRuleViolationException e) {
            LOGGER.error(String.format("Information on Shop is invalid (%s)!", dto), e);
            throw new RuntimeException("Information on Shop is invalid!", e);
        }
    }

    @Override
    public ShopDTO toDTO(Shop shop) {
        return new ShopDTO(shop.getMonday().getOpeningHour().getHour(), shop.getMonday().getClosingHour().getHour(),
                shop.getTuesday().getOpeningHour().getHour(), shop.getTuesday().getClosingHour().getHour(),
                shop.getWednesday().getOpeningHour().getHour(), shop.getWednesday().getClosingHour().getHour(),
                shop.getThursday().getOpeningHour().getHour(), shop.getThursday().getClosingHour().getHour(),
                shop.getFriday().getOpeningHour().getHour(), shop.getFriday().getClosingHour().getHour(),
                shop.getSaturday().getOpeningHour().getHour(), shop.getSaturday().getClosingHour().getHour(),
                shop.getSunday().getOpeningHour().getHour(), shop.getSunday().getClosingHour().getHour(),
                shop.getName().getStringValue(), shop.getId().id(), shop.getManager().getName().getStringValue(), shop.getManager().obtainId().id());
    }
}

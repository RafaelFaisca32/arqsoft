package pt.isep.arqsoft.gorgeousSandwich.Shop.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.*;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.IUserRepository;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.User;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.UserId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService implements IShopService {
    private final IShopMapper mapper;

    private final IShopRepository repository;

    private final IUserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopService.class);

    public ShopService(IShopMapper mapper, IShopRepository repository, IUserRepository userRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.userRepository = userRepository;
    }


    @Override
    public Iterable<ShopDTO> getAll() {
        LOGGER.debug("Retrieving all shops from database...");
        List<Shop> shops = this.repository.findAll();
        List<ShopDTO> dtos = new ArrayList<>();
        LOGGER.debug("Mapping shops to DTOs");
        shops.forEach(s -> dtos.add(mapper.toDTO(s)));
        LOGGER.info("Successfully retrieved shops from database");
        return dtos;
    }

    @Override
    public ShopDTO createShop(ShopDTO dto) {
        LOGGER.debug("Creating shop...");
        LOGGER.debug("Validating user...");
        Optional<User> user = userRepository.findById(new UserId(dto.managerId));
        if (!user.isPresent()) {
            LOGGER.error("Invalid userid");
            throw new RuntimeException(String.format("There is no User with such id (%s)!", dto.id));
        }
        LOGGER.debug("Mapping DTO to shop...");
        Shop shop = mapper.toDomain(dto);
        LOGGER.debug("Saving shop onto the database...");
        shop = repository.save(shop);
        if (shop == null) {
            LOGGER.error(String.format("Could not save the entity %s to the database!", shop), shop);
            throw new RuntimeException("Could not save the entity to the database!");
        }
        LOGGER.info("Successfully saved shop onto database");
        return mapper.toDTO(shop);
    }
}

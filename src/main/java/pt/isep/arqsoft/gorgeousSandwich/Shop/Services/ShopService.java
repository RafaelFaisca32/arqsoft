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

    private final Logger LOGGER = LoggerFactory.getLogger(ShopService.class);

    public ShopService(IShopMapper mapper, IShopRepository repository, IUserRepository userRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.userRepository = userRepository;
    }


    @Override
    public Iterable<ShopDTO> getAll() {
        List<Shop> shops = this.repository.findAll();
        List<ShopDTO> dtos = new ArrayList<>();
        shops.forEach(s -> dtos.add(mapper.toDTO(s)));
        return dtos;
    }

    @Override
    public ShopDTO createShop(ShopDTO dto) {

        Optional<User> user = userRepository.findById(new UserId(dto.managerId));
        if (!user.isPresent()) {
            throw new RuntimeException(String.format("There is no User with such id (%s)!", dto.id));
        }
        Shop shop = mapper.toDomain(dto);
        shop = repository.save(shop);
        if (shop == null) {
            LOGGER.error(String.format("Could not save the entity %s to the data base!", shop), shop);
            throw new RuntimeException("Could not save the entity to the data base!");
        }
        return mapper.toDTO(shop);
    }
}

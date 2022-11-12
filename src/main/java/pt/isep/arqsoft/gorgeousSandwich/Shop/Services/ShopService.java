package pt.isep.arqsoft.gorgeousSandwich.Shop.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.*;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.IUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService implements IShopService{
    private final IShopMapper mapper;

    private final IShopRepository repository;

    private final Logger LOGGER = LoggerFactory.getLogger(ShopService.class);

    public ShopService(IShopMapper mapper, IShopRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
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
        Shop shop = mapper.toDomain(dto);
        shop = repository.save(shop);
        if (shop==null){
            LOGGER.error("Could not save the entity %s to the data base!",shop);
            throw new RuntimeException("Could not save the entity to the data base!");
        }
        return mapper.toDTO(shop);
    }
}

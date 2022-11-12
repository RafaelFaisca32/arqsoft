package pt.isep.arqsoft.gorgeousSandwich.Shop.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopDTO;

public interface IShopService {

    Iterable<ShopDTO> getAll();

    ShopDTO createShop(ShopDTO dto);


}

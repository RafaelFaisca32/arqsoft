package pt.isep.arqsoft.gorgeousSandwich.Shop.Domain;

public interface IShopMapper {
    Shop toDomain(ShopDTO dto);
    ShopDTO toDTO(Shop shop);
}

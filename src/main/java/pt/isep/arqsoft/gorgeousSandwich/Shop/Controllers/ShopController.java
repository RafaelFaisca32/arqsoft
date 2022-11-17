package pt.isep.arqsoft.gorgeousSandwich.Shop.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.IShopService;
import pt.isep.arqsoft.gorgeousSandwich.Shop.Domain.ShopDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private final IShopService service;
    private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);

    public ShopController(IShopService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ShopDTO> createShop(@Validated @RequestBody ShopDTO shopDTO){
        LOGGER.debug(String.format("Requesting the creation of a new shop (%s)", shopDTO.toString()));
        try {
            shopDTO = service.createShop(shopDTO);
            LOGGER.info("Shop was successfully created");
            return ResponseEntity.ok().body(shopDTO);
        } catch (Exception e) {
            LOGGER.error("Could not create Shop!",e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<ShopDTO[]> listAllShops(){
        Iterable<ShopDTO> itr = service.getAll();
        List<ShopDTO> l = new ArrayList<>((Collection<? extends ShopDTO>) itr);
        LOGGER.info("Retrieving all registered shops");
        return ResponseEntity.ok().body(l.toArray(new ShopDTO[0]));
    }



}

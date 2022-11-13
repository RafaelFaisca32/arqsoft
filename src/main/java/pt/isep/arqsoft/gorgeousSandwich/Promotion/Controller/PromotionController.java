package pt.isep.arqsoft.gorgeousSandwich.Promotion.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain.IPromotionService;
import pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain.PromotionDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/promotion")
public class PromotionController {

    private final IPromotionService service;

    public PromotionController(IPromotionService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<PromotionDTO> createPromotion(@Validated @RequestBody PromotionDTO promotionDTO) {
        //LOGGER.trace(String.format("Requesting the creation of a new promotion (%s)", promotionDTO));
        try {
            promotionDTO = service.createPromotion(promotionDTO);
            return ResponseEntity.ok().body(promotionDTO);
        } catch (Exception e) {
            //LOGGER.error("Could not create Shop!",e);
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<PromotionDTO[]> listAllPromotions() {
        Iterable<PromotionDTO> itr = service.getAll();
        List<PromotionDTO> l = new ArrayList<>((Collection<? extends PromotionDTO>) itr);
        return ResponseEntity.ok().body(l.toArray(new PromotionDTO[0]));
    }
}

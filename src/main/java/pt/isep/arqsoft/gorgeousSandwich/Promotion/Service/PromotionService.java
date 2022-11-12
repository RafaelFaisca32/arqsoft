package pt.isep.arqsoft.gorgeousSandwich.Promotion.Service;

import org.springframework.stereotype.Service;
import pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionService implements IPromotionService {

    private IPromotionMapper mapper;
    private IPromotionRepository repository;

    public PromotionService(IPromotionMapper mapper, IPromotionRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public PromotionDTO createPromotion(PromotionDTO dto) {
        Promotion promotion = mapper.toDomain(dto);
        promotion = repository.save(promotion);
        if(promotion==null){
            throw new RuntimeException("Could not save the entity to the data base!");
        }

        return mapper.toDTO(promotion);
    }

    @Override
    public Iterable<PromotionDTO> getAll() {
        List<Promotion> promotions = repository.findAll();
        List<PromotionDTO> dtos = new ArrayList<>();
        promotions.forEach(p -> dtos.add(mapper.toDTO(p)));
        return dtos;
    }
}

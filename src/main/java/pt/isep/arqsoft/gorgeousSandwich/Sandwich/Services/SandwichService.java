package pt.isep.arqsoft.gorgeousSandwich.Sandwich.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pt.isep.arqsoft.gorgeousSandwich.Order.Domain.ProductEntryDTO;
import pt.isep.arqsoft.gorgeousSandwich.Promotion.Service.PromotionService;
import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain.*;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SandwichService implements ISandwichService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PromotionService.class);
    private final ISandwichRepository sandwichRepository;
    private final ISandwichMapper sandwichMapper;

    public SandwichService(ISandwichRepository sandwichRepository, ISandwichMapper sandwichMapper) {
        this.sandwichRepository = sandwichRepository;
        this.sandwichMapper = sandwichMapper;
    }

    public List<SandwichDto> getAll() {
        LOGGER.debug("Retrieving all sandwiches from database...");
        List<Sandwich> sandwichList = this.sandwichRepository.findAll();
        List<SandwichDto> sandwichDtoList = new ArrayList<>();
        LOGGER.debug("Mapping sandwiches to DTOs...");
        for (Sandwich sandwich : sandwichList) {
            sandwichDtoList.add(sandwichMapper.toDTO(sandwich));
        }
        LOGGER.info("Successfully retrieved all sandwiches from database");
        return sandwichDtoList;
    }

    public SandwichDto createSandwich(CreatingSandwichDto dto) throws BusinessRuleViolationException {
        LOGGER.debug("Creating sandwich...");
        Sandwich sandwich = this.sandwichRepository.save(sandwichMapper.toDomain(dto));
        if (sandwich == null) {
            LOGGER.error("Error saving sandwich onto database");
            throw new BusinessRuleViolationException("Could not save sandwich onto database");
        }
        LOGGER.info("Sandwich successfully saved");
        return sandwichMapper.toDTO(sandwich);
    }

    public Optional<Sandwich> getSandwichByID(ProductEntryDTO productEntryDTO) {
        return sandwichRepository.findById(new SandwichId(productEntryDTO.id));
    }
}
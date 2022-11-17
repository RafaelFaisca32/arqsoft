package pt.isep.arqsoft.gorgeousSandwich.Sandwich.Services;

import org.springframework.stereotype.Service;
import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain.*;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;


import java.util.ArrayList;
import java.util.List;

@Service
public class SandwichService implements ISandwichService {

    private final ISandwichRepository sandwichRepository;
    private final ISandwichMapper sandwichMapper;

    public SandwichService(ISandwichRepository sandwichRepository, ISandwichMapper sandwichMapper) {
        this.sandwichRepository = sandwichRepository;
        this.sandwichMapper = sandwichMapper;
    }

    public List<SandwichDto> getAll () {
        List<Sandwich> sandwichList = this.sandwichRepository.findAll();
        List<SandwichDto> sandwichDtoList = new ArrayList<>();
        for(Sandwich sandwich : sandwichList) {
            sandwichDtoList.add(sandwichMapper.toDTO(sandwich));
        }
        return sandwichDtoList;
    }

    public Sandwich createSandwich(CreatingSandwichDto dto) throws BusinessRuleViolationException {
            return this.sandwichRepository.save(sandwichMapper.toDomain(dto));
    }
}

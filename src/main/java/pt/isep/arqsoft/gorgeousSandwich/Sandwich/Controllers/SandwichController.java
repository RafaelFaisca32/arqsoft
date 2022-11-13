package pt.isep.arqsoft.gorgeousSandwich.Sandwich.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain.CreatingSandwichDto;
import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain.ISandwichService;
import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain.SandwichDto;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/sandwich")
public class SandwichController {


    private final ISandwichService sandwichService;

    Logger logger = LoggerFactory.getLogger(SandwichController.class);

    public SandwichController(ISandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    @PostMapping("/createSandwich")
    public ResponseEntity<CreatingSandwichDto> register(@Validated @RequestBody CreatingSandwichDto creatingSandwichDto) {
        try{
            this.sandwichService.createSandwich(creatingSandwichDto);
        }catch (Exception e){
        logger.error("Cannot create a sandwich with the data you inserted", e);
        return ResponseEntity.badRequest().build();
        }
        logger.info("Created the sandwich " + creatingSandwichDto.getDesignation()+ " successfly");
        return ResponseEntity.ok().body(creatingSandwichDto);
    }

    @GetMapping("/getAllSandwiches")
    public ResponseEntity<List<SandwichDto>> getAllSandwiches(){
        try {
            this.sandwichService.getAll();
        } catch (Exception e) {
            logger.error("Cannot list all sandwiches", e);
            return ResponseEntity.badRequest().build();
        }
        logger.info("All the sandwiches were listed");
        Iterable<SandwichDto> itr = this.sandwichService.getAll();
        List<SandwichDto> l = new ArrayList<>((Collection<? extends SandwichDto>) itr);
        return ResponseEntity.ok().body(l);
    }


}

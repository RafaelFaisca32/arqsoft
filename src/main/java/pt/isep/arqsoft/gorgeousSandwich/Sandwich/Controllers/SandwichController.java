package pt.isep.arqsoft.gorgeousSandwich.Sandwich.Controllers;

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

    public SandwichController(ISandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    @PostMapping("/createSandwich")
    public ResponseEntity<CreatingSandwichDto> register(@Validated @RequestBody CreatingSandwichDto creatingSandwichDto) throws BusinessRuleViolationException {
        try{
            this.sandwichService.createSandwich(creatingSandwichDto);
        }catch (Exception e){
        //TODO Log error
        e.printStackTrace();
        return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(creatingSandwichDto);
    }

    @GetMapping("/getAllSandwiches")
    public ResponseEntity<List<SandwichDto>> getAllSandwiches(){
        try {
            this.sandwichService.getAll();
        } catch (Exception e) {
            //TODO Log error
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        Iterable<SandwichDto> itr = this.sandwichService.getAll();
        List<SandwichDto> l = new ArrayList<>((Collection<? extends SandwichDto>) itr);
        return ResponseEntity.ok().body(l);
    }


}

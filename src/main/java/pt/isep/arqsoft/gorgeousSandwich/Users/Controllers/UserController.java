package pt.isep.arqsoft.gorgeousSandwich.Users.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.CreatingUserDto;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.IUserService;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.UserDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@Validated @RequestBody CreatingUserDto userDTO){
        List<UserDto> userDTOList = this.userService.getAll();
        UserDto loggedUser = this.userService.getLogin(userDTOList,userDTO);
        if(loggedUser != null) {
            return ResponseEntity.ok().body(loggedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<CreatingUserDto> register(@Validated @RequestBody CreatingUserDto userDTO)  throws BusinessRuleViolationException {
        try {
            this.userService.register(userDTO);
        }catch (Exception e) {
            //TODO Log error
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(userDTO);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllSandwiches() throws BusinessRuleViolationException {
        try {
            this.userService.getAll();
        } catch (Exception e) {
            //TODO Log error
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        Iterable<UserDto> itr = this.userService.getAll();
        List<UserDto> l = new ArrayList<>((Collection<? extends UserDto>) itr);
        return ResponseEntity.ok().body(l);
    }


}

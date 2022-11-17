package pt.isep.arqsoft.gorgeousSandwich.Users.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Controllers.SandwichController;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.CreatingUserDto;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.IUserService;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.UserDto;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@Validated @RequestBody CreatingUserDto userDTO) throws NoSuchAlgorithmException {
        List<UserDto> userDTOList = this.userService.getAll();
        UserDto loggedUser = this.userService.getLogin(userDTOList,userDTO);
        if(loggedUser != null) {
            logger.info("User logged in successfully");
            return ResponseEntity.ok().body(loggedUser);
        } else {
            logger.error("Cannot find a user with the data inserted", loggedUser.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<CreatingUserDto> register(@Validated @RequestBody CreatingUserDto userDTO) {
        try {
           CreatingUserDto dto = this.userService.register(userDTO);
            logger.info("User registered successfully");
           return ResponseEntity.ok().body(dto);
        }catch (Exception e) {
            logger.error("Cannot create a user: ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() throws NoSuchAlgorithmException {
        try {
            this.userService.getAll();
        } catch (Exception e) {
            logger.error("Cannot list all users", e);
            return ResponseEntity.badRequest().build();
        }
        logger.info("All the users were listed");
        Iterable<UserDto> itr = this.userService.getAll();
        List<UserDto> l = new ArrayList<>((Collection<? extends UserDto>) itr);
        return ResponseEntity.ok().body(l);
    }


}

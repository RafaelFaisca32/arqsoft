package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import org.springframework.stereotype.Component;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Email;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Password;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TaxIdentification;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Username;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

@Component
public class UserMapper implements IUserMapper {
    public UserDto toDTO(CreatingUserDto requestBody){
        String email = requestBody.getEmail();
        String password = requestBody.getPassword();
        String taxIdentification = requestBody.getTaxIdentification();
        String username = requestBody.getUsername();
        return new UserDto(email,password,taxIdentification,username);
    }

    public UserDto toDTO(User requestBody)
    {
        String email = requestBody.getEmail().getEmail();
        String password = requestBody.getPassword().getPassword();
        String taxIdentification = requestBody.getTaxIdentification().getTaxIdentification();
        String username = requestBody.getUsername().getUsername();
        return new UserDto(email,password,taxIdentification,username);
    }

    public User toDomain(CreatingUserDto createSandwich) throws BusinessRuleViolationException {
        String email = createSandwich.getEmail();
        String password = createSandwich.getPassword();
        String taxIdentification = createSandwich.getTaxIdentification();
        String username = createSandwich.getUsername();
        return new User(new Email(email), new Password(password), new TaxIdentification(taxIdentification), new Username(username));
    }
}

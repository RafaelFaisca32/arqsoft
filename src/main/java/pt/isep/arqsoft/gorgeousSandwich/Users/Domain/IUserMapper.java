package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface IUserMapper {
    public UserDto toDTO(CreatingUserDto requestBody);
    public UserDto toDTO(User requestBody) throws NoSuchAlgorithmException, InvalidKeySpecException;
    public User toDomain(CreatingUserDto createSandwich) throws BusinessRuleViolationException, InvalidKeySpecException, NoSuchAlgorithmException;

    CreatingUserDto toCreateUserDTO(User user) throws NoSuchAlgorithmException, InvalidKeySpecException;
}

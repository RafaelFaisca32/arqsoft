package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import java.security.NoSuchAlgorithmException;

public interface IUserMapper {
    public UserDto toDTO(CreatingUserDto requestBody) throws NoSuchAlgorithmException;
    public UserDto toDTO(User requestBody) throws NoSuchAlgorithmException;
    public User toDomain(CreatingUserDto createSandwich) throws BusinessRuleViolationException, NoSuchAlgorithmException;

    CreatingUserDto toCreateUserDTO(User user) throws NoSuchAlgorithmException;
}

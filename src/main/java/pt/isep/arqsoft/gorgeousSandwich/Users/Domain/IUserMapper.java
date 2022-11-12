package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

public interface IUserMapper {
    public UserDto toDTO(CreatingUserDto requestBody);
    public UserDto toDTO(User requestBody);
    public User toDomain(CreatingUserDto createSandwich) throws BusinessRuleViolationException;
}

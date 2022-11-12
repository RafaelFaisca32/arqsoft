package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import java.util.List;

public interface IUserService {

    public UserDto getLogin(List<UserDto> userDtoList, CreatingUserDto userDTO);
    public User register(CreatingUserDto dto) throws BusinessRuleViolationException;
    public List<UserDto> getAll ();
}

package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IUserService {

    public UserDto getLogin(List<UserDto> userDtoList, CreatingUserDto userDTO) throws NoSuchAlgorithmException;
    public CreatingUserDto register(CreatingUserDto dto) throws BusinessRuleViolationException, NoSuchAlgorithmException;
    public List<UserDto> getAll () throws NoSuchAlgorithmException;
}

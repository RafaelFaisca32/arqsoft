package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface IUserService {

    public UserDto getLogin(List<UserDto> userDtoList, CreatingUserDto userDTO);
    public CreatingUserDto register(CreatingUserDto dto) throws BusinessRuleViolationException, InvalidKeySpecException, NoSuchAlgorithmException;
    public List<UserDto> getAll () throws NoSuchAlgorithmException, InvalidKeySpecException;
}

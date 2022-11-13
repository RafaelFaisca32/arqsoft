package pt.isep.arqsoft.gorgeousSandwich.Users.Services;

import org.springframework.stereotype.Service;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IUserMapper userMapper;

    public UserService(IUserRepository userRepository, IUserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> getAll () throws NoSuchAlgorithmException, InvalidKeySpecException {
        List<User> userList = this.userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user : userList) {
            userDtoList.add(userMapper.toDTO(user));
        }
        return userDtoList;
    }

    public UserDto getLogin(List<UserDto> userDtoList, CreatingUserDto userDTO)
    {
        UserDto exists = null;
        for(UserDto user : userDtoList) {
            if(user.getUsername().equals(userDTO.getUsername()) && user.getPassword().equals(userDTO.getPassword())){
                exists = user;
            }
        }
        return exists;
    }

    public CreatingUserDto register(CreatingUserDto dto) throws BusinessRuleViolationException, InvalidKeySpecException, NoSuchAlgorithmException {
        return this.userMapper.toCreateUserDTO(this.userRepository.save(userMapper.toDomain(dto)));
    }
}

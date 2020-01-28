package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.UserDTO;
import it.danieltrosko.lsauto.mapper.UserMapper;
import it.danieltrosko.lsauto.model.entites.User;
import it.danieltrosko.lsauto.model.repositories.AddressRepository;
import it.danieltrosko.lsauto.model.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    private AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public UserDTO getUserById(Long id) {
        return UserMapper.toDTO(userRepository.getOne(id));
    }

    public void createUser(UserDTO userDTO) {
        User user = UserMapper.userToEntity(userDTO);
        addressRepository.save(user.getAddress());
        userRepository.save(user);
    }

    public void updateUser(UserDTO userDTO) {
        User user = UserMapper.userToEntity(userDTO);
        addressRepository.save(user.getAddress());
        userRepository.save(user);
    }
    public List<UserDTO> getAllUser(){
        return userRepository.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }
}

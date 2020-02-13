package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.UserDTO;
import it.danieltrosko.lsauto.mapper.UserMapper;
import it.danieltrosko.lsauto.model.entites.Authorities;
import it.danieltrosko.lsauto.model.entites.User;
import it.danieltrosko.lsauto.model.repositories.AddressRepository;
import it.danieltrosko.lsauto.model.repositories.AuthoritiesRepository;
import it.danieltrosko.lsauto.model.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    private AddressRepository addressRepository;
    private AuthoritiesRepository authoritiesRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository, AuthoritiesRepository authoritiesRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.authoritiesRepository = authoritiesRepository;
    }

    public UserDTO getUserById(Long id) {
        return UserMapper.toDTO(userRepository.getOne(id));
    }

    public void createUser(UserDTO userDTO) {
        User user = UserMapper.userToEntity(userDTO);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        addressRepository.save(user.getAddress());
        userRepository.save(user);
        authoritiesRepository.save(new Authorities(user.getEmail(), "ROLE_USER"));
    }

    public void updateUser(UserDTO userDTO) {
        User user = UserMapper.userToEntity(userDTO);
        addressRepository.save(user.getAddress());
        userRepository.save(user);
    }

    public boolean checkEmailInDB(String email) {
        return userRepository.getUserByEmail(email).isPresent();
    }

    public List<UserDTO> getAllUser() {
        return userRepository.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

}

package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.UserDTO;
import it.danieltrosko.lsauto.exception.UserNotFoundException;
import it.danieltrosko.lsauto.mapper.RepairMapper;
import it.danieltrosko.lsauto.mapper.UserMapper;
import it.danieltrosko.lsauto.model.entites.Address;
import it.danieltrosko.lsauto.model.entites.User;
import it.danieltrosko.lsauto.model.repositories.AddressRepository;
import it.danieltrosko.lsauto.model.repositories.AuthoritiesRepository;
import it.danieltrosko.lsauto.model.repositories.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    private AddressRepository addressRepository;
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, AddressRepository addressRepository, AuthoritiesRepository authoritiesRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.authoritiesRepository = authoritiesRepository;
    }

    public UserDTO getUserById(Long id) {
//        return UserMapper.toDTO(userRepository.getUserById(id).orElse(new User()));
        return UserMapper.toDTO(userRepository.getUserById(id).orElseThrow(UserNotFoundException::new));
    }

    public UserDTO getUserByEmail(String email) {
        return UserMapper.toDTO(userRepository.getUserByEmail(email)
                .orElseThrow(() -> new ObjectNotFoundException(email, "user does not exist")));
    }

    public void createUser(UserDTO userDTO) {
        User user = UserMapper.userToEntity(userDTO);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        addressRepository.save(user.getAddress());
        userRepository.save(user);
//        authoritiesRepository.save(new Authorities(user.getEmail(), "ROLE_USER"));
    }

    public void updateUser(UserDTO userDTO) {
        User user = UserMapper.userToEntity(userDTO);
        addressRepository.save(user.getAddress());
        userRepository.save(user);
    }

    public boolean checkEmailInDB(String email) {
        return userRepository.getUserByEmail(email).isPresent();
    }

    public boolean isEmailAndPasswordCorrect(String email, String password) {

        User user = userRepository.getUserByEmail(email)
                .orElseThrow(() -> new ObjectNotFoundException(email, "user does not exist"));
        return passwordEncoder.matches(password, user.getPassword());
    }

    public List<UserDTO> getUsersList(Map<String, String> parameters) {
        Address address = Address
                .builder()
                .city(parameters.get("city"))
                .postCode(parameters.get("postCode"))
                .street(parameters.get("street"))
                .build();

        User user = User
                .builder()
                .address(address)
//                .enabled(parameters.get("enabled") == null ? true&false:  Boolean.parseBoolean(parameters.get("enabled")))
                .build();

        return userRepository.findAll(Example.of(user))
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

}

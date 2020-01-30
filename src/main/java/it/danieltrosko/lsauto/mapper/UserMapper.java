package it.danieltrosko.lsauto.mapper;

import it.danieltrosko.lsauto.dto.UserDTO;
import it.danieltrosko.lsauto.model.entites.Address;
import it.danieltrosko.lsauto.model.entites.User;

public class UserMapper {

    public static User userToEntity(UserDTO userDTO) {
        Address address = new Address();
        address.setId(userDTO.getAddressId());
        address.setCity(userDTO.getCity());
        address.setHouseNumber(userDTO.getHouseNumber());
        address.setPostCode(userDTO.getPostCode());
        address.setStreet(userDTO.getStreet());

        User user = new User();
        user.setAddress(address);
        user.setEmail(userDTO.getEmail());
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setSurame(userDTO.getSurname());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());

        return user;
    }

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        Address address = user.getAddress();
        userDTO.setCity(address.getCity());
        userDTO.setHouseNumber(address.getHouseNumber());
        userDTO.setPostCode(address.getPostCode());
        userDTO.setStreet(address.getStreet());
        userDTO.setAddressId(address.getId());

        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setPassword(user.getPassword());
        userDTO.setSurname(user.getSurame());
        userDTO.setUsername(user.getUsername());
        userDTO.setPhoneNumber(user.getPhoneNumber());

        return userDTO;
    }
}

package it.danieltrosko.lsauto.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserDTO {
    private Long id;
    @Email
    private String email;
    private String username;
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String surname;
    private Long addressId;
    @NotEmpty
    private String phoneNumber;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;
}

package it.danieltrosko.lsauto.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserDTO {
    private Long id;
    @Email

    private String email;
    private String username;
    private String password;
    @NotBlank(message = "To pole nie może być puste")
    private String firstName;
    @NotBlank(message = "To pole nie może być puste")
    private String surname;
    private Long addressId;
    @NotBlank(message = "To pole nie może być puste")
    private String phoneNumber;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;
}

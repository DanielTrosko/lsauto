package it.danieltrosko.lsauto.dto;

import it.danieltrosko.lsauto.model.entites.Address;
import it.danieltrosko.lsauto.model.entites.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class CarDTO {
    private Long id;
    @NotBlank
    private String mark;
    @NotBlank
    private String model;
    @NotBlank
    private String year;
    @NotBlank
    private String plateNumber;
    @NotBlank
    private String chassisNumber;
    @NotBlank
    private String meterReading;
    private Long ownerId;
    @Email
    @NotBlank
    private String email;
    private String username;
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String surname;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    private Long addressId;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;
}

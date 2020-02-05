package it.danieltrosko.lsauto.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class CarDTO {
    private Long id;
    @NotBlank(message = "To pole nie może być puste")
    private String mark;
    @NotBlank(message = "To pole nie może być puste")
    private String model;
    @NotBlank(message = "To pole nie może być puste")
    private String year;
    @NotBlank(message = "To pole nie może być puste")
    private String plateNumber;
    @NotBlank(message = "To pole nie może być puste")
    private String chassisNumber;
    @NotBlank(message = "To pole nie może być puste")
    private String meterReading;
    private Long ownerId;
    @Email
    @NotBlank(message = "To pole nie może być puste")
    private String email;
    private String username;
    private String password;
    @NotBlank(message = "To pole nie może być puste")
    private String firstName;
    @NotBlank(message = "To pole nie może być puste")
    private String surname;
    @Column(name = "phone_number")
    @NotBlank(message = "To pole nie może być puste")
    private String phoneNumber;
    private Long addressId;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;
}

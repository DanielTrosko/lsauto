package it.danieltrosko.lsauto.dto;

import it.danieltrosko.lsauto.model.entites.Car;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class CarAcceptanceDTO {

    //car
    private Long carId;
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

    //repair

    private Long repairId;
    private String repairNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfAdmission;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataOfPickup;
    @NotBlank
    private String scopeOfWork;
    private RepairStatus status;
    private Car car;

    //user
    private Long userId;
    @NotBlank
    private String email;
    private String username;
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String surname;
    private String phoneNumber;

    //address
    private Long addressId;
    @NotBlank

    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;
}

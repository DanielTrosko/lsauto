package it.danieltrosko.lsauto.dto;

import it.danieltrosko.lsauto.model.entites.Car;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;

@Getter
@Setter
@ToString
public class CarAcceptanceDTO {

    //car
    private Long carId;

    private String mark;

    private String model;
    private String year;

    private String plateNumber;
    private String chassisNumber;

    private String meterReading;

    //repair

    private Long repairId;

    private String repairNumber;
    private LocalDate dateOfAdmission;
    private LocalDate dataOfPickup;

    private String scopeOfWork;
    private RepairStatus status;
    private Car car;

    //user
    private Long userId;

    private String email;

    private String username;

    private String password;

    private String firstName;
    private String surname;


    //address
    private Long addressId;
    private String phoneNumber;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;
}

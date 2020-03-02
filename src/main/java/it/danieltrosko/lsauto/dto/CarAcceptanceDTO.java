package it.danieltrosko.lsauto.dto;

import it.danieltrosko.lsauto.model.entites.Car;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class CarAcceptanceDTO {

    //car
    private Long carId;
    @NotBlank(message = "To pole nie może być puste")
    private String mark;
    @NotBlank(message = "To pole nie może być puste")
    private String model;
    private String engineDesignation;
    private String engineCode;
    @NotBlank(message = "To pole nie może być puste")
    private String year;
    @NotBlank(message = "To pole nie może być puste")
    private String plateNumber;
    @NotBlank(message = "To pole nie może być puste")
    private String chassisNumber;
    @NotBlank(message = "To pole nie może być puste")
    private String meterReading;

    //repair

    private Long repairId;
    private String repairNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfAdmission;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataOfPickup;
    private String scopeOfWork;
    @NotEmpty
    private String faultsReportedByCustomer;
    private String estimatedRepairPrice;
    private String finalRepairPrice;
    @Enumerated(EnumType.STRING)
    private RepairStatus status;
    private Car car;

    //user
    private Long userId;
    @NotBlank(message = "To pole nie może być puste")
    private String email;
    private String username;
    private String password;
    @NotBlank(message = "To pole nie może być puste")
    private String firstName;
    @NotBlank(message = "To pole nie może być puste")
    private String surname;
    private String phoneNumber;

    //address
    private Long addressId;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;
}

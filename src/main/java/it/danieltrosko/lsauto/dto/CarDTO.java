package it.danieltrosko.lsauto.dto;

import it.danieltrosko.lsauto.model.entites.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private String year;
    @NotBlank
    private String plateNumber;
    private String chassisNumber;
    @NotBlank
    private String meterReading;
    private User owner;

}

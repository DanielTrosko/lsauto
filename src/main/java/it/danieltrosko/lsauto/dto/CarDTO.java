package it.danieltrosko.lsauto.dto;

import it.danieltrosko.lsauto.model.entites.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class CarDTO {
    private Long id;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
    @NotBlank
    private String mark;
    @NotBlank
    private String model;
    private Integer year;
    @NotBlank
    private String plateNumber;
    private String chassisNumber;
    @NotBlank
    private String meterReading;
    @NotNull
    private User owner;

}

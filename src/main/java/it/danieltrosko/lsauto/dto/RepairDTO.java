package it.danieltrosko.lsauto.dto;

import it.danieltrosko.lsauto.model.entites.Car;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class RepairDTO {

    private Long id;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
    @NotEmpty
    private String repairNumber;
    @NotNull
    private LocalDateTime dateOfAdmission;
    private LocalDateTime dataOfPickup;
    @NotEmpty
    private String scopeOfWork;
    @NotNull
    private Car car;
}

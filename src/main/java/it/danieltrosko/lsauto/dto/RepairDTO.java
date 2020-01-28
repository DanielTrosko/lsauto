package it.danieltrosko.lsauto.dto;

import it.danieltrosko.lsauto.model.entites.Car;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
public class RepairDTO {

    private Long id;
    @NotEmpty
    private String repairNumber;
    private LocalDate dateOfAdmission;
    private LocalDate dataOfPickup;
    @NotEmpty
    private String scopeOfWork;
    private RepairStatus status;
    private Car car;
}

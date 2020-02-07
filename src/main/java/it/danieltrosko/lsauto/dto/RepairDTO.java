package it.danieltrosko.lsauto.dto;

import it.danieltrosko.lsauto.model.entites.Car;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class RepairDTO {

    private Long id;
    @NotBlank(message = "To pole nie może być puste")
    private String repairNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfAdmission;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataOfPickup;
    @NotEmpty
    private String faultsReportedByCustomer;
    private String estimatedRepairPrice;
    private String finalRepairPrice;
    @NotBlank(message = "To pole nie może być puste")
    private String scopeOfWork;
    @NotNull(message = "To pole nie może być puste")
    private RepairStatus status;
    private Car car;
}

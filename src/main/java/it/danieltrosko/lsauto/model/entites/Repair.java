package it.danieltrosko.lsauto.model.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Repair extends BaseEntity {
    @NotEmpty
    private String repairNumber;

    private LocalDate dateOfAdmission;
    private LocalDate dataOfPickup;
    @NotEmpty
    private String scopeOfWork;
    @Enumerated(EnumType.STRING)
    private RepairStatus status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;
}

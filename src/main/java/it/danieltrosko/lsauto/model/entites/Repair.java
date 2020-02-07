package it.danieltrosko.lsauto.model.entites;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Repair extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String repairNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfAdmission;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataOfPickup;
    @NotEmpty
    private String faultsReportedByCustomer;
    private String estimatedRepairPrice;
    private String finalRepairPrice;
    @NotEmpty
    private String scopeOfWork;
    @Enumerated(EnumType.STRING)
    private RepairStatus status;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;


    @PostPersist
    private void repairNumber() {
        this.setRepairNumber(LocalDate.now().getYear() + "/" + LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() + "/" + this.getId().toString());
    }
}

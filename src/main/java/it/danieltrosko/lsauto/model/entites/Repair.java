package it.danieltrosko.lsauto.model.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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
    private String scopeOfWork;
    @Enumerated(EnumType.STRING)
    private RepairStatus status;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;


    @PostPersist
    private void repairNumber() {
        this.setRepairNumber(LocalDate.now().getYear() + "/" + LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() + "/" + this.getId().toString());
    }
}

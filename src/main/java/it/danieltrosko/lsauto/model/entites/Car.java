package it.danieltrosko.lsauto.model.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car extends BaseEntity {
    @Column(nullable = false)
    private String mark;
    @Column(nullable = false)
    private String model;
    @Column
    private String engineDesignation;
    @Column
    private String engineCode;
    @Column(nullable = false)
    private String year;
    @Column(nullable = false)
    private String plateNumber;
    @Column(nullable = false)
    private String chassisNumber;
    @Column(nullable = false)
    private String meterReading;
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "car")
    private List<Repair> repairList;

}

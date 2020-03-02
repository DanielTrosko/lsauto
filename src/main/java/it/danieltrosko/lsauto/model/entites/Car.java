package it.danieltrosko.lsauto.model.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;
    @OneToMany(mappedBy = "car")
    private List<Repair> repairList;

}

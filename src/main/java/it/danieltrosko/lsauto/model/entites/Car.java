package it.danieltrosko.lsauto.model.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Car extends BaseEntity {
    private String mark;
    private String model;
    private Integer year;
    private String plateNumber;
    private String chassisNumber;
    private String meterReading;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

}

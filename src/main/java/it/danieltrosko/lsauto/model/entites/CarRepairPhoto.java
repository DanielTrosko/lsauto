package it.danieltrosko.lsauto.model.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CarRepairPhoto extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repair_id")
    private Repair repair;
    @Column(name = "photo_one", columnDefinition = "LONGBLOB")
    private byte[] photo;

}

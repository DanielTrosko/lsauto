package it.danieltrosko.lsauto.model.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Product extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String partNumber;
    private String oemNumber;
    private Integer amount;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String brand;

}

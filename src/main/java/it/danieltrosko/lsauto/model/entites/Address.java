package it.danieltrosko.lsauto.model.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Address extends BaseEntity {
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;

}

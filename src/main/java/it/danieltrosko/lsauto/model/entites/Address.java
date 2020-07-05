package it.danieltrosko.lsauto.model.entites;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address extends BaseEntity {
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;

}

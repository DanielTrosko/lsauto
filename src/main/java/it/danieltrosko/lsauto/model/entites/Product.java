package it.danieltrosko.lsauto.model.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class Product extends BaseEntity{
    @NotEmpty
    private String name;
    @NotEmpty
    private String partNumber;
    private Integer amount;
    private String location;
    @NotEmpty
    private String brand;

}

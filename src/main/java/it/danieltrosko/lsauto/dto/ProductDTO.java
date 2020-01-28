package it.danieltrosko.lsauto.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String partNumber;
    private Integer amount;
    private String location;
    @NotEmpty
    private String brand;
}

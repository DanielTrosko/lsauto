package it.danieltrosko.lsauto.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String partNumber;
    private String oemNumber;
    private Integer amount;
    @NotBlank
    private String location;
    @NotBlank
    private String brand;
}

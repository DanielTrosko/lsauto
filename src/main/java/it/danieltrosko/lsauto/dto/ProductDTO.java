package it.danieltrosko.lsauto.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    @NotBlank(message = "To pole nie może być puste")
    private String name;
    @NotBlank(message = "To pole nie może być puste")
    private String partNumber;
    private String oemNumber;
    private Integer amount;
    @NotBlank(message = "To pole nie może być puste")
    private String location;
    @NotBlank(message = "To pole nie może być puste")
    private String brand;
}

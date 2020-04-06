package it.danieltrosko.lsauto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRepairPhotoDTO {
    private Long id;
    private Long repair;
    private byte[] photo;

}

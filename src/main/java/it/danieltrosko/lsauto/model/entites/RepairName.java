package it.danieltrosko.lsauto.model.entites;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class RepairName extends BaseEntity {
    private String name;
    private Integer amount;
    private BigDecimal price;
}

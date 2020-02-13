package it.danieltrosko.lsauto.model.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Authorities extends BaseEntity {

    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "authority", nullable = false)
    private String authority;
}

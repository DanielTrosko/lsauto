package it.danieltrosko.lsauto.model.entites;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
public class User extends BaseEntity {

//    @Email
    @Column(nullable = false)
    private String email;
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String surame;
    @Column(name = "phone_number")
    private String phoneNumber;
    @NotNull
    private boolean enabled;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_address_id", nullable = false)
    private Address address;


}

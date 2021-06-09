package com.javaSchool.eCare.model.entity;

import com.javaSchool.eCare.model.entity.enums.Role;
import com.javaSchool.eCare.model.entity.enums.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private int idUser;

    @Column(name = "surname", nullable = false)
    @Size(min = 1, max = 45)
    private String surname;

    @Column(name = "name", nullable = false)
    @Size(min = 1, max = 45)
    private String name;

    @Column(name = "birth", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @Column(name = "passport", nullable = false)
    @Size(min = 1, max = 45)
    private String passport;

    @Column(name = "address", nullable = false)
    @Size(min = 1, max = 45)
    private String address;

//    @Column(name = "contract_id", nullable = false)
//    private String contractNumber;

    @Column(name = "email", unique = true)
    @Size(min = 1, max = 45)
    private String email;

    @Column(name = "password")
    @Size(min = 1, max = 145)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    @Basic
    private Status status;


    @OneToMany(mappedBy = "userEntity")
    private Set<Contract> contract = new HashSet<Contract>();
}

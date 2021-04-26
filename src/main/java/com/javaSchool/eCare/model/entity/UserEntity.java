package com.javaSchool.eCare.model.entity;

import com.javaSchool.eCare.model.entity.enums.Group;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
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
    @Basic
    @Size(min = 1, max = 45)
    private String name;

    @Column(name = "birth", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @Column(name = "passport", nullable = false)
    @Size(min = 1, max = 45)
    private String passport;

    @Column(name = "adress", nullable = false)
    @Size(min = 1, max = 45)
    private String adress;

    @Column(name = "contract_id", nullable = false)
    private String contract_id;

    @Column(name = "email", unique = true)
    @Size(min = 1, max = 45)
    private String email;

    @Column(name = "password")
    @Size(min = 1, max = 45)
    private String password;

    @Column(name = "group")
    @Enumerated(EnumType.STRING)
    private Group group;

    @Column(name = "is_blocked", columnDefinition = "boolean default false")
    private boolean is_blocked;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Contract> contract;


}

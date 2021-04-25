package com.javaSchool.eCare.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "contract")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

public class Contract{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContract")
    private int idContract;

    @Column(name = "number")
    @Size(min = 1, max = 45)
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User User;

    @ManyToOne
    @JoinColumn(name = "tariff_id", nullable = false)
    private Tariff tariff;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Contract_AllOptions",
            joinColumns = @JoinColumn(name = "idContract"),
            inverseJoinColumns = @JoinColumn(name = "idOption")
    )
    private Set<Option> options;
}

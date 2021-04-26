package com.javaSchool.eCare.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tariff")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTariff")
    private int idTariff;

    @Column(name = "title", nullable = false)
    @Size(min = 1, max = 45)
    private String title;

    @Column(name = "price", nullable = false)
    private double price;

    @OneToMany(mappedBy = "tariff", cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Tariff_Option",
            joinColumns = @JoinColumn(name = "idOption"),
            inverseJoinColumns = @JoinColumn(name = "idTariff")
    )
    private Set<Option> options;

}

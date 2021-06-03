package com.javaSchool.eCare.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tariff")
@Getter
@Setter
@NoArgsConstructor
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

    @Column(name = "is_deprecated")
    private boolean deprecated;

//    @OneToMany(mappedBy = "tariff", cascade = CascadeType.ALL)
//    private Set<Contract> contracts;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tariffs")
    private Set<Option> options = new HashSet<>();

    public void addOption(Option option){
        options.add(option);
        option.getTariffs().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return idTariff == tariff.idTariff;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTariff);
    }
}

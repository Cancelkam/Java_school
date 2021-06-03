package com.javaSchool.eCare.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "options")
@Getter
@Setter
@NoArgsConstructor
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOption")
    private int idOption;

    @Column(name = "name", nullable = false)
    @Size(min = 1, max = 45)
    private String name;

    @Column(name = "cost", nullable = false)
    private double cost;

    @Column(name = "conn_cost", nullable = false)
    private double conn_cost;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Tariff_Options",
            joinColumns = @JoinColumn(name = "idOption"),
            inverseJoinColumns = @JoinColumn(name = "idTariff"))
    private Set<Tariff> tariffs = new HashSet<>();

    public void addTariff(Tariff tariff) {
        tariffs.add(tariff);
        tariff.getOptions().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return idOption == option.idOption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOption);
    }

    //    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "Contract_Options",
//            joinColumns = @JoinColumn(name = "idOption"),
//            inverseJoinColumns = @JoinColumn(name = "idContract")
//    )
//    private Set<Contract> contracts;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "associated_options",
//            joinColumns = @JoinColumn(name = "optionId", referencedColumnName = "idOption"),
//            inverseJoinColumns = @JoinColumn(name = "associatedoptionid", referencedColumnName = "idOption"))
//    private Set<Option> associatedOptions;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "incompatible_options",
//            joinColumns = @JoinColumn(name = "optionId", referencedColumnName = "idOption"),
//            inverseJoinColumns = @JoinColumn(name = "incompatibleoptionid", referencedColumnName = "idOption"))
//    private Set<Option> incompatibledOptions;
}

package com.javaSchool.eCare.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "tariff_options", joinColumns = @JoinColumn(name = "idOption"),
            inverseJoinColumns = @JoinColumn(name = "idTariff")
    )
    private List<Tariff> tariffsList;

    public void addTariffToOption(Tariff tariff) {
        if (tariffsList == null)
            tariffsList = new ArrayList<>();
        tariffsList.add(tariff);
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "selected_options",
            joinColumns = @JoinColumn(name = "idOption"),
            inverseJoinColumns = @JoinColumn(name = "idContract")
    )
    private Set<Contract> contracts;

    public void addContract(Contract contract) {
        contracts.add(contract);
        contract.getOptions().add(this);
    }

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "associated_options",
//            joinColumns = @JoinColumn(name = "optionId", referencedColumnName = "idOption"),
//            inverseJoinColumns = @JoinColumn(name = "associatedoptionid", referencedColumnName = "idOption"))
//    private Set<Option> associatedOptions;
//
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "incompatible_options",
            joinColumns = @JoinColumn(name = "optionId", referencedColumnName = "idOption"),
            inverseJoinColumns = @JoinColumn(name = "incompatibleoptionid", referencedColumnName = "idOption"))
    private Set<Option> incompatibledOptions;
}

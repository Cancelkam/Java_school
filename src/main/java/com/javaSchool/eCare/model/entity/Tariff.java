package com.javaSchool.eCare.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

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

//    @OneToMany(mappedBy = "tariff", fetch = FetchType.EAGER)
//    private Set<Contract> contracts;


//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tariffs")
//    private Set<Option> options = new HashSet<>();
//
//    public void addOption(Option option){
//        options.add(option);
//        option.getTariffs().add(this);
//    }

    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.EAGER)
    @JoinTable(name = "tariff_options", joinColumns = @JoinColumn(name = "idTariff"),
            inverseJoinColumns = @JoinColumn(name = "idOption"))
    private Set<Option> optionIdList =new HashSet<>();


    public void addOptionToTariff(Option option)
    {
        if(optionIdList==null)
            optionIdList=new HashSet<> ();
        optionIdList.add(option);

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

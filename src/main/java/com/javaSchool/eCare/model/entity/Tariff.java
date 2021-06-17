package com.javaSchool.eCare.model.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
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

    @Expose
    @Column(name = "title", nullable = false)
    @Size(min = 1, max = 45)
    private String title;

    @Expose
    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "is_deprecated")
    private boolean deprecated;

    @OneToMany(mappedBy = "tariff")
    private Set<Contract> contracts;


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

    public String convertToJson() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(this);
    }
}

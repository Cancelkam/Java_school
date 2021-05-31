package com.javaSchool.eCare.model.entity;

import lombok.*;

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

    @Column(name = "is_deprecated")
    private boolean deprecated;

    @OneToMany(mappedBy = "tariff", cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    @ManyToMany(mappedBy = "tariffs")
    private Set<Option> options;

    public void addOption(Option option){
        options.add(option);
        option.getTariffs().add(this);
    }

}

package com.javaSchool.eCare.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "option")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Option{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idOption;

    @Column(name = "title")
    @Size(min = 1, max = 45)
    private String title;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "conn_cost", nullable = false)
    private double conn_cost;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Tariff_Option",
            joinColumns = @JoinColumn(name = "idOption"),
            inverseJoinColumns = @JoinColumn(name = "idTariff")
    )
    private Set<Tariff> tariffs;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Contract_AllOptions",
            joinColumns = @JoinColumn(name = "idContract"),
            inverseJoinColumns = @JoinColumn(name = "idOption")
    )
    private Set<Contract> contracts;

//    @OneToMany(mappedBy = "option_id",cascade = CascadeType.ALL)
//    private Contract contract;
}

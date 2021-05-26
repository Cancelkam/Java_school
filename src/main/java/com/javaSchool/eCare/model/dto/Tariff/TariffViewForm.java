package com.javaSchool.eCare.model.dto.Tariff;

import com.javaSchool.eCare.model.entity.Option;
import com.javaSchool.eCare.model.entity.Tariff;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class TariffViewForm {
    private int idTariff;
    private String title;
    private double price;
    private boolean deprecated;
    private Set<Option> options;

    public TariffViewForm(Tariff tariff) {
        this.idTariff = tariff.getIdTariff();
        this.title = tariff.getTitle();
        this.price = tariff.getPrice();
        this.deprecated = tariff.isDeprecated();
//        this.options = tariff.getOptions();
    }
}

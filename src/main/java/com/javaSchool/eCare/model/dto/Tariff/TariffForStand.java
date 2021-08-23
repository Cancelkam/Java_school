package com.javaSchool.eCare.model.dto.Tariff;

import com.javaSchool.eCare.model.entity.Tariff;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TariffForStand {
    private int idTariff;
    private String title;
//    private int numberOfContracts;

    public TariffForStand(Tariff tariff){
        this.idTariff = tariff.getIdTariff();
        this.title = tariff.getTitle();
//        this.numberOfContracts = tariff.getContracts().size();
    }
}

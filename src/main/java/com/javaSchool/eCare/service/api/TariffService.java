package com.javaSchool.eCare.service.api;

import com.javaSchool.eCare.model.dto.Tariff.TariffViewForm;
import com.javaSchool.eCare.model.entity.Option;
import com.javaSchool.eCare.model.entity.Tariff;

import java.util.Collection;
import java.util.List;

public interface TariffService /*extends GenericService<Tariff, Integer>*/ {

    public List<Tariff> findAll();

    public List<TariffViewForm> getTariffViewList(Collection<Tariff> tariffs);

    public void updateTariff(Tariff tariff);

    public void addOption(Tariff tariff, Option option);

    public void deleteOption(Tariff tariff, Option option);


}

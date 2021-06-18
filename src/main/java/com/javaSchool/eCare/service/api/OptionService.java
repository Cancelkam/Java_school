package com.javaSchool.eCare.service.api;

import com.javaSchool.eCare.model.dto.Tariff.TariffViewForm;
import com.javaSchool.eCare.model.dto.option.OptionViewForm;
import com.javaSchool.eCare.model.entity.Option;

import java.util.List;

public interface OptionService extends GenericService<Option, Integer>{

    List<Option> findAll();

    public void updateOption(OptionViewForm option);

    public void createNewOption(OptionViewForm option);
}

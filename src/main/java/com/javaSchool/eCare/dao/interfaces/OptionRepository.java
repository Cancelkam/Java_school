package com.javaSchool.eCare.dao.interfaces;

import com.javaSchool.eCare.model.entity.Option;

import java.util.List;

public interface OptionRepository extends GenericRepository<Option, Integer> {

    List<Option> findAll();

//    List<Option> getAvailableOptionsByTariff(Integer idTariff);
}

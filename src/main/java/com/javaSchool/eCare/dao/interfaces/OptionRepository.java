package com.javaSchool.eCare.dao.interfaces;

import com.javaSchool.eCare.model.entity.Option;

import java.util.List;

public interface OptionRepository extends GenericRepository<Option, Integer> {

    List<Option> findAll();
//
//
//    void add(Option option);
//
//    void update(Option option);
//    List<Option> getCurrentOptionsByTariff(int idTariff);
    List<Option> getAvailableOptionsByTariff(Integer idTariff);
}

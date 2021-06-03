package com.javaSchool.eCare.service.api;

import com.javaSchool.eCare.model.entity.Option;

import java.util.List;

public interface OptionService extends GenericService<Option, Integer>{

    List<Option> findAll();

//    List<Option> getCurrentOptionsByTariff(int idTariff);
    List<Option> getAvailableOptionsByTariff(Integer idTariff);



//    List<Option> listOfAvailableOptions(int user_id, int contract_id);
//
//    public void associateOptions(int option_first_id, int option_second_id);
}

package com.javaSchool.eCare.service.implementation;

import com.javaSchool.eCare.dao.interfaces.OptionRepository;
import com.javaSchool.eCare.model.dto.option.OptionViewForm;
import com.javaSchool.eCare.model.entity.Option;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }


    @Override
    public void createEntity(Option option) {
        optionRepository.save(option);
    }

    @Override
    @Transactional
    public Option getEntityById(Integer id) {
        return optionRepository.read(id);
    }

    @Override
    public void updateEntity(Option option) {

    }

    @Override
    public void deleteEntity(Option option) {
        optionRepository.delete(option);
    }

    @Override
    @Transactional
    public List<Option> findAll() {
        return optionRepository.findAll();
    }

//    @Override
//    public List<Option> getAvailableOptionsByTariff(Integer idTariff) {
//        return optionRepository.getAvailableOptionsByTariff(idTariff);
//    }

    @Override
    @Transactional
    public void updateOption(OptionViewForm option) {
        Option newOption = new Option();
        newOption.setIdOption(option.getIdOption());
        newOption.setName(option.getName());
        newOption.setCost(option.getCost());
        newOption.setConn_cost(option.getConn_cost());
        createEntity(newOption);
    }

    @Override
    @Transactional
    public void createNewOption(OptionViewForm option) {
        Option newOption = new Option();
        newOption.setIdOption(option.getIdOption());
        newOption.setName(option.getName());
        newOption.setCost(option.getCost());
        newOption.setConn_cost(option.getConn_cost());
        createEntity(newOption);
    }
}

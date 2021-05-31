package com.javaSchool.eCare.service.implementation;

import com.javaSchool.eCare.dao.interfaces.OptionRepository;
import com.javaSchool.eCare.model.entity.Option;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.OptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }


    @Override
    public void createEntity(Option option) {

    }

    @Override
    public Option getEntityById(Integer id) {
        return null;
    }

    @Override
    public void updateEntity(Option option) {

    }

    @Override
    public void deleteEntity(Option option) {

    }
    @Override
    @Transactional
    public List<Option> findAll() { return optionRepository.findAll(); }

    @Override
    @Transactional
    public List<Option> getCurrentOptionsByTariff(int idTariff) {
        return null;
    }

//    @Override
//    public List<Option> getAvailableOptionsByTariff(int idTariff) {
//        return optionRepository.getAvailableOptionsByTariff(idTariff);
//    }


}

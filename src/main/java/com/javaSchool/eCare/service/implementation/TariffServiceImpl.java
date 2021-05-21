package com.javaSchool.eCare.service.implementation;


import com.javaSchool.eCare.dao.implementation.TariffRepositoryImpl;

import com.javaSchool.eCare.dao.interfaces.TariffRepository;
import com.javaSchool.eCare.model.dto.Tariff.TariffViewForm;
import com.javaSchool.eCare.model.entity.Option;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.GenericService;
import com.javaSchool.eCare.service.api.TariffService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;

    @Autowired
    public TariffServiceImpl(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }


    @Override
    @Transactional
    public void createEntity(Tariff entity) {
        tariffRepository.create(entity);
    }

    @Override
    @Transactional
    public void createNewTariff(TariffViewForm tariff) {
        Tariff newTariff = new Tariff();
        newTariff.setTitle(tariff.getTitle());
        newTariff.setPrice(tariff.getPrice());
        createEntity(newTariff);
    }

    @Override
    @Transactional
    public Tariff getEntityById(Tariff id) {
        return null;
    }

    @Override
    @Transactional
    public void updateEntity(Tariff tariff) {

    }

    @Override
    @Transactional
    public void deleteEntity(Tariff tariff) {

    }

    @Override
    @Transactional
    public List<Tariff> findAll() {
        return tariffRepository.findAll();
    }

    @Override
    @Transactional
    public List<TariffViewForm> getTariffViewList(Collection<Tariff> tariffs) {
        return null;
    }

    @Override
    @Transactional
    public void updateTariff(Tariff tariff) {

    }

    @Override
    @Transactional
    public void addOption(Tariff tariff, Option option) {

    }

    @Override
    @Transactional
    public void deleteOption(Tariff tariff, Option option) {

    }
}

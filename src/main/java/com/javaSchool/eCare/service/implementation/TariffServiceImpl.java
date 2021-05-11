package com.javaSchool.eCare.service.implementation;


import com.javaSchool.eCare.dao.implementation.TariffRepositoryImpl;

import com.javaSchool.eCare.dao.interfaces.TariffRepository;
import com.javaSchool.eCare.model.entity.Tariff;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TariffServiceImpl extends GenericServiceImpl<Tariff, TariffRepository>  {

    private final TariffRepositoryImpl tariffRepositoryimpl;

//
////    public TariffService(TariffRepositoryImpl tariffRepositoryimpl) {
////
////        this.tariffRepositoryimpl = tariffRepositoryimpl;
////    }


    @Autowired
    public TariffServiceImpl(TariffRepository tariffRepository, ModelMapper mapper, Class<Tariff> tariffClass, TariffRepositoryImpl tariffRepositoryimpl) {
        super(tariffRepository, mapper, tariffClass);
        this.tariffRepositoryimpl = tariffRepositoryimpl;
    }

    public List<Tariff> findAll() {
        return tariffRepositoryimpl.findAll();
    }
}

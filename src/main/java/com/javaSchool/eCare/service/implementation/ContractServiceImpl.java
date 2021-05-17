package com.javaSchool.eCare.service.implementation;

import com.javaSchool.eCare.dao.interfaces.ContractRepository;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository){
        this.contractRepository = contractRepository;
    }

    @Override
    @Transactional
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

}

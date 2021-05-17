package com.javaSchool.eCare.service.api;

import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.Tariff;

import java.util.List;

public interface ContractService {
    public List<Contract> findAll();
}

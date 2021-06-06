package com.javaSchool.eCare.service.api;

import com.javaSchool.eCare.model.dto.contract.ContractViewForm;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.Tariff;

import java.util.Collection;
import java.util.List;

public interface ContractService extends GenericService<Contract, Integer> {
    public List<Contract> findAll();

    public List<ContractViewForm> getContractViewList(Collection<Contract> contracts);

}

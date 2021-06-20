package com.javaSchool.eCare.service.implementation;

import com.javaSchool.eCare.dao.interfaces.ContractRepository;
import com.javaSchool.eCare.model.dto.contract.ContractViewForm;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract createEntity(String number) {
        Contract contract = new Contract();
        contract.setNumber(number);
        return contract;
    }

    @Override
    @Transactional
    public void addContract(Contract contract) {
        contractRepository.add(contract);
    }

    public void createEntity(Contract contract) {
    }

    @Override
    @Transactional
    public Contract getEntityById(Integer id) {
        return contractRepository.read(id);
    }

    @Override
    public void updateEntity(Contract contract) {

    }

    @Override
    public void deleteEntity(Contract contract) {

    }

    @Override
    @Transactional
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEntity(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    @Transactional
    public List<ContractViewForm> getContractViewList(Collection<Contract> contracts) {
        List<ContractViewForm> contractDto = new ArrayList<ContractViewForm>();
        for (Contract contract : contracts) {
            contractDto.add(new ContractViewForm(contract));
        }
        return contractDto;
    }



}

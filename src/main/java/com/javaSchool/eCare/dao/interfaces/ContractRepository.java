package com.javaSchool.eCare.dao.interfaces;

import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.UserEntity;

import java.util.List;

public interface ContractRepository extends GenericRepository<Contract, Integer> {

    void add(Contract contract);
}

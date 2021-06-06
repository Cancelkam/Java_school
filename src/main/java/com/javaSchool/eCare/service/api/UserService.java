package com.javaSchool.eCare.service.api;

import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.model.entity.UserEntity;

import java.util.List;

public interface UserService extends GenericService<UserEntity, Integer>{
    public List<UserEntity> findAll();

    public UserEntity getUserByNumber(String number);

    public UserEntity getUserByEmail(String email);

    public List<Contract> getContractByUserId(Integer id);

}

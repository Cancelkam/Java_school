package com.javaSchool.eCare.service.api;

import com.javaSchool.eCare.model.dto.Tariff.TariffViewForm;
import com.javaSchool.eCare.model.dto.contract.ContractViewForm;
import com.javaSchool.eCare.model.dto.user.UserAccountForm;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.model.entity.UserEntity;

import java.util.Collection;
import java.util.List;

public interface UserService extends GenericService<UserEntity, Integer>{
    public List<UserEntity> findAll();

    public UserEntity getUserByNumber(String number);

    public UserEntity getUserByEmail(String email);

    public List<Contract> getContractByUserId(Integer id);

    public List<UserAccountForm> getUserViewList(Collection<UserEntity> users);

    public void updateUser(UserAccountForm user);

//    public void blockContract(int user_id,int contract_id);
//
//    public void unBlockContract(int user_id,int contract_id);

    public void blockContractByAdmin(int id);

    public void unblockContractByAdmin(int id);

}

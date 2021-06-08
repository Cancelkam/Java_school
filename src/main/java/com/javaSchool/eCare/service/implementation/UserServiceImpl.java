package com.javaSchool.eCare.service.implementation;

import com.javaSchool.eCare.dao.interfaces.UserRepository;
import com.javaSchool.eCare.model.dto.Tariff.TariffViewForm;
import com.javaSchool.eCare.model.dto.contract.ContractViewForm;
import com.javaSchool.eCare.model.dto.user.UserAccountForm;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.model.entity.UserEntity;
import com.javaSchool.eCare.service.api.ContractService;
import com.javaSchool.eCare.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //    private final UserService userService;
    private final UserRepository userRepository;
    private final ContractService contractService;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ContractService contractService) {
        this.userRepository = userRepository;
        this.contractService = contractService;
    }

    @Override
    public void createEntity(UserEntity userEntity) { userRepository.save(userEntity); }

    @Override
    @Transactional
    public UserEntity getEntityById(Integer id) {
        return userRepository.read(id);
    }

    @Override
    @Transactional
    public void updateUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void createNewUser(UserEntity user) {
        createEntity(user);
    }

    @Override
    public void updateEntity(UserEntity userEntity) {

    }

    @Override
    public void deleteEntity(UserEntity userEntity) {

    }

    @Override
    @Transactional
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public UserEntity getUserByNumber(String number) {
        return userRepository.getUserByNumber(number);
    }

    @Override
    @Transactional
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public List<Contract> getContractByUserId(Integer id) {
        return userRepository.getContractByUserId(id);
    }

    @Override
    @Transactional
    public List<UserAccountForm> getUserViewList(Collection<UserEntity> users){
        List<UserAccountForm> usersDto = new ArrayList<UserAccountForm>();
        for (UserEntity user : users) {
            usersDto.add(new UserAccountForm(user));
        }
        return usersDto;
    }

//    @Override
//    @Transactional
//    public void blockContract(int idUser, int idContract) {
//        UserEntity user = getEntityById(idUser);
//        UserEntity currentUser = userDetailService.getCurrentUser();
//        if (user.equals(currentUser)) {
//            Contract contract = contractService.getEntityById(idContract);
//            if (user.getContracts().contains(contract)) {
//                contract.setBlocked(true);
//                contractService.updateEntity(contract);
//            }
//        }
//    }
//
//    @Override
//    @Transactional
//    public void unBlockContract(int idUser, int idContract) {
//        UserEntity user = getEntityById(idUser);
//        UserEntity currentUser = userDetailService.getCurrentUser();
//        if (user.equals(currentUser)) {
//            Contract contract = contractService.getEntityById(idContract);
//            if (user.getContracts().contains(contract)) {
//                contract.setBlocked(false);
//                contractService.updateEntity(contract);
//            }
//        }
//    }

    @Override
    @Transactional
    public void blockContractByAdmin(int id) {
        Contract contract = contractService.getEntityById(id);
        contract.setBlocked(true);
        contract.setBlocked_by_admin(true);
        contractService.updateEntity(contract);
    }

    @Override
    @Transactional
    public void unblockContractByAdmin(int id) {
        Contract contract = contractService.getEntityById(id);
        contract.setBlocked_by_admin(false);
        contractService.updateEntity(contract);
    }
}


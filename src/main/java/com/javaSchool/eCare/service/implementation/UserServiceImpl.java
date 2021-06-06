package com.javaSchool.eCare.service.implementation;

import com.javaSchool.eCare.dao.interfaces.UserRepository;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.UserEntity;
import com.javaSchool.eCare.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //    private final UserService userService;
    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createEntity(UserEntity userEntity) {

    }

    @Override
    public UserEntity getEntityById(Integer id) {
        return null;
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
}


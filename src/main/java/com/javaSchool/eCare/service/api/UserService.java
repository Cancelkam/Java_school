package com.javaSchool.eCare.service.api;

import com.javaSchool.eCare.model.entity.UserEntity;

import java.util.List;

public interface UserService{
    public List<UserEntity> findAll();
//    public List<UserAccountForm> userAccListByCond(String emailOrNumber);
}
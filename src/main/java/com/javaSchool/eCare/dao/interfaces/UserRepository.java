package com.javaSchool.eCare.dao.interfaces;


import com.javaSchool.eCare.model.entity.UserEntity;

import java.util.Collection;
import java.util.List;

public interface UserRepository {

    List<UserEntity> findAll();

    UserEntity getUserByNumber(String number);

    UserEntity findByEmail(String email);

    void add(UserEntity user);

    void update(UserEntity user);

//    Collection<UserEntity> getRole(String email);

    String getRole();
}

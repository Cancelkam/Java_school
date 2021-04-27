package com.javaSchool.eCare.dao.implementation;


import com.javaSchool.eCare.dao.interfaces.UserRepository;
import com.javaSchool.eCare.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public UserEntity findById(int id) {
        return null;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return null;
    }

    @Override
    public void add(UserEntity user) {

    }

    @Override
    public void update(UserEntity user) {

    }

    @Override
    public Collection<UserEntity> findGroupByEmail(String email) {
        return null;
    }
}
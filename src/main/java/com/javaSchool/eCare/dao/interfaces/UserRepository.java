package com.javaSchool.eCare.dao.interfaces;


import com.javaSchool.eCare.model.entity.UserEntity;
import com.javaSchool.eCare.model.entity.enums.Group;

import java.util.List;


public interface UserRepository {

//        List<UserEntity> findAll();
//
//        /**
//         * Find by id user entity.
//         * @param idUser the id
//         * @return the user entity
//         */
//        UserEntity findUserById(int idUser);
//
//        /**
//         * Find by email user entity.
//         * @param contractNumber the login
//         * @return the user entity
//         */
//
//        UserEntity findByContractNumber(String contractNumber);
//
        /**
         * Find by email user entity.
         * @param email the login
         * @return the user entity
         */

        UserEntity findByEmail(String email);
//
//
//        /**
//         * Getting group by idUser
//         * @param idUser
//         * @return the user entity
//         */
//
//        Group getGroupById(int idUser);
//
//        /**
//         * Add user entity.
//         *
//         * @param user the user entity
//         * @return the user entity
//         */
//        void add(UserEntity user);

}

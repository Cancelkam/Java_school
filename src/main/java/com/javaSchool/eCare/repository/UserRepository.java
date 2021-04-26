package com.javaSchool.eCare.repository;


import com.javaSchool.eCare.model.entity.UserEntity;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;
import java.util.List;


public interface UserRepository {

        List<User> findAll();

        /**
         * Find by id user entity.
         * @param idUser the id
         * @return the user entity
         */
        User findById(int idUser);

        /**
         * Find by email user entity.
         * @param email the login
         * @return the user entity
         */

        UserEntity findByEmail(String email);

        /**
         * Add user entity.
         *
         * @param user the user entity
         * @return the user entity
         */
        void add(User user);

        /**
         * Update user entity.
         *
         * @param user the user entity
         * @return the user entity
         */
        void update(User user);

        /**
         * Find group by user email list.
         *
         * @param email the user login
         * @return the list
         */
        Collection<User> findGroupByEmail(String email);
}

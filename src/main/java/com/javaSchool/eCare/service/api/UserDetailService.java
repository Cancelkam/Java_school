package com.javaSchool.eCare.service.api;

import com.javaSchool.eCare.model.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDetailService extends UserDetailsService {

    String getEmailOfCurrentUser();


    UserEntity findUserByEmail(String email);


    void update(UserEntity user);


    UserEntity getCurrentUser();

    String getRole();
}


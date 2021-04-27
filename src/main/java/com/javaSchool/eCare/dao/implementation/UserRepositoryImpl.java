package com.javaSchool.eCare.dao.implementation;


import com.javaSchool.eCare.dao.interfaces.UserRepository;
import com.javaSchool.eCare.model.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

//    private SessionFactory sessionFactory;
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
    public UserEntity findByEmail(String email){
        return new UserEntity();
    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<UserEntity> findAll() {
//        return sessionFactory.getCurrentSession()
//                .createQuery("FROM UserEntity").list();
//    }



}
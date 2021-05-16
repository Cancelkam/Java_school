package com.javaSchool.eCare.dao.implementation;


import com.javaSchool.eCare.dao.interfaces.UserRepository;
import com.javaSchool.eCare.model.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserEntity findByEmail(String email) {
        return (UserEntity) sessionFactory.getCurrentSession()
                .createQuery("FROM UserEntity AS u WHERE u.email = :email")
                .setParameter("email", email).uniqueResult();

    }

    @Override
    public UserEntity findByContractNumber(String contractNumber) {
        return (UserEntity) sessionFactory.getCurrentSession()
                .createQuery("FROM UserEntity AS u WHERE u.contractNumber = :contractNumber")
                .setParameter("contractNumber", contractNumber).uniqueResult();

    }

    @Override
    public List<UserEntity> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM UserEntity").list();
    }

    @Override
    public void add(UserEntity user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(UserEntity user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    public List<UserEntity> getRole(String email) {
        Query query = (Query) sessionFactory.getCurrentSession()
                .createQuery("SELECT role FROM UserEntity WHERE UserEntity.email = :email")
                .setParameter("email", email).getSingleResult();

        return query.list();

    }
}
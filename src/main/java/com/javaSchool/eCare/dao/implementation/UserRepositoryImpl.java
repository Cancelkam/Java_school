package com.javaSchool.eCare.dao.implementation;


import com.javaSchool.eCare.dao.interfaces.UserRepository;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<UserEntity,Integer> implements UserRepository {

//    private SessionFactory session;

//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.session = sessionFactory;
//    }

    public UserEntity findByEmail(String email) {
        return (UserEntity) session.getCurrentSession()
                .createQuery("FROM UserEntity AS u WHERE u.email = :email")
                .setParameter("email", email).uniqueResult();

    }

    @Override
    public UserEntity getUserByNumber(String contractNumber) {
        return (UserEntity) session.getCurrentSession()
                .createQuery("SELECT c.userEntity FROM Contract c WHERE c.number=:number")
                .setParameter("number", contractNumber).uniqueResult();

    }

    @Override
    public List<UserEntity> findAll() {
        return session.getCurrentSession()
                .createQuery("FROM UserEntity").list();
    }

    @Override
    public void add(UserEntity user) {
        session.getCurrentSession().save(user);
    }

    @Override
    public void update(UserEntity user) {
        session.getCurrentSession().merge(user);
    }

//    public List<UserEntity> getRole(String email) {
//        Query query = (Query) sessionFactory.getCurrentSession()
//                .createQuery("SELECT role FROM UserEntity WHERE UserEntity.email = :email")
//                .setParameter("email", email).getSingleResult();
//
//        return query.list();
//
//    }

    @Override
    public String getRole() {
        return String.valueOf(session.getCurrentSession()
                .createQuery("SELECT role FROM UserEntity"));
    }
    @Override
    public List<Contract> getContractByUserId(Integer id){
        return session.getCurrentSession()
                .createQuery("from Contract as c where c.userEntity.idUser=:id")
                .setParameter("id", id).getResultList();
    }
}
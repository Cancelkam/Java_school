package com.javaSchool.eCare.dao.implementation;

import com.javaSchool.eCare.dao.interfaces.ContractRepository;
import com.javaSchool.eCare.model.entity.Contract;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractRepositoryImpl extends GenericRepositoryImpl<Contract,Integer> implements ContractRepository {

//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Override
    public List<Contract> findAll() {
        return session.getCurrentSession()
                .createQuery("FROM Contract").list();
    }

    @Override
    public void add(Contract contract) {
        session.getCurrentSession().persist(contract);
    }
//
//    @Override
//    public void update(Contract contract) {
//        sessionFactory.getCurrentSession().merge(contract);
//    }
}

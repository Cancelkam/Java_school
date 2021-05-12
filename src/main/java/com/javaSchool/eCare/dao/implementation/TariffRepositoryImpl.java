package com.javaSchool.eCare.dao.implementation;

import com.javaSchool.eCare.dao.interfaces.TariffRepository;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.model.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TariffRepositoryImpl extends GenericRepositoryImpl<Tariff,Integer> implements TariffRepository {
    public TariffRepositoryImpl(Class<Tariff> clazz) {
        super(clazz);
    }

//    private SessionFactory sessionFactory;
//
//    public TariffRepositoryImpl(Class<Tariff> clazz) {
//        super(clazz);
//    }
//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<Tariff> findAll() {
//        return sessionFactory.getCurrentSession()
//                .createQuery("FROM Tariff ").list();
//    }
//
//    @Override
//    public void add(Tariff tariff) {
//        sessionFactory.getCurrentSession().save(tariff);
//    }
//
//    @Override
//    public void update(Tariff tariff) {
//        sessionFactory.getCurrentSession().merge(tariff);
//    }

}

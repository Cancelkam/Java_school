package com.javaSchool.eCare.dao.implementation;


import com.javaSchool.eCare.dao.interfaces.GenericRepository;
import com.javaSchool.eCare.dao.interfaces.TariffRepository;
import com.javaSchool.eCare.model.entity.Tariff;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericRepositoryImpl<Entity, Integer> implements GenericRepository<Entity, Integer> {


    private final Class<Entity> entityClass;

    SessionFactory session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.session = sessionFactory;
    }

    public GenericRepositoryImpl() {
        entityClass = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public List<Entity> findAll() {
        return session.getCurrentSession()
                .createQuery("from " + entityClass.getName(), entityClass)
                .getResultList();
    }

    @Override
    public void save(Entity entity) {
        session.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Entity entity) {
        session.getCurrentSession().delete(session.getCurrentSession().merge(entity));
    }

    @Override
    public List<Entity> getLimit(int limit) {
       Query<Entity> query = session.getCurrentSession().createQuery("from " + entityClass.getName() + "c  order by c.id desc", entityClass);
       query.setMaxResults(limit);
       return query.list();
    }

    //    @Override
//    public Entity save(Entity entity) {
//        session.getCurrentSession().persist(entity);
//        session.getCurrentSession().flush();
//        return entity;
//    }
//
    @Override
    public void update(Entity entity) {
        session.getCurrentSession()
                .merge(entity);
    }

    @Override
    public Entity read(Integer id) {
        return this.session.getCurrentSession()
                .find(entityClass, id);
    }
}

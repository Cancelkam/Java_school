package com.javaSchool.eCare.dao.implementation;

import com.javaSchool.eCare.dao.interfaces.OptionRepository;
import com.javaSchool.eCare.model.entity.Option;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OptionRepositoryImpl extends GenericRepositoryImpl<Option,Integer> implements OptionRepository {

//    private SessionFactory session;
//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.session = sessionFactory;
//    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<Option> findAll() {
//        return sessionFactory.getCurrentSession()
//                .createQuery("FROM Option").list();
//    }
//
//    @Override
//    public void add(Option option) {
//        sessionFactory.getCurrentSession().save(option);
//    }
//
//    @Override
//    public void update(Option option) {
//        sessionFactory.getCurrentSession().merge(option);
//    }

//    @Override
//    public List<Option> getCurrentOptionsByTariff(int idTariff) {
//        return null;
//        }
//
    @Override
    @Transactional
    public List<Option> getAvailableOptionsByTariff(Integer id) {
        return this.session.getCurrentSession()
                .createQuery("select o from Option as o join Tariff as t on t.idTariff=:id")
                .setParameter("id", id).getResultList();
    }
}

package com.javaSchool.eCare.dao.interfaces;

import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.GenericService;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TariffRepository extends GenericRepository<Tariff> {

    List <Tariff> findAll();

    /**
     * Add user entity.
     *
     * @param tariff the Tariff
     * @return the user entity
     */
    void add(Tariff tariff);

    /**
     * Add user entity.
     *
     * @param tariff the Tariff
     * @return the tariff
     */
    void update(Tariff tariff);
}

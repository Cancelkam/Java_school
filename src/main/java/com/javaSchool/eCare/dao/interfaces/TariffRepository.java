package com.javaSchool.eCare.dao.interfaces;

import com.javaSchool.eCare.model.entity.Tariff;

import java.util.List;

public interface TariffRepository {

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

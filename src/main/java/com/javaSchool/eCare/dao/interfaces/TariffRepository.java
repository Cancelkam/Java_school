package com.javaSchool.eCare.dao.interfaces;

import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.GenericService;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public interface TariffRepository extends GenericRepository<Tariff, Integer> {

}

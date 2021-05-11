package com.javaSchool.eCare.dao.interfaces;

import java.util.List;

public interface GenericRepository<Entity> {
    List<Entity> findAll();

}
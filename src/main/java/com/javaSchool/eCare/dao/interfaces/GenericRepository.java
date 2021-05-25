package com.javaSchool.eCare.dao.interfaces;

import java.util.List;

public interface GenericRepository<Entity,Integer> {
    public List<Entity> findAll();

    void save(Entity entity);

    public Entity read(Integer id);

    public void update(Entity entity);

    public void delete(Entity entity);
}
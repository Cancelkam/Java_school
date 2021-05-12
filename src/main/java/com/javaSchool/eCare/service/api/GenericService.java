package com.javaSchool.eCare.service.api;

import java.util.List;

public interface GenericService<Entity,Integer> {

    public void createEntity(Entity entity);

    public Entity getEntityById(Entity id);

    public void updateEntity(Entity entity);

    public void deleteEntity(Entity entity);

    public List<Entity> findAll();
}

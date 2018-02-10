package com.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mystery on 2018/1/28.
 */
public interface GenericDao <Entity extends Serializable, ID extends Object>{
    Entity findById(ID id);
    List<Entity> findAll(int isRef);
    List<Entity> findByName(String name);

    int insert(Entity entity);
    int update(Entity entity);
    int delete(Entity entity);
    int delete(ID id);
}


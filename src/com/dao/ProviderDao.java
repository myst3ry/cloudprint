package com.dao;

import com.domain.po.Provider;

import java.util.List;

/**
 * Created by Mystery on 2018/1/29.
 */
public interface ProviderDao extends GenericDao<Provider,Integer>{
    Provider findById(Integer id);
    List<Provider> findByName(String name);
    List<Provider> findAll(int isRef);

    int insert(Provider provider);
    int update(Provider provider);
    int delete(Provider provider);
    int delete(Integer id);
}

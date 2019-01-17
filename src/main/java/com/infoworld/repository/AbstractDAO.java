package com.infoworld.repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Claudiu on 01/17/2018.
 */
public interface AbstractDAO<T> {

    public Class<T> getGenericClass();
    public CriteriaBuilder getCriteriaBuilder();

    public T findById(int id);
    public List< T > findAll();
    public T findByCode(String code);

    @Transactional
    public void create(T entity);

    @Transactional
    public T update(T entity);

    @Transactional
    public void delete(T entity);

    @Transactional
    public void deleteById(int entityId);
}

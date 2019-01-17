package com.infoworld.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Claudiu on 01/17/2018.
 */
@Repository
public abstract class AbstractDAOImpl<T> implements AbstractDAO<T> {

    @PersistenceContext
    protected EntityManager em;

    public abstract Class<T> getGenericClass();
    public CriteriaBuilder getCriteriaBuilder(){
        return em.getCriteriaBuilder();
    }

    public T findById( int id ){
        return (T)em.find( getGenericClass(), id );
    }
    public List< T > findAll(){

        CriteriaQuery<T> query = getCriteriaBuilder().createQuery(getGenericClass());
        Root<T> root = query.from(getGenericClass());

        return em.createQuery(query.select(root)).getResultList();
    }

    public T findByCode(String code){
        CriteriaQuery<T> query = getCriteriaBuilder().createQuery(getGenericClass());
        Root<T> root = query.from(getGenericClass());
        query.where(getCriteriaBuilder().equal(root.get("code"), code));

        return em.createQuery(query).getResultList().get(0);
    }

    @Transactional
    public void create( T entity ){
        em.persist( entity );
    }

    @Transactional
    public T update( T entity ){
        T t = em.merge(entity);
        em.flush();
        return t;
    }

    @Transactional
    public void delete( T entity ){
        em.remove( entity );
    }

    @Transactional
    public void deleteById( int entityId ){
        T entity = findById( entityId );
        delete( entity );
    }
}

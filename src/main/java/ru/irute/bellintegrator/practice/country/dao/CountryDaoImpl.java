package ru.irute.bellintegrator.practice.country.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.irute.bellintegrator.practice.country.entity.CountryEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao{

    private final EntityManager em;

    @Autowired
    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CountryEntity> all() {
        TypedQuery<CountryEntity> query = em.createQuery("SELECT c FROM CountryEntity c", CountryEntity.class);
        return query.getResultList();
    }

    @Override
    public CountryEntity getByCode(String code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<CountryEntity> criteriaQuery = builder.createQuery(CountryEntity.class);
        Root<CountryEntity> root = criteriaQuery.from(CountryEntity.class);
        criteriaQuery
                .where(builder.equal(root.get("code"), code.trim()))
                .select(root);
        TypedQuery<CountryEntity> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }
}

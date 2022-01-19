package ru.irute.bellintegrator.practice.typeDocument.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;
import ru.irute.bellintegrator.practice.typeDocument.entity.TypeDocumentEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

@Repository
public class TypeDocumentDaoImpl implements TypeDocumentDao{
    private final EntityManager em;

    @Autowired
    public TypeDocumentDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<TypeDocumentEntity> getAllDocTypes() {
        TypedQuery<TypeDocumentEntity> query = em.createQuery("SELECT t FROM TypeDocumentEntity t", TypeDocumentEntity.class);
        return  query.getResultList();
    }

    @Override
    public TypeDocumentEntity getDocTypeByCode (String code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<TypeDocumentEntity> criteriaQuery = builder.createQuery(TypeDocumentEntity.class);
        Root<TypeDocumentEntity> root = criteriaQuery.from(TypeDocumentEntity.class);
        criteriaQuery
                .where(builder.equal(root.get("code"), code))
                .select(root);
        TypedQuery<TypeDocumentEntity> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();

    }
}

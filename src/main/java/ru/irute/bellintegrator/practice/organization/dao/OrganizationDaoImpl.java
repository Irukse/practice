package ru.irute.bellintegrator.practice.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.irute.bellintegrator.practice.organization.entity.OrganizationEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Repository
public class OrganizationDaoImpl implements OrganizationDao{

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em){ this.em = em;}

    @Override
    public OrganizationEntity getById(Long id){
        return em.find(OrganizationEntity.class, id);
    }

    @Override
    public void save(OrganizationEntity organizationEntity) {
        em.persist(organizationEntity);
    }

    @Override
    public List<OrganizationEntity> all() {
        return em.createQuery("SELECT o FROM Organization o", OrganizationEntity.class).getResultList();
    }

    @Override
    public List<OrganizationEntity> getList(OrganizationEntity organization) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<OrganizationEntity> criteriaQuery = builder.createQuery(OrganizationEntity.class);
        Root<OrganizationEntity> root =  criteriaQuery.from(OrganizationEntity.class);
        List<Predicate> predicates = new LinkedList<>();

        if(Objects.nonNull(organization.getName())){
            predicates.add(builder.equal(root.get("name"),organization.getName()));
        }
        if(Objects.nonNull(organization.getInn())){
            predicates.add(builder.equal(root.get("inn"),organization.getInn()));
        }
        if (Objects.nonNull(organization.getIsActive())){
            predicates.add(builder.equal(root.get("isActive"),organization.getIsActive()));
        }
        criteriaQuery.where(builder.and(predicates.toArray(new Predicate[]{})));
        TypedQuery<OrganizationEntity> list = em.createQuery(criteriaQuery);
        return list.getResultList();
    }
    }



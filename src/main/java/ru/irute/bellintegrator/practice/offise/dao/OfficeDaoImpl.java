package ru.irute.bellintegrator.practice.offise.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class OfficeDaoImpl implements OfficeDao{
    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em){
        this.em =em;
    }

    @Override
    public OfficeEntity getOffice(Long id) {
        return em.find(OfficeEntity.class, id);
    }

    @Override
    public void save(OfficeEntity office) {
        em.persist(office);
    }

    @Override
    public List<OfficeEntity> list(Map<String,Object> filter) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<OfficeEntity> criteriaQuery = builder.createQuery(OfficeEntity.class);
        Root<OfficeEntity> rootOffice = criteriaQuery.from(OfficeEntity.class);
        List<Predicate> predicates = new LinkedList<>();

        if(Objects.nonNull(filter.get("orgId"))){
            predicates.add(builder.equal(rootOffice.get("organization").get("id"),filter.get("orgId")));
        }
        if(Objects.nonNull(filter.get("name"))){
            predicates.add(builder.equal(rootOffice.get("name"),filter.get("name")));
        }
        if(Objects.nonNull(filter.get("phone"))){
            predicates.add(builder.equal(rootOffice.get("phone"),filter.get("phone")));
        }
        if(Objects.nonNull(filter.get("isActive"))){
            predicates.add(builder.equal(rootOffice.get("isActive"),filter.get("isActive")));
        }
        criteriaQuery.where(builder.and(predicates.toArray(new Predicate[]{})));
        TypedQuery<OfficeEntity> list = em.createQuery(criteriaQuery);
        return list.getResultList();
    }
}

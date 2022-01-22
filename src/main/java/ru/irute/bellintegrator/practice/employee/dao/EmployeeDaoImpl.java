package ru.irute.bellintegrator.practice.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.irute.bellintegrator.practice.country.dao.CountryDao;
import ru.irute.bellintegrator.practice.country.dao.CountryDaoImpl;
import ru.irute.bellintegrator.practice.country.entity.CountryEntity;
import ru.irute.bellintegrator.practice.docEmployee.entity.DocEmployeeEntity;
import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;
import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;
import ru.irute.bellintegrator.practice.typeDocument.dao.TypeDocumentDao;
import ru.irute.bellintegrator.practice.typeDocument.entity.TypeDocumentEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private final EntityManager em;

    @Autowired
    public EmployeeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public EmployeeEntity getUserById(Long id) {
        return em.find(EmployeeEntity.class, id);
    }

    @Override
    public List<EmployeeEntity> list(Map<String,Object> map) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> criteriaQuery = builder.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> root = criteriaQuery.from(EmployeeEntity.class);
        Root<TypeDocumentEntity> rootTypeDoc = criteriaQuery.from(TypeDocumentEntity.class);
        Root<CountryEntity> rootCountry = criteriaQuery.from(CountryEntity.class);
        criteriaQuery.multiselect(root, rootTypeDoc, rootCountry);
        List<Predicate> predicates = new LinkedList<>();

        if (Objects.nonNull(map.get("officeId"))) {
            SetJoin<EmployeeEntity, OfficeEntity> joinUserOffice = root.joinSet("office_id");

            OfficeEntity office = em.find(OfficeEntity.class, map.get("officeId"));
            predicates.add(joinUserOffice.in(office));
        }
        if (Objects.nonNull(map.get("firstName"))) {
            predicates.add(builder.equal(root.get("firstName"), map.get("firstName")));
        }
        if (Objects.nonNull(map.get("secondName"))) {
            predicates.add(builder.equal(root.get("secondName"), map.get("secondName")));
        }
        if (Objects.nonNull(map.get("lastName"))) {
            predicates.add(builder.equal(root.get("lastName"), map.get("lastName")));
        }
        if (Objects.nonNull(map.get("position"))) {
            predicates.add(builder.equal(root.get("position"), map.get("position")));
        }
        //
        if (Objects.nonNull(map.get("docCode"))) {

           predicates.add(builder.equal(rootTypeDoc.get("code"),
                    map.get("docCode")));
        }


        if (Objects.nonNull(map.get("citizenshipCode"))) {
            predicates.add(builder.equal(rootCountry.get("code"), map.get("citizenshipCode")));
        }

        criteriaQuery
                .where(predicates.toArray(new Predicate[]{}))
                .select(root);
        TypedQuery<EmployeeEntity> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }




    @Override
    public void save(EmployeeEntity employee) {
        em.persist(employee);
    }
}

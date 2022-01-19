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
    public EmployeeEntity getById(Long id) {
        return em.find(EmployeeEntity.class, id);
    }

//    @Override
//    public List<EmployeeEntity> list(Map<String,Object> map) {
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<EmployeeEntity> criteriaQuery = builder.createQuery(EmployeeEntity.class);
//        Root<EmployeeEntity> root = criteriaQuery.from(EmployeeEntity.class);
//        List<Predicate> predicates = new LinkedList<>();
//
//        if (Objects.nonNull(map.get("officeId"))) {
//            SetJoin<EmployeeEntity, OfficeEntity> joinUserOffice = root.joinSet("office_id");
//
//            OfficeEntity office = em.find(OfficeEntity.class, map.get("officeId"));
//            predicates.add(joinUserOffice.in(office));
//        }
//        if (Objects.nonNull(map.get("firstName"))) {
//            predicates.add(builder.equal(root.get("firstName"), map.get("firstName")));
//        }
//        if (Objects.nonNull(map.get("secondName"))) {
//            predicates.add(builder.equal(root.get("secondName"), map.get("secondName")));
//        }
//        if (Objects.nonNull(map.get("middleName"))) {
//            predicates.add(builder.equal(root.get("middleName"), map.get("middleName")));
//        }
//        if (Objects.nonNull(map.get("position"))) {
//            predicates.add(builder.equal(root.get("position"), map.get("position")));
//        }
//        if (Objects.nonNull(map.get("docCode"))) {
//            predicates.add(builder.equal(root.get("employeeDocument").get("documentCatalog").get("code"),
//                    map.get("docCode")));
//        }
//        if (Objects.nonNull(map.get("citizenshipCode"))) {
//            predicates.add(builder.equal(root.get("country").get("code"), map.get("citizenshipCode")));
//        }
//
//        criteriaQuery
//                .where(predicates.toArray(new Predicate[]{}))
//                .select(root);
//        TypedQuery<EmployeeEntity> query = em.createQuery(criteriaQuery);
//        return query.getResultList();
//    }
//
//    @Override
//    public void update(EmployeeEntity employee) {
//        EmployeeEntity updatedEmployee = em.find(EmployeeEntity.class, employee.getId());
//        // обновляем updatedEmployee
//        if (Objects.nonNull(updatedEmployee)) {
//
//            if (Objects.nonNull(employee.getFirstName())) {
//                updatedEmployee.setFirstName(employee.getFirstName().trim());
//            }
//
//            if (Objects.nonNull(employee.getSecondName())) {
//                updatedEmployee.setSecondName(employee.getSecondName().trim());
//            }
//
//            if (Objects.nonNull(employee.getLastName())) {
//                updatedEmployee.setLastName(employee.getLastName().trim());
//            }
//
//            if (Objects.nonNull(employee.getPosition())) {
//                updatedEmployee.setPosition(employee.getPosition().trim());
//            }
//
//            if (Objects.nonNull(employee.getPhone())) {
//                updatedEmployee.setPhone(employee.getPhone().trim());
//            }
//            // isIdentified
//            if (Objects.nonNull(employee.getIdentified())) {
//                updatedEmployee.setIdentified(employee.getIdentified());
//            }
//
//            // EmployeeDocument
//            DocEmployeeEntity employeeDocument = employee.getDocEmployee();
//            if (Objects.nonNull(employeeDocument)) {
//                DocEmployeeEntity updatedEmployeeDocument = updatedEmployee.getDocEmployee();
//                // Создадим новый если нет документа
//                if (Objects.isNull(updatedEmployeeDocument)) {
//                    updatedEmployeeDocument = new DocEmployeeEntity ();
//                    em.persist(updatedEmployeeDocument);
//                }
//                // если указан тип документа удост. личность
//                TypeDocumentEntity docType = employeeDocument.getDocType();
//                if (Objects.nonNull(docType)) {
//                    docType
//                            = typeDocumentDao.getByCode(docType.getCode());
//                    updatedEmployeeDocument.setDocType(docType);
//                }
//                // docName
//                if (Objects.nonNull(employeeDocument.getDocType().getName())) {
//                    updatedEmployeeDocument.getDocType().setName(employeeDocument.getDocType().getName());
//                }
//                // docNumber
//                if (Objects.nonNull(employeeDocument.getDocNumber())) {
//                    updatedEmployeeDocument.setDocNumber(employeeDocument.getDocNumber());
//                }
//                // docDate
//                if (Objects.nonNull(employeeDocument.getDocDate())) {
//                    updatedEmployeeDocument.setDocDate(employeeDocument.getDocDate());
//                }
//                // todo реализовать добавление документа к сотруднику
//                updatedEmployeeDocument.setEmployee(updatedEmployee);
//            }
//            // CountryCatalog если указано гражданство через код государства
//            CountryEntity country = employee.getCountry();
//            if (Objects.nonNull(country)) {
//                country = countryDao.getByCode(country.getCode());
//                updatedEmployee.setCountry(country);
//            }
//            // фиксируем изменения
//            em.merge(updatedEmployee);
//        }
//    }

 //   @Override
 //   public void save(EmployeeEntity employee) {
 //       DocEmployeeEntity docEmployee = employee.getDocEmployee();
 //       if (Objects.nonNull(docEmployee)) {
 //           // если указан тип документа удост. личность
 //           TypeDocumentEntity docType = docEmployee.getDocType();
 //           if (Objects.nonNull(docType)) {
 //               docType
 //                       = typeDocumentDao.getByCode(docType.getCode());
  //              docEmployee.setDocType(docType);
  //          }
///
  //          docEmployee.setEmployee(employee);
  //      }

  //      CountryEntity country = employee.getCountry();
  //      if (Objects.nonNull(country)) {
  //          country = countryDao.getByCode(country.getCode());
  //          employee.setCountry(country);
  //      }

  //      em.persist(employee);


  //  }

    @Override
    public void save(EmployeeEntity employee) {
        em.persist(employee);
    }
}

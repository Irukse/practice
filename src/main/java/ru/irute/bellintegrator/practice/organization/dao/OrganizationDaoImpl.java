package ru.irute.bellintegrator.practice.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.irute.bellintegrator.practice.organization.entity.OrganizationEntity;

import javax.persistence.EntityManager;
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
            //убираем из дао
    public void update(OrganizationEntity organizationEntity) {
         //   все проверить
        OrganizationEntity existingOrg = em.find(OrganizationEntity.class, organizationEntity.getId());
        if (Objects.nonNull(organizationEntity.getName())) {
            existingOrg.setName(organizationEntity.getName());
        }
        if (Objects.nonNull(organizationEntity.getFullName())) {
            existingOrg.setFullName(organizationEntity.getFullName());
        }
        if (Objects.nonNull(organizationEntity.getInn())) {
            existingOrg.setInn(organizationEntity.getInn());
        }
        if (Objects.nonNull(organizationEntity.getKpp())) {
            existingOrg.setKpp(organizationEntity.getKpp());
        }
        if (Objects.nonNull(organizationEntity.getAddress())) {
            existingOrg.setAddress(organizationEntity.getAddress());
        }
        if (Objects.nonNull(organizationEntity.getPhone())) {
            existingOrg.setPhone(organizationEntity.getPhone());
        }

        existingOrg.setIsActive(true);
    }

    @Override
    public List<OrganizationEntity> all() {
        return em.createQuery("SELECT o FROM Organization o", OrganizationEntity.class).getResultList();
    }
}

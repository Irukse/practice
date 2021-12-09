package ru.irute.bellintegrator.practice.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.irute.bellintegrator.practice.organization.entity.Organization;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDao(EntityManager em){ this.em = em;}



    public Organization getById(Long id){
        return em.find(Organization.class, id);
    }

    public void save(Organization organization) {
        em.persist(organization);
    }


    public void update(Organization organization) {
        Organization existingOrg = em.find(Organization.class, organization.getId());
        existingOrg.setName(organization.getName());
        existingOrg.setFullName(organization.getFullName());
        existingOrg.setInn(organization.getInn());
        existingOrg.setKpp(organization.getKpp());
        existingOrg.setAddress(organization.getAddress());
        existingOrg.setPhone(organization.getPhone());
        existingOrg.setIsActive(true);
    }


    public List<Organization> all() {
        return em.createQuery("SELECT o FROM Organization o", Organization.class).getResultList();
    }
}

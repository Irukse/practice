package ru.irute.bellintegrator.practice.organization.dao;

import ru.irute.bellintegrator.practice.organization.entity.OrganizationEntity;

import java.util.List;


public interface OrganizationDao {
    /**
     * Получить OrganizationEntity по идентификатору
     */
     OrganizationEntity getById(Long id);

    /**
     * сохранить организацию
     */
     void save(OrganizationEntity organizationEntity);

    /**
     * Получить все объекты OrganizationEntity
     */
     List<OrganizationEntity> all();

    /**Получить список организации, отсортированных по параметрам name/inn/isActive
     *@return
     */
    List<OrganizationEntity> getList(OrganizationEntity organization);
}

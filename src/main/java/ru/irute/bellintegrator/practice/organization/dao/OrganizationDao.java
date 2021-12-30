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
     * обновить данные об организации
     */
     void update(OrganizationEntity organizationEntity);

    /**
     * Получить все объекты OrganizationEntity
     */
     List<OrganizationEntity> all();
}

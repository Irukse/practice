package ru.irute.bellintegrator.practice.organization.dao;

import ru.irute.bellintegrator.practice.organization.entity.Organization;

import java.util.List;


public interface OrganizationDao {
    /**
     * Получить Organization по идентификатору
     */
     Organization getById(Long id);

    /**
     * сохранить организацию
     */
     void save(Organization organization);

    /**
     * обновить данные об организации
     */
     void update(Organization organization);

    /**
     * Получить все объекты Organization
     */
     List<Organization> all();
}

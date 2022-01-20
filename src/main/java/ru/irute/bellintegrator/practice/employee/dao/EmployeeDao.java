package ru.irute.bellintegrator.practice.employee.dao;

import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    /**
     * список работников
     * @return
     */
   List<EmployeeEntity> list(Map<String, Object> map);

    /**
     * Получить User по идентификатору
     *
     * @param id
     * @return
     */
    EmployeeEntity getUserById(Long id);

    /**
     * добавить сотрудника
     * @param employee
     */
    void save(EmployeeEntity employee);
}

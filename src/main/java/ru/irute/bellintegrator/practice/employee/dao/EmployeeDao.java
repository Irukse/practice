package ru.irute.bellintegrator.practice.employee.dao;

import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    /**
     * список работников
     * @return
     */
 //   List<EmployeeEntity> list(Map<String, Object> map);

    /**
     * найти сотрудника по id
     * @param id
     * @return
     */
    EmployeeEntity getById(Long id);

    /**
     * обновить данные сотрудника
  //   * @param employee
     */
 //   void update(EmployeeEntity employee);

    /**
     * добавить сотрудника
     * @param employee
     */
    void save(EmployeeEntity employee);
}

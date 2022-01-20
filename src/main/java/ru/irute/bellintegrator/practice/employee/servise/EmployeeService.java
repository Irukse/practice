package ru.irute.bellintegrator.practice.employee.servise;

import ru.irute.bellintegrator.practice.employee.dao.EmployeeDao;
import ru.irute.bellintegrator.practice.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    /**
     *найти работника по id
     */
 //   EmployeeDto getEmployee(Long id);

    /**
     *список всех работников, отсортированный по офису и т.д.
     */
  List<EmployeeDto> list(EmployeeDto empl);

    /**
     * обновить информацию о работнике
     */
  //  void update(EmployeeDto empl);

    /**
     * добавить работника
     */
    void save(EmployeeDto employeeDto);

    /**
     * список всех работников
     */
   // List<EmployeeDto> all();

}

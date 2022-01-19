package ru.irute.bellintegrator.practice.employee.servise;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.irute.bellintegrator.practice.Mapper.ObjectMapperUtils;
import ru.irute.bellintegrator.practice.country.dao.CountryDaoImpl;
import ru.irute.bellintegrator.practice.country.entity.CountryEntity;
import ru.irute.bellintegrator.practice.employee.dao.EmployeeDaoImpl;
import ru.irute.bellintegrator.practice.employee.dto.EmployeeDto;
import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;
import ru.irute.bellintegrator.practice.offise.dao.OfficeDaoImpl;
import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;

import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final OfficeDaoImpl officeDao;
    private final EmployeeDaoImpl employeeDao;
    private final CountryDaoImpl countryDao;

    public EmployeeServiceImpl(OfficeDaoImpl officeDao, EmployeeDaoImpl employeeDao, CountryDaoImpl countryDao) {
        this.officeDao = officeDao;
        this.employeeDao = employeeDao;
        this.countryDao = countryDao;
    }

    @Override
    @Transactional
    public void save(EmployeeDto employeeDto) {
        Long id = employeeDto.getOfficeId();

        OfficeEntity office= officeDao.getOffice(id);

        EmployeeEntity employee = ObjectMapperUtils.map(employeeDto, EmployeeEntity.class);
        employeeDao.save(employee);

        office.addEmployee(employee);
        CountryEntity country = employee.getCountry();
             if (Objects.nonNull(country)) {
                  country = countryDao.getByCode(country.getCode());
                  employee.setCountry(country);
              }


    }
}

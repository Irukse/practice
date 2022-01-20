package ru.irute.bellintegrator.practice.employee.servise;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.irute.bellintegrator.practice.Mapper.ObjectMapperUtils;
import ru.irute.bellintegrator.practice.country.dao.CountryDaoImpl;
import ru.irute.bellintegrator.practice.country.entity.CountryEntity;
import ru.irute.bellintegrator.practice.docEmployee.dao.DocEmployeeDaoImpl;
import ru.irute.bellintegrator.practice.docEmployee.entity.DocEmployeeEntity;
import ru.irute.bellintegrator.practice.employee.dao.EmployeeDaoImpl;
import ru.irute.bellintegrator.practice.employee.dto.EmployeeDto;
import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;
import ru.irute.bellintegrator.practice.offise.dao.OfficeDaoImpl;
import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;
import ru.irute.bellintegrator.practice.typeDocument.dao.TypeDocumentDao;
import ru.irute.bellintegrator.practice.typeDocument.entity.TypeDocumentEntity;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final OfficeDaoImpl officeDao;
    private final EmployeeDaoImpl employeeDao;
    private final CountryDaoImpl countryDao;
    private final TypeDocumentDao typeDocumentDao;
    private final DocEmployeeDaoImpl docEmployeeDao;

    public EmployeeServiceImpl(OfficeDaoImpl officeDao, EmployeeDaoImpl employeeDao, CountryDaoImpl countryDao, TypeDocumentDao typeDocumentDao, DocEmployeeDaoImpl docEmployeeDao) {
        this.officeDao = officeDao;
        this.employeeDao = employeeDao;
        this.countryDao = countryDao;
        this.typeDocumentDao = typeDocumentDao;
        this.docEmployeeDao = docEmployeeDao;
    }

    @Override
    @Transactional
    public List<EmployeeDto> list(EmployeeDto emp) {
        Map<String, Object> map = new HashMap<>();
        if (Objects.nonNull(emp)) {
            map.put("officeId", emp.getOfficeId());
            map.put("firstName", emp.getFirstName());
            map.put("secondName", emp.getSecondName());
            map.put("middleName", emp.getLastName());
            map.put("position", emp.getPosition());
            map.put("docCode", emp.getDocCode());
            map.put("citizenshipCode", emp.getCitizenshipCode());
        }
        List<EmployeeEntity> employees = employeeDao.list(map);
        return ObjectMapperUtils.mapAll(employees, EmployeeDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save (EmployeeDto employeeDto) {

        EmployeeEntity user = ObjectMapperUtils.map(employeeDto, EmployeeEntity.class);
        OfficeEntity office = officeDao.getOffice(employeeDto.officeId);
        TypeDocumentEntity docType = typeDocumentDao.getDocTypeByCode(employeeDto.getDocCode());

        DocEmployeeEntity doc = new DocEmployeeEntity(docType, employeeDto.docNumber, employeeDto.docDate);
        List<DocEmployeeEntity> docList = user.getDocId();
        docList.add(doc);
        user.setOfficeId(office);
        user.setDocId(docList);

              CountryEntity country = user.getCountry();
              if (Objects.nonNull(country)) {
                 country = countryDao.getByCode(country.getCode());
                  user.setCountry(country);
             }

        employeeDao.save(user);
    }

}
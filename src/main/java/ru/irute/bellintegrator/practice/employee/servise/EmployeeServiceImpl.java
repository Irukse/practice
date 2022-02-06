package ru.irute.bellintegrator.practice.employee.servise;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.irute.bellintegrator.practice.Mapper.ObjectMapperUtils;
import ru.irute.bellintegrator.practice.country.dao.CountryDao;
import ru.irute.bellintegrator.practice.country.dao.CountryDaoImpl;
import ru.irute.bellintegrator.practice.country.entity.CountryEntity;
import ru.irute.bellintegrator.practice.docEmployee.dao.DocEmployeeDao;
import ru.irute.bellintegrator.practice.docEmployee.dao.DocEmployeeDaoImpl;
import ru.irute.bellintegrator.practice.docEmployee.entity.DocEmployeeEntity;
import ru.irute.bellintegrator.practice.employee.dao.EmployeeDao;
import ru.irute.bellintegrator.practice.employee.dao.EmployeeDaoImpl;
import ru.irute.bellintegrator.practice.employee.dto.EmployeeDto;
import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;
import ru.irute.bellintegrator.practice.offise.dao.OfficeDao;
import ru.irute.bellintegrator.practice.offise.dao.OfficeDaoImpl;
import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;
import ru.irute.bellintegrator.practice.typeDocument.dao.TypeDocumentDao;
import ru.irute.bellintegrator.practice.typeDocument.entity.TypeDocumentEntity;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final OfficeDao officeDao;
    private final EmployeeDao employeeDao;
    private final CountryDao countryDao;
    private final TypeDocumentDao typeDocumentDao;
    private final DocEmployeeDao docEmployeeDao;

    public EmployeeServiceImpl(OfficeDao officeDao, EmployeeDao employeeDao, CountryDao countryDao, TypeDocumentDao typeDocumentDao, DocEmployeeDao docEmployeeDao) {
        this.officeDao = officeDao;
        this.employeeDao = employeeDao;
        this.countryDao = countryDao;
        this.typeDocumentDao = typeDocumentDao;
        this.docEmployeeDao = docEmployeeDao;
    }

    @Override
    public EmployeeDto getEmployeeToId(Long id) {

            EmployeeEntity employeeEntity = employeeDao.getUserById(id);
            DocEmployeeEntity doc = docEmployeeDao.getDocumentsByFilter(employeeEntity.getId());
            TypeDocumentEntity docType = doc.getDocType();
            CountryEntity countryEntity = countryDao.getByCode(employeeEntity.getCountry().getCode());

            EmployeeDto employeeDto = mapUser(employeeEntity);
            employeeDto.docName = docType.getName();
            employeeDto.docNumber = doc.getDocNumber();
            employeeDto.docDate = doc.getDocDate();
            employeeDto.citizenshipName = countryEntity.getName();
            employeeDto.citizenshipCode = countryEntity.getCode();

            return employeeDto;

    }

    @Override
    @Transactional
    public List<EmployeeDto> list(EmployeeDto employeeDto) {
        Map<String, Object> map = new HashMap<>();
        if (Objects.nonNull(employeeDto)) {
            map.put("officeId", employeeDto.getOfficeId());
            map.put("firstName", employeeDto.getFirstName());
            map.put("secondName", employeeDto.getSecondName());
            map.put("middleName", employeeDto.getLastName());
            map.put("position", employeeDto.getPosition());
            // нет в EmployeeEntity
            map.put("docCode", employeeDto.getDocCode());
            map.put("citizenshipCode", employeeDto.getCitizenshipCode());
        }
        List<Object> employees = Collections.singletonList(employeeDao.list(map));
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
        // находим тип документа в бд исходя из введенных данных EmployeeDto.docCode
        TypeDocumentEntity docType = typeDocumentDao.getDocTypeByCode(employeeDto.docCode);
        // через конструктор добавляем данные в DocEmployeeEntity

        try {
            DocEmployeeEntity doc = new DocEmployeeEntity(user, docType, employeeDto.docNumber, employeeDto.docDate);
            List<DocEmployeeEntity> docList = user.getDocId();
            docList.add(doc);
            user.setDocId(docList);
        }
        catch (NullPointerException e){
            System.out.println("Тип документа не найден");
        }

        user.setOfficeId(office);
        CountryEntity country =  user.getCountry();
              if (Objects.nonNull(country)) {
                  try {
                      country = countryDao.getByCode(country.getCode());
                      user.setCountry(country);
                  }
                  catch (NullPointerException e){
                      System.out.println("Код страны не найден");
                  }

             }

        employeeDao.save(user);
    }

    private EmployeeDto mapUser(EmployeeEntity employeeEntity) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
        mapperFactory.classMap(EmployeeEntity.class, EmployeeDto.class).exclude("officeId").exclude("docId").mapNulls(false).byDefault().register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        EmployeeDto employeeDto = mapperFacade.map(employeeEntity, EmployeeDto.class);

        return employeeDto;
    }

}
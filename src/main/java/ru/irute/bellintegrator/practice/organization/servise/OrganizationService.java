package ru.irute.bellintegrator.practice.organization.servise;


import io.swagger.models.properties.Property;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.irute.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;
import ru.irute.bellintegrator.practice.organization.entity.Organization;
import springfox.documentation.schema.ModelProperty;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrganizationService {

    private final OrganizationDao organizationDao;
    private final OrganizationService organizationService;


    @Autowired
    public OrganizationService(OrganizationDao organizationDao, OrganizationService organizationService) {
        this.organizationDao = organizationDao;
        this.organizationService = organizationService;

    }

    /**
     * конвертировать лист объектов Организаций в лист объектов Dto
     */

    public List<OrganizationDto> orgToDto (List <Organization> organizationList) {
     return organizationList.stream().map(x->convertEntityToDto(x)).collect(Collectors.toList());
    }

    /**
     * конвертировать лист объектов Dto в лист  объектов Организаций
     */

    public List<Organization> DtoToOrg (List <OrganizationDto> organizationDtoList) {
        return organizationDtoList.stream().map(x->convertToDtoToEntity(x)).collect(Collectors.toList());
    }

    /**
     * конвертировать лист объектов Организаций в лист объектов Dto
     */

    /**
     * получить список организаций
     */

    public List<OrganizationDto> listAll(){
        List<Organization> orgAll=organizationDao.all();
        return organizationService.orgToDto(orgAll);
    }

    /**
     * сохранить организацию
     */
       public void save (OrganizationDto organizationDto){
           Organization organization;
           organization = organizationService.convertToDtoToEntity(organizationDto);
           organizationDao.save(organization);
   }

    /**
     * конвертировать объект Entity в объект Dto
     */

    private OrganizationDto convertEntityToDto(Organization organization){
        OrganizationDto oDto = new OrganizationDto();
        oDto.setId(organization.getId());
        oDto.setName(organization.getName());
        oDto.setFullName(organization.getFullName());
        oDto.setInn(organization.getInn());
        oDto.setKpp(organization.getKpp());
        oDto.setAddress(organization.getAddress());
        oDto.setPhone(organization.getPhone());
        oDto.setActive(organization.getActive());
        oDto.setVersion(organization.getVersion());
        return oDto;
    }
    /**
     * конвертировать объект Dto в объект Entity
     */

    private Organization convertToDtoToEntity(OrganizationDto orgDto){

        Organization org = new Organization();
        org.setId(orgDto.getId());
        org.setName(orgDto.getName());
        org.setFullName(orgDto.getFullName());
        org.setInn(orgDto.getInn());
        org.setKpp(orgDto.getKpp());
        org.setAddress(orgDto.getAddress());
        org.setPhone(orgDto.getPhone());
        org.setActive(orgDto.getActive());
        org.setVersion(orgDto.getVersion());
        return org;
    }
}

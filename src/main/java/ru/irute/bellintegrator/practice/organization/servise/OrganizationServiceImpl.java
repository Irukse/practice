package ru.irute.bellintegrator.practice.organization.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.irute.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;
import ru.irute.bellintegrator.practice.organization.entity.Organization;
import org.modelmapper.ModelMapper;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class OrganizationService {

    private final OrganizationDao organizationDao;
    private final ModelMapper modelMapper;

    @Autowired
    public OrganizationService(OrganizationDao organizationDao, ModelMapper modelMapper) {
        this.organizationDao = organizationDao;
        this.modelMapper = modelMapper;
    }

    /**
     * сохранить организацию
     */
    public void  save(OrganizationDto orgDto ){
        Organization org = modelMapper.map(orgDto , Organization.class);
        organizationDao.save(org);
    }

    /**
     * получить список организаций
     */
    public List<OrganizationDto> listAll(){
        List<Organization> orgAll=organizationDao.all();
        List <OrganizationDto> organizationDto;
        organizationDto= orgAll.stream().map(x->convertEntityToDto(x)).collect(Collectors.toList());
        return organizationDto;
    }

    /**
     * обновить данные об организации
     */
    public void update (OrganizationDto orgDto ){
        Organization org = modelMapper.map(orgDto , Organization.class);
        organizationDao.update(org);
    }
    /**
     * конвертировать объект Entity в объект Dto
     */
    private OrganizationDto convertEntityToDto(Organization organization){
        OrganizationDto oDto;
        oDto = modelMapper.map(organization, OrganizationDto.class);
        return oDto;
    }

    /**
     * конвертировать объект Dto в объект Entity
     */
    private Organization convertToDtoToEntity(OrganizationDto orgDto){
        Organization org;
        org = modelMapper.map(orgDto, Organization.class);
        return org;
    }
}

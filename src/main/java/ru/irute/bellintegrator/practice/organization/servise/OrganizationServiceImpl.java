package ru.irute.bellintegrator.practice.organization.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.irute.bellintegrator.practice.organization.dao.OrganizationDaoImpl;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;
import ru.irute.bellintegrator.practice.organization.entity.Organization;
import org.modelmapper.ModelMapper;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationDaoImpl organizationDao;
    private final ModelMapper modelMapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationDaoImpl organizationDao, ModelMapper modelMapper) {
        this.organizationDao = organizationDao;
        this.modelMapper = modelMapper;
    }


    @Override
    public OrganizationDto getById(Long id) {
        Organization organization = organizationDao.getById(id);
        return modelMapper.map(organization, OrganizationDto.class);
    }

    @Override
    public void  save(OrganizationDto orgDto ){
        Organization org = modelMapper.map(orgDto , Organization.class);
        organizationDao.save(org);
    }

    @Override
    public List<OrganizationDto> listAll(){
        List<Organization> orgAll=organizationDao.all();
        List <OrganizationDto> organizationDto;
        organizationDto= orgAll.stream().map(x->convertEntityToDto(x)).collect(Collectors.toList());
        return organizationDto;
    }


    @Override
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

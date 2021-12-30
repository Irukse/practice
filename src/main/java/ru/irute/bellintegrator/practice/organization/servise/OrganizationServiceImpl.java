package ru.irute.bellintegrator.practice.organization.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.irute.bellintegrator.practice.organization.dao.OrganizationDaoImpl;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;
import ru.irute.bellintegrator.practice.organization.entity.OrganizationEntity;
import org.modelmapper.ModelMapper;

import java.util.List;

import java.util.Objects;
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
    @Transactional
    public OrganizationDto getById(Long id) {
        OrganizationEntity organizationEntity = organizationDao.getById(id);
        return modelMapper.map(organizationEntity, OrganizationDto.class);
    }

    @Override
    @Transactional
    public void  save(OrganizationDto orgDto ){
        OrganizationEntity org = modelMapper.map(orgDto , OrganizationEntity.class);
        organizationDao.save(org);
    }

    @Override
   public List<OrganizationDto> listAll(){
        // просто лист организаций, а не все организации посмотреть тз
        List<OrganizationEntity> orgAll=organizationDao.all();
        List <OrganizationDto> organizationDto;
        organizationDto= orgAll.stream().map(x->convertEntityToDto(x)).collect(Collectors.toList());
        return organizationDto;
    }

    @Override
    @Transactional
    public List<OrganizationDto> getList(OrganizationDto orgDto) {
        OrganizationEntity org = modelMapper.map(orgDto , OrganizationEntity.class);
        List<OrganizationEntity> list = organizationDao.getList(org);
        List <OrganizationDto> organizationDto;
        organizationDto = list.stream().map(x->convertEntityToDto(x)).collect(Collectors.toList());
        return organizationDto;
    }


    @Override
    @Transactional
    public void update (OrganizationDto orgDto ){
      OrganizationEntity org = modelMapper.map(orgDto , OrganizationEntity.class);
      Long id = org.getId();
      OrganizationEntity existingOrg= organizationDao.getById(id);
        if (Objects.nonNull(existingOrg)) {
            if (Objects.nonNull(org.getName())) {
                existingOrg.setName(org.getName());
            }
            if (Objects.nonNull(org.getFullName())) {
                existingOrg.setFullName(org.getFullName());
            }
            if (Objects.nonNull(org.getInn())) {
                existingOrg.setInn(org.getInn());
            }
            if (Objects.nonNull(org.getKpp())) {
                existingOrg.setKpp(org.getKpp());
            }
            if (Objects.nonNull(org.getAddress())) {
                existingOrg.setAddress(org.getAddress());
            }
            if (Objects.nonNull(org.getPhone())) {
                existingOrg.setPhone(org.getPhone());
            }

            existingOrg.setIsActive(true);
        }
        organizationDao.save(org);
    }

    /**
     * конвертировать объект Entity в объект Dto
     */
    private OrganizationDto convertEntityToDto(OrganizationEntity organizationEntity){
        OrganizationDto oDto;
        oDto = modelMapper.map(organizationEntity, OrganizationDto.class);
        return oDto;
    }

    /**
     * конвертировать объект Dto в объект Entity
     */
    private OrganizationEntity convertToDtoToEntity(OrganizationDto orgDto){
        OrganizationEntity org;
        org = modelMapper.map(orgDto, OrganizationEntity.class);
        return org;
    }
}

package ru.irute.bellintegrator.practice.offise.servise;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.irute.bellintegrator.practice.Mapper.ObjectMapperUtils;
import ru.irute.bellintegrator.practice.offise.dao.OfficeDao;
import ru.irute.bellintegrator.practice.offise.dao.OfficeDaoImpl;
import ru.irute.bellintegrator.practice.offise.dto.OfficeDto;
import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;
import ru.irute.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.irute.bellintegrator.practice.organization.dao.OrganizationDaoImpl;
import ru.irute.bellintegrator.practice.organization.entity.OrganizationEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class OfficeServiseImpl implements OfficeServise{

    private final OfficeDao officeDao;
    private final OrganizationDao organizationDao;
    private final ModelMapper modelMapper;


    public OfficeServiseImpl(OfficeDao officeDao, OrganizationDao organizationDao, ModelMapper modelMapper) {
        this.officeDao = officeDao;
        this.organizationDao = organizationDao;
        this.modelMapper = modelMapper;
    }



    @Override
    @Transactional
    public void save(OfficeDto officeDto) {

        Long id = officeDto.getOrgId();
        OrganizationEntity organizationEntity =  organizationDao.getById(id);

        OfficeEntity office = ObjectMapperUtils.map(officeDto, OfficeEntity.class);
        office.setOrganization(organizationEntity);
        organizationEntity.addOffice(office);
        officeDao.save(office);
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeDto getOffice(Long id){
        OfficeEntity officeEntity = officeDao.getOffice(id);
        return ObjectMapperUtils.map(officeEntity, OfficeDto.class);
    }

    @Override
    @Transactional
    public List<OfficeDto> list(OfficeDto officeDto) {
        Map<String,Object> map = new HashMap<>();
        if(Objects.nonNull(officeDto)){
            map.put("orgId", officeDto.getOrgId());
            map.put("name", officeDto.getName());
            map.put("phone", officeDto.getPhone());
            map.put("isActive", officeDto.getActive());
        }
        List<OfficeEntity> list = officeDao.list(map);
        return ObjectMapperUtils.mapAll(list, OfficeDto.class);
    }


    @Override
    @Transactional
    public void update(OfficeDto officeDto) {
        OfficeEntity office = ObjectMapperUtils.map(officeDto, OfficeEntity.class);
        Long id = office.getId();
        OfficeEntity existingOff = officeDao.getOffice(id);
        if (Objects.nonNull(existingOff)) {
            if (Objects.nonNull(office.getName())) {
                existingOff.setName(office.getName());
            }
            if (Objects.nonNull(office.getAddress())) {
                existingOff.setAddress(office.getAddress());
            }
            if (Objects.nonNull(office.getPhone())) {
                existingOff.setPhone(office.getPhone());
            }
            existingOff.setActive(true);
        }
        officeDao.save(office);

    }

}

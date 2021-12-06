package ru.irute.bellintegrator.practice.organization.servise;


import org.springframework.stereotype.Service;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;
import ru.irute.bellintegrator.practice.organization.entity.Organization;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationService {

    public List<OrganizationDto> orgToDto (List <Organization> organizationList) {
     return organizationList.stream().map(x->convertEntityToDto(x)).collect(Collectors.toList());
    }

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
}

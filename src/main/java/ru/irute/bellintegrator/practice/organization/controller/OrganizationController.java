package ru.irute.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.irute.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;
import ru.irute.bellintegrator.practice.organization.entity.Organization;
import ru.irute.bellintegrator.practice.organization.servise.OrganizationService;

import java.util.List;

@RestController
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private OrganizationDao organizationDao;

    public List<OrganizationDto> all(){
        List<Organization> orgAll=organizationDao.all();
        return organizationService.orgToDto(orgAll);
    }



}

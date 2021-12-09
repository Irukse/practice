package ru.irute.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;
import ru.irute.bellintegrator.practice.organization.servise.OrganizationService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService orgService){ this.organizationService = orgService;}

    @PostMapping("/list")
    public List<OrganizationDto> all(){
        List<OrganizationDto> orgAll= organizationService.listAll();
        return orgAll;
    }
      @PostMapping("/save")
    public boolean save(@RequestBody OrganizationDto organizationDto){
      organizationService.save(organizationDto);
      return true;
    }

}

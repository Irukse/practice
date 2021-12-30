package ru.irute.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;
import ru.irute.bellintegrator.practice.organization.servise.OrganizationServiceImpl;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationServiceImpl organizationService;

    @Autowired
    public OrganizationController(OrganizationServiceImpl orgService){
        this.organizationService = orgService;}

    @PostMapping("/list")
    public List<OrganizationDto> all(){
        List<OrganizationDto> orgAll= organizationService.listAll();
        return orgAll;
    }
    @PostMapping("/save")
    public void save(@RequestBody OrganizationDto organizationDto){
        organizationService.save(organizationDto);
    }
    @PostMapping("/update")
    public void update (@RequestBody OrganizationDto organizationDto){
        organizationService.update(organizationDto);

    }
    @GetMapping("/{id}")
    public OrganizationDto getById(@PathVariable("id") Long orgId){
        return organizationService.getById(orgId);
    }
    @PostMapping("/list")
    public List<OrganizationDto> getList(@RequestBody OrganizationDto organizationDto){
        return organizationService.getList(organizationDto);
    }



}

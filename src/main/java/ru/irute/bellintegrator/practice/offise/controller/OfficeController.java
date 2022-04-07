package ru.irute.bellintegrator.practice.offise.controller;

import org.springframework.web.bind.annotation.*;
import ru.irute.bellintegrator.practice.offise.dto.OfficeDto;
import ru.irute.bellintegrator.practice.offise.servise.OfficeServise;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeServise officeServise;

    public OfficeController(OfficeServise officeServise) {
        this.officeServise = officeServise;
    }

    @PostMapping("/save")
    public void save(@RequestBody OfficeDto officeDto){
        officeServise.save(officeDto);
    }

    @PostMapping("/update")
    public void update (@RequestBody OfficeDto officeDto){
        officeServise.update(officeDto);
    }

    @GetMapping("/{id}")
    public OfficeDto getById(@PathVariable("id") Long offId){
        return officeServise.getOffice(offId);
    }

    @PostMapping("/list")
    public List<OfficeDto> getList(@RequestBody OfficeDto officeDto){
        return officeServise.list(officeDto);
    }
}

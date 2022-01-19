package ru.irute.bellintegrator.practice.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.irute.bellintegrator.practice.country.dto.CountryDto;
import ru.irute.bellintegrator.practice.country.servise.CountryServiceImpl;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class CountryController {
    private final CountryServiceImpl countryService;

    @Autowired
    public CountryController(CountryServiceImpl countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<CountryDto> getListOfCountries(){
        return countryService.getList();
    }

}

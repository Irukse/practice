package ru.irute.bellintegrator.practice.country.servise;


import ru.irute.bellintegrator.practice.country.dto.CountryDto;

import java.util.List;

public interface CountryService {
    /**
     * получить список стран
     */
    List<CountryDto> getList();
}

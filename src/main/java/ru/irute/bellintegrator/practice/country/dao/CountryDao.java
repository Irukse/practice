package ru.irute.bellintegrator.practice.country.dao;

import ru.irute.bellintegrator.practice.country.entity.CountryEntity;

import java.util.List;

public interface CountryDao {
    /**
     * список стран
     * @return
     */
    List<CountryEntity> all();

    /**
     * получить страну по code
     */
    CountryEntity getByCode(String code);
}

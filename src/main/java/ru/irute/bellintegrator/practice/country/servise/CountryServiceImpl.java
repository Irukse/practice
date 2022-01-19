package ru.irute.bellintegrator.practice.country.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.irute.bellintegrator.practice.Mapper.ObjectMapperUtils;
import ru.irute.bellintegrator.practice.country.dao.CountryDao;
import ru.irute.bellintegrator.practice.country.dto.CountryDto;
import ru.irute.bellintegrator.practice.country.entity.CountryEntity;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryDao countryDao;


    @Autowired
    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public List<CountryDto> getList() {
        List<CountryEntity> list  = countryDao.all();
        return ObjectMapperUtils.mapAll(list, CountryDto.class);
    }
}



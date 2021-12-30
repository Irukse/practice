package ru.irute.bellintegrator.practice.organization.servise;

import org.springframework.validation.annotation.Validated;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;

import java.util.List;
@Validated
public interface OrganizationService {

    /**
     *получить организации по id
     */

    OrganizationDto getById(Long id);

    /**
     *сохранить организацию
     */
    void save(OrganizationDto getDto);

    /**
     * обновить данные организации
     */
    void update(OrganizationDto getDto);

    /**
     * получить список всех организаций
     */
    List<OrganizationDto> listAll();
    /**
     * получить список организаций,отсортированных по параметрам name/inn/isActive
     */
    List<OrganizationDto> getList(OrganizationDto orgView);
}

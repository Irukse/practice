package ru.irute.bellintegrator.practice.offise.servise;

import ru.irute.bellintegrator.practice.offise.dto.OfficeDto;

import java.util.List;

public interface OfficeServise {
    /**
     *Добавить офис в БД
     */
    void save (OfficeDto officeDto);

    /**
     * найти офис по id
     */
    OfficeDto getOffice(Long id);

    /**
     * Получить список офисов, принадлежащих конкретной организации,
     * который можно отсортировать по name/phone/isActive
     */
    List<OfficeDto> list(OfficeDto officeDto);

    /**
     * Обновить информацию об офисе
     */
    void update (OfficeDto officeDto);

}

package ru.irute.bellintegrator.practice.offise.dao;

import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;

import java.util.List;
import java.util.Map;

public interface OfficeDao {
    /**
     * получить офис по его id
     * @param id
     * @return
     */
    OfficeEntity getOffice(Long id);

    /**
     * обновить данные офиса
     * @param office
     */
  //  void update(OfficeEntity office);

    /**
     * сохранить новый офис
     * @param office
     */
    void save(OfficeEntity office);

    /**
     * получить список офисов,принадлежищих к организации, по ее id
     * @param map
     * @return
     */
    List<OfficeEntity> list(Map<String,Object> map);

}

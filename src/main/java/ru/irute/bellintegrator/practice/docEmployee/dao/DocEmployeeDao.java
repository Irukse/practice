package ru.irute.bellintegrator.practice.docEmployee.dao;


import ru.irute.bellintegrator.practice.docEmployee.entity.DocEmployeeEntity;

import java.util.List;

/**
 * DAO для работы с документами
 */
public interface DocEmployeeDao {

    /**
     * Получить список всех документов
     *
     * @return
     */
    List<DocEmployeeEntity> getAllDocuments();

    /**
     * Сохранить данные нового документа
     *
     * @param doc
     */
    void saveDocument(DocEmployeeEntity doc);

    /**
     * Обновить данные нового документа
     *
     * @param doc
     */
    void updateDocument(DocEmployeeEntity doc);

    /**
     * Получить список документов по фильтру
     *
     * @return
     */
    DocEmployeeEntity getDocumentsByFilter(Long id);


}

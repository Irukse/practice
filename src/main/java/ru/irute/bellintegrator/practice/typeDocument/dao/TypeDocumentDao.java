package ru.irute.bellintegrator.practice.typeDocument.dao;

import ru.irute.bellintegrator.practice.typeDocument.entity.TypeDocumentEntity;

import java.util.List;

public interface TypeDocumentDao {
    /**
     * вывести список всех типов документов
     * @return
     */
    List<TypeDocumentEntity> getAllDocTypes();

    /**
     * получить тип документа по code
     */
    TypeDocumentEntity getDocTypeByCode (String code);
}

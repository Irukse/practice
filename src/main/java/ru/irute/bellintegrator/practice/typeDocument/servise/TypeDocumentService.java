package ru.irute.bellintegrator.practice.typeDocument.servise;



import ru.irute.bellintegrator.practice.typeDocument.dto.TypeDocumentDto;

import java.util.List;
import java.util.Set;

public interface TypeDocumentService {
    /**
     * Получить список типов документов
     */
    List<TypeDocumentDto> getList();


}

package ru.irute.bellintegrator.practice.typeDocument.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.irute.bellintegrator.practice.Mapper.ObjectMapperUtils;
import ru.irute.bellintegrator.practice.typeDocument.dao.TypeDocumentDao;
import ru.irute.bellintegrator.practice.typeDocument.dto.TypeDocumentDto;
import ru.irute.bellintegrator.practice.typeDocument.entity.TypeDocumentEntity;


import java.util.List;
import java.util.function.Function;

@Service
public class TypeDocumentServiceImpl implements TypeDocumentService {
    private final TypeDocumentDao typeDocumentDao;


    @Autowired
    public TypeDocumentServiceImpl(TypeDocumentDao typeDocumentDao) {
        this.typeDocumentDao = typeDocumentDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeDocumentDto> getList() {
        List<TypeDocumentEntity> list = typeDocumentDao.getAllDocTypes();
        return ObjectMapperUtils.mapAll(list, TypeDocumentDto.class);
    }


}

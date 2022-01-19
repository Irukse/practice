package ru.irute.bellintegrator.practice.typeDocument.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.irute.bellintegrator.practice.typeDocument.dto.TypeDocumentDto;
import ru.irute.bellintegrator.practice.typeDocument.servise.TypeDocumentService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class TypeDocumentController {
    private final TypeDocumentService typeDocumentService;

    @Autowired
    public TypeDocumentController(TypeDocumentService typeDocumentService) {
        this.typeDocumentService = typeDocumentService;
    }

    @GetMapping("/docs")
    public List<TypeDocumentDto> getListOfDocType(){return typeDocumentService.getList();}
}

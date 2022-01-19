package ru.irute.bellintegrator.practice.typeDocument.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TypeDocumentDto {
    /**
     * id в таблице документов
     */
    private Long id;

    /**
     * тип документа
     */
    @Size(max = 50)
    @NotEmpty
    private String name;

    /**
     * код документа
     */
    @Size(max = 2)
    @NotEmpty
    private String code;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

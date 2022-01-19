package ru.irute.bellintegrator.practice.typeDocument.entity;

import javax.persistence.*;
@Entity
@Table(name = "Type_document")

public class TypeDocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *тип документа
     */
    @Column(name = "name_type",length = 10, nullable = false)
    private String name;

    /**
     *код документа
     */
    @Column(name = "code", length = 2, nullable = false)
    private String typeDocCode;

    /**
     * служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     *геттеры и сеттеры
     */
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
        return typeDocCode;
    }

    public void setCode(String code) {
        this.typeDocCode = code;
    }
}

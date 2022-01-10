package ru.irute.bellintegrator.practice.typeDocument.entity;

import javax.persistence.*;
@Entity (name = "Type_document")
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
    @Column(length = 2, nullable = false)
    private String code;

    /**
     * служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     *конструкторы
     */
    public TypeDocumentEntity(){

    }

    public TypeDocumentEntity(String name, String code) {
        this.name = name;
        this.code = code;
    }

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
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

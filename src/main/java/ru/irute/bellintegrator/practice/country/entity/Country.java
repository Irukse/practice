package ru.irute.bellintegrator.practice.country.entity;

import javax.persistence.*;
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    /**
     *название страны
     */
    @Column(length = 25,nullable = false)
    private String name;

    /**
     *код страны
     */
    @Column(length = 3, nullable = false)
    private String code;

    /**
     * служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     *конструкторы
     */
    public Country(){

    }

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     *геттеры и сеттеры
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

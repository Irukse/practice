package ru.irute.bellintegrator.practice.country.entity;

import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class CountryEntity {
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

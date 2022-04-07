package ru.irute.bellintegrator.practice.country.entity;

import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    /**
     *название страны
     */
    @Column(name = "name_country", length = 25,nullable = false)
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

    public CountryEntity(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public CountryEntity() {

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}

package ru.irute.bellintegrator.practice.country.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDto {
    private Long id;

    /**
     * имя страны
     */
    @Size(max = 50)
    private String name;

    /**
     * код страны
     */
    @Size(max = 2)
    private Long code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

}

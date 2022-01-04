package ru.irute.bellintegrator.practice.organization.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationDto {
    private Long id;
    @Size(max = 50)
    @NotNull
    private String name;
    @Size(max = 50)
    @NotNull
    private String fullName;
    @Size(max = 10)
    @NotNull
    private Integer inn;
    @Size(max = 9)
    @NotNull
    private Integer kpp;
    @Size(max = 50)
    @NotNull
    private String address;
    @Size(max = 11)
    private String phone;
    private Boolean isActive;
    private Integer version;
    private List<OfficeEntity> officeEntities;

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<OfficeEntity> getOfficeEntities() {
        return officeEntities;
    }

    public void setOfficeEntities(List<OfficeEntity> officeEntities) {
        this.officeEntities = officeEntities;
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getInn() {
        return inn;
    }

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    public Integer getKpp() {
        return kpp;
    }

    public void setKpp(Integer kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OrganizationDto() {

    }


}

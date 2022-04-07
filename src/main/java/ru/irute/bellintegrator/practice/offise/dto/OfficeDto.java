package ru.irute.bellintegrator.practice.offise.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;
import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;
import ru.irute.bellintegrator.practice.organization.entity.OrganizationEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficeDto {
    private Long id;

    @Size(max = 50)
    @NotNull
    private String name;

    @Size(max = 50)
    @NotNull
    private String address;

    @Size(max = 11)
    private String phone;

    @NotNull
    private Long orgId;

    private Boolean isActive;
    private Integer version;

    public List<EmployeeEntity> employeeEntities;
 //   private OrganizationEntity organization;

 // public OrganizationEntity getOrganization() {
 //       return organization;
 //  }

 //   public void setOrganization(OrganizationEntity organization) {
  //      this.organization = organization;
 //   }

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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

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

    public List<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }
}

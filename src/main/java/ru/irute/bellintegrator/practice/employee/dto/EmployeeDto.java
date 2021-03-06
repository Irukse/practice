package ru.irute.bellintegrator.practice.employee.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {
    public Long id;

    @Size(max = 50)
    @NotEmpty
    public String firstName;

    @Size(max = 50)
    public String secondName;

    @Size(max = 50)
    public String lastName;

    @Size(max = 50)
    @NotEmpty
    public String position;

    @Size(max = 11)
    public String phone;

// берем из Type_document
    @NotEmpty
    public String docCode;

    // берем из Type_document typeDocCode
    @NotEmpty
    public String docName;

// берем из Doc_employee
    @NotEmpty
    public Long docNumber;

    @NotEmpty
    public String docDate;
// имя страны  берем из Country
    @NotEmpty
    public String citizenshipName;
// код страны берем из Country
    @NotEmpty
    public String citizenshipCode;

    @NotNull
    public Boolean isIdentified;

    public Long officeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Long getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(Long docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }
}

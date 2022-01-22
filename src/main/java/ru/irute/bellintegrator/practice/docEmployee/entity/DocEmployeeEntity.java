package ru.irute.bellintegrator.practice.docEmployee.entity;

import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;
import ru.irute.bellintegrator.practice.typeDocument.entity.TypeDocumentEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Doc_employee")
public class DocEmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * служебное поле hibernate
     */
    @Version
    private Integer version;

    @Column(name = "doc_number", nullable = false)
    private Long docNumber;

    @Column(name = "doc_date", length = 50, nullable = false)
    private String docDate;

    /**
     * Код типа документа
     */
    @OneToOne
    @JoinColumn(name = "type_id")
    private TypeDocumentEntity docType;

    /**
     *  Документы работника
     */

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private EmployeeEntity employee;

    public DocEmployeeEntity() {

    }

    public DocEmployeeEntity(EmployeeEntity user, TypeDocumentEntity docType, Long docNumber, String docDate) {
        this.docType = docType;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.employee = user;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public TypeDocumentEntity getDocType() {
        return docType;
    }

    public void setDocType(TypeDocumentEntity docType) {
        this.docType = docType;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}

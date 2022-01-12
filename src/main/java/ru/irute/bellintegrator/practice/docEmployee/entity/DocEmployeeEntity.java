package ru.irute.bellintegrator.practice.docEmployee.entity;

import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;
import ru.irute.bellintegrator.practice.typeDocument.entity.TypeDocumentEntity;

import javax.persistence.*;

@Entity (name = "Doc_employee")

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private TypeDocumentEntity docType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    private EmployeeEntity employee;


    public DocEmployeeEntity(){

    }

    public DocEmployeeEntity(Long docNumber, String docDate) {
        this.docNumber = docNumber;
        this.docDate = docDate;
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
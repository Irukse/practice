package ru.irute.bellintegrator.practice.employee.entity;

import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;
import ru.irute.bellintegrator.practice.organization.entity.OrganizationEntity;

import javax.persistence.*;
/**
 * работник
 */
@Entity(name = "Employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * колонка, хранящая первичный ключ офиса
     */
    //нужно ли это поле?
    @Column(name = "office_id")
    private Long officeId;

    /**
     *имя
     */
    @Column(name = "first_name",length = 50, nullable = false)
    private String firstName;

    /**
     *фамилия
     */
    @Column(name = "second_name",length = 50)
    private String secondName;

    /**
     *отчество
     */
    @Column(name = "last_name",length = 50)
    private String lastName;

    /**
     *должность
     */
    @Column(length = 50)
    private String position;

    /**
     *телефон
     */
    @Column(length = 20)
    private String phone;

    /**
     *
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    /**
     * указываем имя столбца (name = "office_id"),
     * в котором будет храниться первичный ключ Организации
     */
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id")
    /**
     * организация, которой принадлежит офис
     */
    private OfficeEntity officeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
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

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }
}

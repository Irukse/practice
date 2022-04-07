package ru.irute.bellintegrator.practice.offise.entity;

import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;
import ru.irute.bellintegrator.practice.organization.entity.OrganizationEntity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "Office")
public class OfficeEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Наименование офиса
     */
    @Column(name = "name_office", length = 50)
    private String name;

    /**
     * Адрес офиса
     */
    @Column(name = "address", length = 50)
    private String address;

    /**
     * Телефон офиса
     */
    @Column(name = "phone", length = 11)
    private String phone;

    /**
     *
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;


    /**
     * указываем имя столбца (name = "org_id"),
     * в котором будет храниться первичный ключ Организации
     */
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "org_id")

    /**
     * организация, которой принадлежит офис
     */
     private OrganizationEntity organization;

    /**
     * создадим связь OneToMany и сопоставим с объектом
     * class EmployeeEntity через переменную private OfficeEntity officeEntity in class EmployeeEntity;
     */
  ////  @OneToMany(mappedBy = "officeEntity",cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "office_id")
    /**
     * добавим поле Entity
     */
    public List<EmployeeEntity> employeeEntities;

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
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

    public void addEmployee (EmployeeEntity employeeEntity){
        List <EmployeeEntity> list = new LinkedList<>();
        list.add(employeeEntity);

    }

    public OfficeEntity(Long id, String name,
                        String address, String phone,
                        Boolean isActive, Integer version,
                        OrganizationEntity organization) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
        this.version = version;
        this.organization = organization;
    }

    public OfficeEntity( ) {

    }
}

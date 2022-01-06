package ru.irute.bellintegrator.practice.organization.entity;

import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Organization")
public class OrganizationEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * сокращенное имя организации
     */
    @Column(name = "name_org", length = 50, nullable = false)
    private String name;

    /**
     *полное имя организации
     */
    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    /**
     *инн
     */
    @Column(name = "inn", length = 10, nullable = false)
    private Integer inn;

    /**
     *кпп
     */
    @Column(name = "kpp", length = 9, nullable = false)
    private Integer kpp;

    /**
     *адресс
     */
    @Column(name = "address", length = 50, nullable = false)
    private String address;

    /**
     *телефон
     */
    @Column(name = "phone", length = 11)
    private String phone;

    /**
     *
     */
    @Column( name =  "is_active" )
    private Boolean isActive;

    /**
     * служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     *конструктор
     */
    public OrganizationEntity(){

    }

    /**
     * создадим связь OneToMany и сопоставим с объектом
     * class OfficeEntity через переменную private OrganizationEntity organization in
     * clsaa OfficeEntity;
     */
    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL, orphanRemoval = true)
    /**
     * добавим поле office
     */
    public List<OfficeEntity> officeEntities;
    // неправильнофй
 //  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
 //   @JoinColumn(name = "id")


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

    public void setIsActive(boolean b) {
    }
    public Boolean getIsActive(){return isActive;}

    public OrganizationEntity(Long id, String name,
                              String fullName, Integer inn,
                              Integer kpp, String address,
                              String phone, Boolean isActive,
                              Integer version, List<OfficeEntity> officeEntities) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
        this.version = version;
        this.officeEntities = officeEntities;
    }



}
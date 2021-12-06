package ru.irute.bellintegrator.practice.organization.entity;

import ru.irute.bellintegrator.practice.offise.entity.Office;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Organization")
public class Organization {
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
    @Column(name = "address ", length = 50, nullable = false)
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
    public Organization(){

    }

    /**
     * добавим поле office
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private List <Office> offices;

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

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public void setIsActive(boolean b) {
    }
}

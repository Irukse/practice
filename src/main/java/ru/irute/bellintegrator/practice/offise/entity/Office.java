package ru.irute.bellintegrator.practice.offise.entity;

import javax.persistence.*;

@Entity(name = "Office")
public class Office {
    @Id
    @GeneratedValue
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
     *конструкторы
     */
    public Office() {

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
}

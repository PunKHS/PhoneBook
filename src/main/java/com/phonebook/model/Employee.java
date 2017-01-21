package com.phonebook.model;

import com.fasterxml.jackson.annotation.*;
import com.phonebook.service.View;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEE")
@JsonPropertyOrder({"id", "person"})
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonView(View.Autocomplete.class)
    private long id;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "PROFESSION_ID")
    private Profession profession;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "MOBILE_PHONE")
    private String mobilePhone;

    @Column(name = "AVAILABLE")
    private long available;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public long getAvailable() {
        return available;
    }

    public void setAvailable(long available) {
        this.available = available;
    }

    //    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", department=" + department +
//                ", person=" + person +
//                ", profession=" + profession +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", mobilePhone='" + mobilePhone + '\'' +
//                '}';
//    }
}

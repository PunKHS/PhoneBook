package com.phonebook.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "PROFESSION_ID")
    private Profession profession;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", department=" + department +
                ", person=" + person +
                ", profession=" + profession +
                '}';
    }
}

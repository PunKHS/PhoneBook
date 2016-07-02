package com.phonebook.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @NotEmpty
    @Size(min = 10, max = 200)
    @Column(name = "NAME")
    private String name;

    @NotEmpty
    @Column(name = "HEAD")
    private Long head;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "departments")
    private Set<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHead() {
        return head;
    }

    public void setHead(Long head) {
        this.head = head;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", head=" + head +
                ", employees=" + employees +
                '}';
    }
}

package com.phonebook.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.phonebook.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional //need to update\delete queries. Don't forget <tx:annotation-driven/>
public class EmployeeService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> findAllEmployee() {
        System.out.println("EmployeeService findAllEmployee is called");
        String query = "from Employee order by person.name";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
        return typedQuery.getResultList();
    }

    public List<Employee> searchEmployee(String searchText) {
        System.out.println("EmployeeService searchEmployee is called");
        String query = "from Employee where person.name like %" + searchText + "% order by person.name";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
        return typedQuery.getResultList();
    }
}

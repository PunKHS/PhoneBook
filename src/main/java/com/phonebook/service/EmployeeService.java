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
        System.out.println("ORMService findAllEmployee is called");
        String query = "from Employee order by person.name";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
        return typedQuery.getResultList();
    }

    public Employee findEmployeeById(int id) {
        System.out.println("ORMService findEmployeeById is called");
        return entityManager.find(Employee.class, id);
    }
}

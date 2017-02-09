package com.phonebook.dao;

import com.phonebook.model.Employee;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Repository
@Transactional //need to update\delete queries. Don't forget <tx:annotation-driven/>
public class EmployeeDaoImpl implements EmployeeDao {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EmployeeDaoImpl.class);

    @Autowired
//    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addEmployee(Employee employee) {
        entityManager.persist(employee);
        entityManager.refresh(employee);
        logger.info("Employee adding... " + employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
        logger.info("Employee was update... " + employee);
    }

    @Override
    public void removeEmployee(long id) {
        Employee employee = (Employee) entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }
        logger.info("Employee was successfully deleted... " + employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Employee employee = (Employee) entityManager.find(Employee.class, id);
        logger.info("Employee was successfully find... " + employee);
        return employee;
    }

    @Override
//    @SuppressWarnings("unchecked")
    public List<Employee> listEmployee() {
        String query = "from Employee where available = 1 order by person.name";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
        logger.info("Employee list was successfully find");
        return typedQuery.getResultList();
    }

    @Override
//    @SuppressWarnings("unchecked")
    public List<Employee> listEmployeeByFio(String searchText) {
//        String query = "from Employee where person.name like '%" + searchText + "%' order by person.name";
        String query = "from Employee where lower(person.name) like lower(trim(:pattern)) and available = 1 order by person.name";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
        typedQuery.setParameter("pattern", "%" + searchText + "%");
        logger.info("Employee search ");
        return typedQuery.getResultList();
    }
}

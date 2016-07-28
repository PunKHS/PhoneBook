package com.phonebook.dao;

import com.phonebook.model.Employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by PunKHS on 28.07.16.
 */

public class EmployeeDaoImpl implements EmployeeDao {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEmployee(Employee employee) {
//        Session session = this.sessionFactory.getCurrentSession();
        entityManager.persist(employee);
        logger.info("Employee successfully saved. Employee details: " + employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        logger.info("Employee successfully update. Employee details: " + employee);
    }

    @Override
    public void removeEmployee(int id) {
//        Session session = this.sessionFactory.getCurrentSession();
//        Employee employee = (Employee) session.load(Employee.class, new Integer(id));
        Employee employee = (Employee) entityManager.load(Employee.class, new Integer(id));

        if (employee != null) {
//            session.delete(employee);
            entityManager.remove(employee);
        }
        logger.info("Employee successfully removed. Employee details: " + employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, new Integer(id));
        logger.info("Employee successfully loaded. Employee details: " + employee);
        return employee;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> listEmployee() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();

        for (Employee employee : employeeList) {
            logger.info("Employee list: " + employee);
        }
        return employeeList;
    }
}

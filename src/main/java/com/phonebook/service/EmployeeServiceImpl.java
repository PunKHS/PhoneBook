package com.phonebook.service;

import java.util.List;
import com.phonebook.dao.EmployeeDao;
import com.phonebook.model.Employee;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {

    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {

    }

    @Override
    @Transactional
    public void removeEmployee(int id) {

    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    @Transactional
    public List<Employee> findAllEmployee() {
        return this.employeeDao.listEmployee();
    }

    @Override
    @Transactional
    public List<Employee> searchEmployee(String searchText) {
        return this.employeeDao.listEmployeeByFio(searchText);
    }
}

package com.phonebook.dao;

import com.phonebook.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void removeEmployee(long id);

    public Employee getEmployeeById(long id);

    public List<Employee> listEmployee();

    public List<Employee> listEmployeeByFio(String searchText);
}

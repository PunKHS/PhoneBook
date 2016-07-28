package com.phonebook.dao;

import com.phonebook.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void removeEmployee(int id);

    public Employee getEmployeeById(int id);

    public List<Employee> listEmployee();

    public List<Employee> listEmployeeByFio(String searchText);
}

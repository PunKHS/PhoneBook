package com.phonebook.service;

import com.phonebook.model.Department;
import com.phonebook.model.Employee;
import java.util.List;

/**
 * Created by PunKHS on 28.07.16.
 */

public interface EmployeeService {

    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void removeEmployee(long id);

    public Employee getEmployeeById(long id);

    public List<Employee> findAllEmployee();

    public List<Employee> searchEmployee(String searchText);

//    public List<Department> getAllDepartments();
}

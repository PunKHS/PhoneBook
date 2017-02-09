package com.phonebook.service;

import java.util.List;

import com.phonebook.dao.EmployeeDao;
import com.phonebook.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        this.employeeDao.addEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        this.employeeDao.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void removeEmployee(long id) {
        this.employeeDao.removeEmployee(id);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(long id) {
        return this.employeeDao.getEmployeeById(id);
    }

    @Override
    @Transactional
//    @Cacheable("employee")
    public List<Employee> findAllEmployee() {
        return this.employeeDao.listEmployee();
    }

    // This method will remove all 'Employee' from cache, say as a result of flush API call.
//    @CacheEvict(value = "products", allEntries = true)
//    public void refreshAllEmployee() {
//    }

    @Override
    @Transactional
    public List<Employee> searchEmployee(String searchText) {
        return this.employeeDao.listEmployeeByFio(searchText);
    }
}

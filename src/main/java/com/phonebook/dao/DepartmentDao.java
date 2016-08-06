package com.phonebook.dao;

import com.phonebook.model.Department;

import java.util.List;

/**
 * Created by PunKHS on 06.08.2016.
 */
public interface DepartmentDao {
    public void addEmployee(Department department);

    public void updateDepartment(Department department);

    public void removeDepartment(long id);

    public Department getDepartmentById(long id);

    public List<Department> listDepartment();
}

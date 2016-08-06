package com.phonebook.service;

import com.phonebook.model.Department;

import java.util.List;

/**
 * Created by PunKHS on 06.08.2016.
 */

public interface DepartmentService {

    public void addDepartment(Department department);

    public void updateDepartment(Department department);

    public void removeDepartment(long id);

    public Department getDepartmentById(long id);

    public List<Department> getAllDepartments();

    public List<Department> searchDepartment(String searchText);
}

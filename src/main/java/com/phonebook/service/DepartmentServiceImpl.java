package com.phonebook.service;

import com.phonebook.dao.DepartmentDao;
import com.phonebook.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by PunKHS on 06.08.2016.
 */
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    @Transactional
    public void addDepartment(Department department) {

    }

    @Override
    @Transactional
    public void updateDepartment(Department department) {

    }

    @Override
    @Transactional
    public void removeDepartment(long id) {

    }

    @Override
    @Transactional
    public Department getDepartmentById(long id) {
        return null;
    }

    @Override
    @Transactional
    public List<Department> getAllDepartments() {
        return departmentDao.listDepartment();
    }

    @Override
    @Transactional
    public List<Department> searchDepartment(String searchText) {
        return null;
    }
}

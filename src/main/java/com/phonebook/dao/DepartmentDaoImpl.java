package com.phonebook.dao;

import com.phonebook.model.Department;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by PunKHS on 06.08.2016.
 */
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addEmployee(Department department) {

    }

    @Override
    public void updateDepartment(Department department) {

    }

    @Override
    public void removeDepartment(long id) {

    }

    @Override
    public Department getDepartmentById(long id) {
        return null;
    }

    @Override
    public List<Department> listDepartment() {
        String query = "from Department order by person.name";
        TypedQuery<Department> typedQuery = entityManager.createQuery(query, Department.class);
        return typedQuery.getResultList();
    }
}

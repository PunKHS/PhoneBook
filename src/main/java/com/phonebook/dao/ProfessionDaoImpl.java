package com.phonebook.dao;

import com.phonebook.model.Department;
import com.phonebook.model.Profession;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class ProfessionDaoImpl implements ProfessionDao {

    @Autowired
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addEmployee(Profession Profession) {

    }

    @Override
    public void updateProfession(Profession Profession) {

    }

    @Override
    public void removeProfession(long id) {

    }

    @Override
    public Profession getProfessionById(long id) {
        return null;
    }

    @Override
    public List<Profession> listProfession() {
        String query = "from Profession order by Name";
        TypedQuery<Profession> typedQuery = entityManager.createQuery(query, Profession.class);
        return typedQuery.getResultList();
    }
}

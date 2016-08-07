package com.phonebook.dao;

import com.phonebook.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by PunKHS on 07.08.2016.
 */
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addEmployee(Person Person) {

    }

    @Override
    public void updatePerson(Person Person) {

    }

    @Override
    public void removePerson(long id) {

    }

    @Override
    public Person getPersonById(long id) {
        return null;
    }

    @Override
    public List<Person> listPerson() {
        String query = "from Person order by Name";
        TypedQuery<Person> typedQuery = entityManager.createQuery(query, Person.class);
        return typedQuery.getResultList();
    }
}

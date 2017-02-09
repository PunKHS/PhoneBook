package com.phonebook.dao;

import com.phonebook.model.Person;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class PersonDaoImpl implements PersonDao {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EmployeeDaoImpl.class);

    @Autowired
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addPerson(Person Person) {

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
    public List<Person> listAvailablePerson() {
        String query = "from Person where available = 1 order by name";
        TypedQuery<Person> typedQuery = entityManager.createQuery(query, Person.class);
        return typedQuery.getResultList();
    }

    public List<Person> listAvailablePersonByFio(String searchText){
        String query = "from Person where lower(name) like lower(trim(:pattern)) and available = 1 order by name";
        TypedQuery<Person> typedQuery = entityManager.createQuery(query, Person.class);
        typedQuery.setParameter("pattern", "%" + searchText + "%");
        logger.info("Person search ");
        return typedQuery.getResultList();
    }
}

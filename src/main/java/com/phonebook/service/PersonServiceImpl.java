package com.phonebook.service;

import com.phonebook.dao.PersonDao;
import com.phonebook.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by PunKHS on 07.08.2016.
 */
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public void addPerson(Person Person) {

    }

    @Override
    @Transactional
    public void updatePerson(Person Person) {

    }

    @Override
    @Transactional
    public void removePerson(long id) {

    }

    @Override
    @Transactional
    public Person getPersonById(long id) {
        return null;
    }

    @Override
    @Transactional
    public List<Person> getAllPersons() {
        return personDao.listAvailablePerson();
    }

    @Override
    @Transactional
    public List<Person> searchPerson(String searchText) {
        return this.personDao.listAvailablePersonByFio(searchText);
    }
}

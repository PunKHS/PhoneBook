package com.phonebook.service;

import com.phonebook.dao.PersonDao;
import com.phonebook.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

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
    public List<Person> getAllPersons() {
        return personDao.listPerson();
    }

    @Override
    public List<Person> searchPerson(String searchText) {
        return null;
    }
}

package com.phonebook.service;

import com.phonebook.model.Person;

import java.util.List;


public interface PersonService {

    public void addPerson(Person Person);

    public void updatePerson(Person Person);

    public void removePerson(long id);

    public Person getPersonById(long id);

    public List<Person> getAllPersons();

    public List<Person> searchPerson(String searchText);
}

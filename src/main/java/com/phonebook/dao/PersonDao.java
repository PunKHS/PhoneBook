package com.phonebook.dao;

import com.phonebook.model.Person;
import java.util.List;


public interface PersonDao {
    public void addPerson(Person Person);

    public void updatePerson(Person Person);

    public void removePerson(long id);

    public Person getPersonById(long id);

    public List<Person> listAvailablePerson();

    public List<Person> listAvailablePersonByFio(String searchText);
}

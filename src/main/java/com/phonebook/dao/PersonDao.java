package com.phonebook.dao;

import com.phonebook.model.Person;
import java.util.List;

/**
 * Created by PunKHS on 07.08.2016.
 */
public interface PersonDao {
    public void addPerson(Person Person);

    public void updatePerson(Person Person);

    public void removePerson(long id);

    public Person getPersonById(long id);

    public List<Person> listPerson();
}

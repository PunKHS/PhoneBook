package com.phonebook.dao;

import com.phonebook.model.Profession;

import java.util.List;


public interface ProfessionDao {

    public void addEmployee(Profession Profession);

    public void updateProfession(Profession Profession);

    public void removeProfession(long id);

    public Profession getProfessionById(long id);

    public List<Profession> listProfession();
}

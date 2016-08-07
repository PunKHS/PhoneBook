package com.phonebook.dao;

import com.phonebook.model.Profession;

import java.util.List;

/**
 * Created by PunKHS on 07.08.2016.
 */
public interface ProfessionDao {

    public void addEmployee(Profession Profession);

    public void updateProfession(Profession Profession);

    public void removeProfession(long id);

    public Profession getProfessionById(long id);

    public List<Profession> listProfession();
}

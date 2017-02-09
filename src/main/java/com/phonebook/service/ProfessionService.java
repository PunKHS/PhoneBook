package com.phonebook.service;

import com.phonebook.model.Profession;

import java.util.List;


public interface ProfessionService {

    public void addProfession(Profession Profession);

    public void updateProfession(Profession Profession);

    public void removeProfession(long id);

    public Profession getProfessionById(long id);

    public List<Profession> getAllProfessions();

    public List<Profession> searchProfession(String searchText);
}

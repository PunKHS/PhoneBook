package com.phonebook.service;

import com.phonebook.dao.DepartmentDao;
import com.phonebook.dao.ProfessionDao;
import com.phonebook.model.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by PunKHS on 07.08.2016.
 */
public class ProfessionServiceImpl implements ProfessionService {

    @Autowired
    private ProfessionDao professionDao;

    public void setProfessionDao(ProfessionDao professionDao) {
        this.professionDao = professionDao;
    }

    @Override
    @Transactional
    public void addProfession(Profession Profession) {

    }

    @Override
    @Transactional
    public void updateProfession(Profession Profession) {

    }

    @Override
    @Transactional
    public void removeProfession(long id) {

    }

    @Override
    @Transactional
    public Profession getProfessionById(long id) {
        return null;
    }

    @Override
    @Transactional
    public List<Profession> getAllProfessions() {
        return professionDao.listProfession();
    }

    @Override
    @Transactional
    public List<Profession> searchProfession(String searchText) {
        return null;
    }
}

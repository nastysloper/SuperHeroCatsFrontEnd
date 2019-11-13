package com.nastysloper.service;

import com.nastysloper.dao.CatDao;
import com.nastysloper.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Service("CatService")
public class CatServiceImpl implements CatService {

    @Autowired
    private CatDao catDao;

    @Override
    public Cat findById(Long id) {
        return catDao.findById(id);
    }

    @Override
    public Cat findByName(String name) {
        return catDao.findByName(name);
    }

    @Override
    public ArrayList<Cat> findAllCats() {
        return catDao.findAllCats();
    }

    @Override
    public void saveCat(Cat cat) {
        catDao.saveCat(cat);
    }

    @Override
    public void deleteCatById(Long id) {
        catDao.deleteCatById(id);
    }

    @Override
    public void updateCat(Cat cat) {
        catDao.updateCat(cat);
    }
}

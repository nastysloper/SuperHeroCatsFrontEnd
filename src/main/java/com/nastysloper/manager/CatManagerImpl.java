package com.nastysloper.manager;

import com.nastysloper.model.Cat;
import com.nastysloper.service.CatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("CatManager")
public class CatManagerImpl implements CatManager {

    @Autowired
    CatServiceImpl catService;

    public ArrayList<Cat> findAllCats() {
        return catService.findAllCats();
    }

    @Override
    public Cat createNewCat(Cat cat) {
        return catService.createNewCat(cat);
    }

    @Override
    public Optional<Cat> findById(Long id) {
        return catService.findById(id);
    }

    @Override
    public boolean catExists(Cat cat) {
        return catService.catExists(cat);
    }

    @Override
    public Optional<Cat> deleteCat(Long id) {
        return catService.deleteCat(id);
    }

    @Override
    public Cat updateCat(Cat cat) {
        return catService.updateCat(cat);
    }
}

package com.nastysloper.manager;

import com.nastysloper.model.Cat;
import com.nastysloper.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("CatManager")
public class CatManagerImpl implements CatManager {

    @Autowired
    CatService catService;

    public ArrayList<Cat> findAllCats() {
        return catService.findAllCats();
    }

    @Override
    public void createNewCat(Cat cat) {
        catService.saveCat(cat);
    }

    @Override
    public Cat findById(Long id) {
        return catService.findById(id);
    }

    @Override
    public Cat findByName(String name) { return catService.findByName(name); }

    @Override
    public void deleteCat(Long id) {
        catService.deleteCatById(id);
    }

    @Override
    public void updateCat(Cat cat) {
        catService.updateCat(cat);
    }
}

package com.nastysloper.manager;

import com.nastysloper.model.Cat;
import com.nastysloper.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("CatManager")
public class CatManagerImpl implements CatManager {

    @Autowired
    CatService catService;

    public ResponseEntity<Cat[]> findAllCats() {
        return catService.findAllCats();
    }

    @Override
    public ResponseEntity<Cat> createNewCat(Cat cat) {
        return catService.saveCat(cat);
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

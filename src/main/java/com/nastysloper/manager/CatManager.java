package com.nastysloper.manager;

import com.nastysloper.model.Cat;

import java.util.ArrayList;

public interface CatManager {

    ArrayList<Cat> findAllCats();

    void createNewCat(Cat cat);

    Cat findById(Long id);

    Cat findByName(String name);

    void deleteCat(Long id);

    void updateCat(Cat cat);
}

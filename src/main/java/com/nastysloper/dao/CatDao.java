package com.nastysloper.dao;

import com.nastysloper.model.Cat;

import java.util.ArrayList;

public interface CatDao {

    void saveCat(Cat cat);

    ArrayList<Cat> findAllCats();

    void deleteCatById(Long id);

    Cat findById(Long id);

    Cat findByName(String name);

    void updateCat(Cat cat);
}

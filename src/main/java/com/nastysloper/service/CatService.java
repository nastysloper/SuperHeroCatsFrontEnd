package com.nastysloper.service;

import com.nastysloper.model.Cat;

import java.util.List;
import java.util.Optional;

public interface CatService {

    Optional<Cat> findById(long id);

    Optional<Cat> findByName(String name);

    List<Cat> findAllCats();

    Cat createNewCat(String name, String power, String weakness, String image);

    boolean catExists(Cat cat);

    void deleteCatById(long id);
}

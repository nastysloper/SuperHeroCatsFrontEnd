package com.nastysloper.service;

import com.nastysloper.model.Cat;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface CatService {

    Cat findByName(String name);

    ResponseEntity<Cat[]> findAllCats();

    ResponseEntity<Cat> saveCat(Cat cat);

    void deleteCatById(Long id);

    void updateCat(Cat cat);
}

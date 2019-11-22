package com.nastysloper.manager;

import com.nastysloper.model.Cat;
import org.springframework.http.ResponseEntity;

public interface CatManager {

    ResponseEntity<Cat[]> findAllCats();

    ResponseEntity<Cat> createNewCat(Cat cat);

    Cat findByName(String name);

    void deleteCat(Long id);

    void updateCat(Cat cat);
}

package com.nastysloper.manager;

import com.nastysloper.model.Cat;

import java.util.List;
import java.util.Optional;

public interface CatManager {

    List<Cat> findAllCats();

    Cat createNewCat(Cat cat);

    Optional<Cat> findById(Long id);

    boolean catExists(Cat cat);

    Optional<Cat> deleteCat(Long id);

    Cat updateCat(Cat cat);
}

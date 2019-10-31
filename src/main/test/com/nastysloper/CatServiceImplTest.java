package com.nastysloper;

import com.nastysloper.model.Cat;
import com.nastysloper.service.CatServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CatServiceImplTest {

    CatServiceImpl catService = new CatServiceImpl();

    @Test
    void createNewCat() {
        Cat c1 = new Cat("Fluff Monster", "Super Strength", "Needs lots of sleep", "a photo");
        c1 = catService.createNewCat(c1);
        Cat c2 = catService.findByName("Fluff Monster").get();
        assert c2.equals(c1);
    }
}
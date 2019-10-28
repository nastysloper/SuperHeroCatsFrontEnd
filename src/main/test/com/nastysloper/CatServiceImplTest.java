package com.nastysloper;

import com.nastysloper.model.Cat;
import com.nastysloper.service.CatServiceImpl;
import org.junit.jupiter.api.Test;

class CatServiceImplTest {

    @Test
    void createNewCat() {
        Cat u1 = new Cat("Fluff Monster", "Super Strength", "Needs lots of sleep", "a photo");
        CatServiceImpl service = new CatServiceImpl();
        service.createNewCat("Fluff Monster", "Super Strength", "Needs lots of sleep", "a photo");
        Cat u2 = service.findByName("Fluff Monster").get();
        assert u2.equals(u1);
    }
}
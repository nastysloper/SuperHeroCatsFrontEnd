package com.nastysloper;

import com.nastysloper.manager.CatManagerImpl;
import com.nastysloper.model.Cat;
import com.nastysloper.service.CatServiceImpl;
import org.junit.jupiter.api.Test;

class CatServiceImplTest {

    CatServiceImpl catService = new CatServiceImpl();
    CatManagerImpl manager = new CatManagerImpl();

    @Test
    void createNewCat() {
        Cat c1 = new Cat();
        c1.setName("Fluff Monster");
        c1.setPower("Super Strength");
        c1.setWeakness("Needs lots of sleep");
        c1.setImage("a photo");
        manager.createNewCat(c1);
        Cat c2 = manager.findByName("Fluff Monster");
        assert c2.equals(c1);
    }
}
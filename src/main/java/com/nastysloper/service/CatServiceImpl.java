package com.nastysloper.service;

import com.nastysloper.model.Cat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("CatService")
public class CatServiceImpl implements CatService {

    private ArrayList<Cat> Cats = populateMockCats();

    @Override
    public Optional<Cat> findById(long id) {
        for (Cat u : Cats) {
            if (u.getId() == id) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Cat> findByName(String name) {
        for (Cat u : Cats) {
            if (u.getName() == name) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    @Override
    public ArrayList<Cat> findAllCats() {
        return Cats;
    }

    @Override
    public Cat createNewCat(String name, String power, String weakness, String image) {
        Cat cat = new Cat(name, power, weakness, image);
        Cats.add(cat);
        return cat;
}

    public ArrayList<Cat> populateMockCats() {
        ArrayList<Cat> Cats = new ArrayList<>();
        Cat u1 = new Cat("Fluffy", "Fur acts as armor", "Afraid of heights", "https://placekitten.com/96/139");
        Cat u2 = new Cat("Tiny", "Fits into small spaces", "Takes too many naps", "https://placekitten.com/76/139");
        Cat u3 = new Cat("Werewolf", "Meows loudly", "Hates loud noises", "https://placekitten.com/75/139");
        Cats.add(u1);
        Cats.add(u2);
        Cats.add(u3);
        return Cats;
    }
}

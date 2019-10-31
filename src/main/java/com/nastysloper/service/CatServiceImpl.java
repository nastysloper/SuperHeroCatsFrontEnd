package com.nastysloper.service;

import com.nastysloper.model.Cat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("CatService")
public class CatServiceImpl implements CatService {

    private static Long counter = 0L;
    private static ArrayList<Cat> cats;

    static {
        cats = populateMockCats();
    }

    @Override
    public Optional<Cat> findById(Long id) {
        for (Cat c : cats) {
            if (c.getId() == id) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Cat> findByName(String name) {
        for (Cat c : cats) {
            if (c.getName() == name) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @Override
    public ArrayList<Cat> findAllCats() {
        return cats;
    }

    @Override
    public Cat createNewCat(Cat cat) {
        Cat newCat = new Cat(cat.getName(), cat.getPower(), cat.getWeakness(), cat.getImage());
        newCat.setId(createId());
        cats.add(newCat);
        return newCat;
    }

    @Override
    public Optional<Cat> deleteCat(Long id) {
        Cat catToRemove;
        for (Cat c : cats) {
            if (c.getId() == id) {
                catToRemove = c;
                cats.remove(c);
                return Optional.of(catToRemove);
            }
        }
        return Optional.empty();
    }

    private static Long createId() {
        return counter++;
    }

    private static ArrayList<Cat> populateMockCats() {
        ArrayList<Cat> dummyCats = new ArrayList<>();
        Cat c1 = new Cat("Fluffy", "Fur acts as armor", "Afraid of heights", "https://placekitten.com/96/139");
        c1.setId(createId());
        dummyCats.add(c1);
        Cat c2 = new Cat("Tiny", "Fits into small spaces", "Takes too many naps", "https://placekitten.com/76/139");
        c2.setId(createId());
        dummyCats.add(c2);
        Cat c3 = new Cat("Werewolf", "Meows loudly", "Hates loud noises", "https://placekitten.com/75/139");
        c3.setId(createId());
        dummyCats.add(c3);

        return dummyCats;
    }

    public Cat updateCat(Cat cat) {
        int i = cats.indexOf(cat);
        cats.set(i, cat);
        return cat;
    }

    public boolean catExists(Cat cat) {
        return !findByName(cat.getName()).isEmpty();
    }
}

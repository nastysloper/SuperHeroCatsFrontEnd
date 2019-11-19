package com.nastysloper.controller;

import com.nastysloper.manager.CatManager;
import com.nastysloper.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CatController {

    @Autowired
    CatManager catManager;

    @RequestMapping(value = "/cats", method = RequestMethod.GET)
    public ResponseEntity<List<Cat>> listAllCats() {
        List<Cat> cats = catManager.findAllCats();
        if (cats.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }

    @RequestMapping(value = "/cat/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cat> getCat(@PathVariable("id") Long id) {
        System.out.println("Fetching cat with id " + id);
        try {
            Cat cat = catManager.findById(id);
            return new ResponseEntity<Cat>(cat, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            System.out.println("Cat with id " + id + " not found.");
            return new ResponseEntity<Cat>(HttpStatus.NOT_FOUND);
        }
    }

    // Synchronous request
    @RequestMapping(value = "/createCat", method = RequestMethod.POST)
    public ModelAndView createSyncCat(@ModelAttribute("Cat") Cat newCat) {

        Cat cat = catManager.findByName(newCat.getName());
        if (cat != null) {
            System.out.println("A cat with the name " + newCat.getName() + " already exists.");
            return new ModelAndView("redirect:/home");
        }
        catManager.createNewCat(newCat);
        return new ModelAndView("redirect:/home");
    }

    // Async request
    @RequestMapping(value = "/cat", method = RequestMethod.POST)
    public ResponseEntity<Cat> createAsyncCat(@RequestBody Cat newCat) {
        Cat cat = catManager.findByName(newCat.getName());
        if (cat != null) {
            System.out.println("A super hero cat named " + newCat.getName() + " already exists.");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        System.out.println("Creating super hero cat " + newCat.getName() + ".");
        catManager.createNewCat(newCat);
        return new ResponseEntity<>(newCat, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/cat/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cat> deleteCat(@PathVariable("id") Long id) {
        System.out.println("Fetching and deleting Cat with id " + id);
        Cat cat = catManager.findById(id);
        if (cat == null) {
            System.out.println("Unable to delete cat with id " + id + ".");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catManager.deleteCat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/cat/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cat> updateCat(@PathVariable("id") Long id, @RequestBody Cat cat) {
        Cat thisCat = catManager.findById(id);
        System.out.println("Updating Cat with id " + id);
        thisCat.setName(cat.getName());
        thisCat.setImage(cat.getImage());
        thisCat.setPower(cat.getPower());
        thisCat.setWeakness(cat.getWeakness());
        thisCat.setBirthday(cat.getBirthday());
        catManager.updateCat(thisCat);
        return new ResponseEntity<>(thisCat, HttpStatus.OK);
    }
}

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
    public ResponseEntity<Cat[]> findAllCats() {
        return catManager.findAllCats();
    }

    // TODO: update this method on the Backend.
    // Synchronous request
    @RequestMapping(value = "/createCat", method = RequestMethod.POST)
    public ModelAndView createSyncCat(@ModelAttribute("Cat") Cat newCat) {
        catManager.createNewCat(newCat);
        return new ModelAndView("redirect:/home");
    }

    // Async request
    @RequestMapping(value = "/cat", method = RequestMethod.POST)
    public ResponseEntity<Cat> createAsyncCat(@RequestBody Cat newCat) {
        System.out.println("Attempting to creating super hero cat " + newCat.getName() + ".");
        catManager.createNewCat(newCat);
        return new ResponseEntity<>(newCat, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/cat/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cat> deleteCat(@PathVariable("id") Long id) {
        System.out.println("Fetching and deleting Cat with id " + id);
        catManager.deleteCat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/cat/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cat> updateCat(@PathVariable("id") Long id, @RequestBody Cat cat) {
        System.out.println("Updating Cat with id " + id);
        catManager.updateCat(cat);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }
}

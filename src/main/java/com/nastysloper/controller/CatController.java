package com.nastysloper.controller;

import com.nastysloper.service.CatServiceImpl;
import com.nastysloper.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CatController {

    @Autowired
    CatServiceImpl catService;

    @RequestMapping(value = "/cats", method = RequestMethod.GET)
    public ResponseEntity<List<Cat>> listAllCats() {
        List<Cat> cats = catService.findAllCats();
        if (cats.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }

    // Synchronous request
    @RequestMapping(value = "/createCat", method = RequestMethod.POST)
    public ModelAndView createNewCat(@ModelAttribute("Cat") Cat newCat) {
        catService.createNewCat(newCat.getName(), newCat.getPower(), newCat.getWeakness(), newCat.getImage());
        return new ModelAndView("CatManagement");
    }

    // Async request
    @RequestMapping(value = "/cat/", method = RequestMethod.POST)
    public ResponseEntity<Cat> createAsyncCat(@RequestBody Cat newCat) {
        Cat cat = catService.createNewCat(newCat.getName(), newCat.getPower(), newCat.getWeakness(), newCat.getImage());
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseStatus deleteCat(@PathVariable("id") Long id) {
        System.out.println("Deleting cat with id " + id);
        Cat cat = catService.findById(id).get();
        catService.delete(id);
    }

}

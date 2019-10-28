package com.nastysloper.controller;

import com.nastysloper.service.CatServiceImpl;
import com.nastysloper.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CatController {

   @Autowired
   CatServiceImpl catService;

   @RequestMapping(value = "/cat/", method = RequestMethod.GET)
    public ResponseEntity<List<Cat>> listAllCats() {
       List<Cat> cats = catService.findAllCats();
       if (cats.isEmpty()) {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(cats, HttpStatus.OK);
   }

   @RequestMapping(value = "/cat/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Cat> getCat(@PathVariable("id") long id) {
      System.out.println("Fetching cat with id " + id);
      try {
         Cat cat = catService.findById(id).get();
         return new ResponseEntity<Cat>(cat, HttpStatus.OK);
      } catch (NoSuchElementException e) {
         System.out.println("Cat with id " + id + " not found.");
         return new ResponseEntity<Cat>(HttpStatus.NOT_FOUND);
      }
   }

   // Synchronous request; remove after phase 1.
   @RequestMapping(value="/createCat", method = RequestMethod.POST)
    public ResponseEntity<Cat> createSyncCat(@ModelAttribute("Cat") Cat newCat) {
       Cat cat = catService.createNewCat(newCat.getName(), newCat.getPower(), newCat.getWeakness(), newCat.getImage());
       return new ResponseEntity<>(cat, HttpStatus.OK);

   }

   // Async request
   @RequestMapping(value="/cat/", method = RequestMethod.POST)
    public ResponseEntity<Cat> createAsyncCat(@RequestBody Cat newCat, UriComponentsBuilder builder) {
      System.out.println("Creating super hero cat " + newCat.getName() + ".");
      if (catService.catExists(newCat)) {
         System.out.println("A super hero cat named " + newCat.getName() + " already exists.");
         return new ResponseEntity<>(HttpStatus.CONFLICT);
      }
      Cat cat = catService.createNewCat(newCat.getName(), newCat.getPower(), newCat.getWeakness(), newCat.getImage());
      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(builder.path("/cat/{id}").buildAndExpand(cat.getId()).toUri());
      return new ResponseEntity<>(cat, HttpStatus.CREATED);
   }

   @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Cat> deleteCat(@PathVariable("id") long id) {
      System.out.println("Fetching and deleting Cat with id " + id);
      if (catService.findById(id).isEmpty()) {
         System.out.println("Unable to delete cat with id " + id + ".");
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      catService.deleteCatById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}

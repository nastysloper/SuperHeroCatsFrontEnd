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
   CatServiceImpl CatService;

   @RequestMapping(value = "/cat/", method = RequestMethod.GET)
    public ResponseEntity<List<Cat>> listAllCats() {
       List<Cat> cats = CatService.findAllCats();
       if (cats.isEmpty()) {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(cats, HttpStatus.OK);
   }

   // Synchronous request
   @RequestMapping(value="/createCat", method = RequestMethod.POST)
    public ModelAndView createNewCat(@ModelAttribute("Cat") Cat newCat) {
       Cat cat = CatService.createNewCat(newCat.getName(), newCat.getPower(), newCat.getWeakness(), newCat.getImage());
       return new ModelAndView("CatManagement");
   }

   // Async request
   @RequestMapping(value="/cat/", method = RequestMethod.POST)
    public ResponseEntity<Cat> createAsyncCat(@RequestBody Cat newCat) {
       Cat cat = CatService.createNewCat(newCat.getName(), newCat.getPower(), newCat.getWeakness(), newCat.getImage());
       return new ResponseEntity<>(cat, HttpStatus.OK);
   }
}

package com.nastysloper.service;

import com.nastysloper.model.Cat;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Transactional
@Service("CatService")
public class CatServiceImpl implements CatService {

    private static String API = "http://localhost:8080/super_cats_war_exploded/";

    @Override
    public Cat findByName(String name) {
        final String uri = API + "cat/" + name;

        Map<String, String> params = new HashMap<>();
        params.put("name", name);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Cat.class, params);
    }

    @Override
    public ResponseEntity<Cat[]> findAllCats() {
        final String uri = API + "cats";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(uri, Cat[].class);
    }

    @Override
    public ResponseEntity<Cat> saveCat(Cat cat) {
        final String uri = API + "cat";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(uri, cat, Cat.class);
    }

    @Override
    public void deleteCatById(Long id) {
        final String uri = API + "cat/" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri);
    }

    @Override
    public void updateCat(Cat cat) {
        final String uri = API + "cat/" + cat.getId();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(uri, cat, Cat.class);
    }
}

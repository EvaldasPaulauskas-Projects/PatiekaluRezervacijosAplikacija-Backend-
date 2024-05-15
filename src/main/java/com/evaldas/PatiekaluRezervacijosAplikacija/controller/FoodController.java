package com.evaldas.PatiekaluRezervacijosAplikacija.controller;

import com.evaldas.PatiekaluRezervacijosAplikacija.exception.FoodNotFoundException;
import com.evaldas.PatiekaluRezervacijosAplikacija.model.Food;
import com.evaldas.PatiekaluRezervacijosAplikacija.repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class FoodController {

    @Autowired
    private FoodRepo foodRepo;

    @PostMapping("/food")
    Food newFood(@RequestBody Food newFood) {
        return foodRepo.save(newFood);
    }

    @GetMapping("/foods")
    List<Food> getAllUsers() {
        return foodRepo.findAll();
    }

    @GetMapping("/food/{id}")
    Food getUserById(@PathVariable Long id) {
        return foodRepo.findById(id)
                .orElseThrow(() -> new FoodNotFoundException(id));
    }

    @PutMapping("/food/{id}")
    Food updateUser(@RequestBody Food newFood, @PathVariable Long id) {
        return foodRepo.findById(id)
                .map(food -> {
                    food.setPavadinimas(newFood.getPavadinimas());
                    food.setAprasymas(newFood.getAprasymas());
                    food.setKaina(newFood.getKaina());
                    food.setKiekis(newFood.getKiekis());
                    food.setNuotrauka(newFood.getNuotrauka());
                    food.setKategorija(newFood.getKategorija());
                    return foodRepo.save(food);
                }).orElseThrow(() -> new FoodNotFoundException(id));
    }

    @DeleteMapping("/food/{id}")
    String deleteUser(@PathVariable Long id){
        if(!foodRepo.existsById(id)){
            throw new FoodNotFoundException(id);
        }
        foodRepo.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }



}
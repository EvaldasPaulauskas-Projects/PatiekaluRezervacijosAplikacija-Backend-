package com.evaldas.PatiekaluRezervacijosAplikacija.repo;

import com.evaldas.PatiekaluRezervacijosAplikacija.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Long> {
}
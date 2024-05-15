package com.evaldas.PatiekaluRezervacijosAplikacija.repo;

import com.evaldas.PatiekaluRezervacijosAplikacija.model.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<OurUsers, Integer> {

    Optional<OurUsers> findByEmail(String email);
}
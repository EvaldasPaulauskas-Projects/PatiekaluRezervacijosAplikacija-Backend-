package com.evaldas.PatiekaluRezervacijosAplikacija.repo;

import com.evaldas.PatiekaluRezervacijosAplikacija.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserId(Integer userId);
}
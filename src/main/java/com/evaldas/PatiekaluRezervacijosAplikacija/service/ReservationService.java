package com.evaldas.PatiekaluRezervacijosAplikacija.service;

import com.evaldas.PatiekaluRezervacijosAplikacija.model.Reservation;
import com.evaldas.PatiekaluRezervacijosAplikacija.repo.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByUserId(Integer userId) {
        return reservationRepository.findByUserId(userId);
    }

    public void deleteReservationById(Integer reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
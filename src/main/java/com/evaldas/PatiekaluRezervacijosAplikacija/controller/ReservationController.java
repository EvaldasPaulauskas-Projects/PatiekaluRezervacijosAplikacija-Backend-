package com.evaldas.PatiekaluRezervacijosAplikacija.controller;

import com.evaldas.PatiekaluRezervacijosAplikacija.model.OurUsers;
import com.evaldas.PatiekaluRezervacijosAplikacija.model.Reservation;
import com.evaldas.PatiekaluRezervacijosAplikacija.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reserve")
    public ResponseEntity<String> reserveFood(@RequestBody Reservation reservation, Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated.");
        }

        String username = authentication.getName();
        Integer userId = ((OurUsers) authentication.getPrincipal()).getId();

        reservation.setUserId(userId);

        try {
            reservationService.createReservation(reservation);
            return ResponseEntity.ok("Food reserved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to reserve food.");
        }
    }

    @GetMapping("/reserved/all")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/reserved/{id}")
    public ResponseEntity<List<Reservation>> getReservationsByUserId(@PathVariable Integer id) {
        List<Reservation> reservations = reservationService.getReservationsByUserId(id);
        if (reservations.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(reservations);
        }
    }

    @DeleteMapping("/reserved/{id}")
    public ResponseEntity<String> deleteReservationById(@PathVariable Integer id) {
        try {
            reservationService.deleteReservationById(id);
            return ResponseEntity.ok("Reservation deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete reservation.");
        }
    }
}
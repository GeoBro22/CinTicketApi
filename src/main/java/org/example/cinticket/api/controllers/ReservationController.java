package org.example.cinticket.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.cinticket.domain.entities.PlaceEntity;
import org.example.cinticket.domain.entities.ReservationEntity;
import org.example.cinticket.domain.entities.SessionEntity;
import org.example.cinticket.domain.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@RestController
public class ReservationController {
    ReservationRepository reservationRepository;
    public static final String GET_RESERVATIONS_ON_SESSION = "/api/reservations/session";
    public static final String CREATE_RESERVATION = "/api/reservations/reservation";

    @GetMapping(GET_RESERVATIONS_ON_SESSION)
    public List<ReservationEntity> getReservationsOnSession(@RequestParam SessionEntity sessionId) {
        return reservationRepository.findAllBySession(sessionId);
    }

    @PostMapping(CREATE_RESERVATION)
    public ReservationEntity createReservation(@RequestParam Integer status, @RequestParam PlaceEntity place, @RequestParam SessionEntity session) {
        return reservationRepository.saveAndFlush(ReservationEntity.builder().reservationStatus(status).place(place).session(session).build());
    }

}

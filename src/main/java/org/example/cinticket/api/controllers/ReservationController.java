package org.example.cinticket.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.cinticket.api.dto.ReservationDto;
import org.example.cinticket.api.factories.PlaceDtoFactory;
import org.example.cinticket.api.factories.ReservationDtoFactory;
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
    ReservationDtoFactory reservationDtoFactory;
    public static final String GET_RESERVATIONS_ON_SESSION = "/api/reservations/session";
    public static final String CREATE_RESERVATION = "/api/reservations/reservation";
    public static final String GET_ALL_RESERVATIONS = "/api/reservations";

    @GetMapping(GET_RESERVATIONS_ON_SESSION)
    public List<ReservationDto> getReservationsOnSession(@RequestParam SessionEntity sessionId) {
        return reservationDtoFactory.makeListReservationDto(reservationRepository.findAllBySession(sessionId));
    }

    @PostMapping(CREATE_RESERVATION)
    public ReservationEntity createReservation(@RequestParam Integer status, @RequestParam PlaceEntity place, @RequestParam SessionEntity session) {
        return reservationRepository.saveAndFlush(ReservationEntity.builder().reservationStatus(status).place(place).session(session).build());
    }

    @GetMapping(GET_ALL_RESERVATIONS)
    public List<ReservationDto> getReservations() {
        return reservationDtoFactory.makeListReservationDto(reservationRepository.findAll());
    }



}

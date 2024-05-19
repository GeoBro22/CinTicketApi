package org.example.cinticket.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.cinticket.api.dto.SessionDto;
import org.example.cinticket.api.factories.SessionDtoFactory;
import org.example.cinticket.domain.entities.MovieEntity;
import org.example.cinticket.domain.entities.SessionEntity;
import org.example.cinticket.domain.repository.SessionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@RestController
public class SessionController {
    SessionRepository sessionRepository;
    SessionDtoFactory sessionDtoFactory;

    public static final String GET_SESSIONS_BY_MOVIE_AND_DATE = "/api/sessions";
    public static final String GET_SESSION_BY_ID = "/api/sessions/id";
    public static final String GET_SESSION_IN_CINEMA = "/api/sessions/cinema";

    @GetMapping(GET_SESSIONS_BY_MOVIE_AND_DATE)
    public List<SessionDto> GetSessionsByMovieAndDate(@RequestParam MovieEntity movie, @RequestParam String date) {
        return sessionDtoFactory.makeListSessionDto(sessionRepository.findAllByMovieAndDate(movie, date));
    }
    @GetMapping(GET_SESSION_BY_ID)
    public SessionDto GetSessionsById(@RequestParam long sessionId) {
        return sessionDtoFactory.makeSessionDto(sessionRepository.findById(sessionId));
    }

    @GetMapping(GET_SESSION_IN_CINEMA)
    public List<SessionDto> GetSessionsInCinema(@RequestParam Long cinemaId, @RequestParam String date) {
        List<SessionEntity> sessions = sessionRepository.findAllByHall_Cinema_IdAndDate(cinemaId, date);
        return sessionDtoFactory.makeListSessionDto(sessions);
    }



}

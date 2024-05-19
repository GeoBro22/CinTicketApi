package org.example.cinticket.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.cinticket.domain.entities.CinemaEntity;
import org.example.cinticket.domain.entities.MovieEntity;
import org.example.cinticket.domain.repository.CinemaRepository;
import org.example.cinticket.domain.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@RestController
public class CinemaController {

    CinemaRepository cinemaRepository;

    public static final String GET_CINEMAS = "/api/cinemas";
    @GetMapping(GET_CINEMAS)
    public List<CinemaEntity> GetCinemas(){
        return cinemaRepository.findAll();
    }
}

package org.example.cinticket.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.cinticket.api.dto.MovieDto;
import org.example.cinticket.api.factories.MovieDtoFactory;
import org.example.cinticket.domain.entities.MovieEntity;
import org.example.cinticket.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@RestController
public class MovieController {

    MovieDtoFactory movieDtoFactory;

    MovieRepository movieRepository;

    public static final String GET_MOVIES = "/api/movies";
    public static final String GET_MOVIES_BY_NAME = "/api/movies/name";
    public static final String GET_MOVIE_BY_ID = "/api/movies/id";

    @GetMapping(GET_MOVIES)
    public List<MovieEntity> GetMovies(){
        return movieRepository.findAll();
    }

    @GetMapping(GET_MOVIES_BY_NAME)
    public List<MovieEntity> GetMoviesByName(@RequestParam String name){
        String tmp = name.substring(0, 1).toUpperCase() + name.substring(1);
        return movieRepository.findAllByNameRuContaining(tmp);
    }

    @GetMapping(GET_MOVIE_BY_ID)
    public MovieEntity GetMovieById(@RequestParam int id){
        return movieRepository.findById(id);
    }
}






//        List<String> genres = new ArrayList<>();
//        //genres.add("триллер");
//        genres.add("мелодрама");
//        genres.add("комедия");
//
//        MovieEntity movie = MovieEntity.builder().nameRu("Любви не бывает?")
//                .genres(genres)
//                .posterUrl("https://www.film.ru/sites/default/files/movies/posters/50569845-3503330.jpeg")
//                .posterUrlPreview("https://www.film.ru/sites/default/files/movies/posters/50569845-3503330.jpeg")
//                .year(2024)
//                .description("Карьеристка Катя больше не верит в любовь. Неожиданно в ее размеренную жизнь врывается сосед Саша, бабник и ловелас. Это знак судьбы или возможность отомстить? И можно ли перевоспитать самоуверенного сердцееда и не влюбится в него?")
//                .length(105)
//                .trailer("https://www.youtube.com/watch?v=S3sD34aXfoI")
//                .build();
//        movieRepository.save(movie);
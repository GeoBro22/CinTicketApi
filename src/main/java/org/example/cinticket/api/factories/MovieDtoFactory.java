package org.example.cinticket.api.factories;

import org.example.cinticket.api.dto.MovieDto;
import org.example.cinticket.domain.entities.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoFactory {

    public MovieDto makeMovieDto(MovieEntity movieEntity){
        return MovieDto.builder()
                .id(movieEntity.getId())
                .nameRu(movieEntity.getNameRu())
                .genres(movieEntity.getGenres())
                .posterUrl(movieEntity.getPosterUrl())
                .posterUrlPreview(movieEntity.getPosterUrlPreview())
                .year(movieEntity.getYear())
                .description(movieEntity.getDescription())
                .length(movieEntity.getLength())
                .trailer(movieEntity.getTrailer())
                .build();
    }
}

package org.example.cinticket.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.cinticket.domain.entities.CinemaEntity;
import org.example.cinticket.domain.entities.MovieEntity;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SessionDto {
    Long sessionId;
    String sessionDate;
    String sessionTime;
    Long hallId;
    CinemaEntity cinema;
    MovieEntity movie;
    Integer price;

}

package org.example.cinticket.domain.repository;

import org.example.cinticket.api.dto.SessionDto;
import org.example.cinticket.domain.entities.MovieEntity;
import org.example.cinticket.domain.entities.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<SessionEntity, Long> {
    List<SessionEntity> findAllByMovieAndDate(MovieEntity movie, String date);
    SessionEntity findById(long id);
    List<SessionEntity> findAllByHall_Cinema_IdAndDate(Long cinemaId, String date);
}

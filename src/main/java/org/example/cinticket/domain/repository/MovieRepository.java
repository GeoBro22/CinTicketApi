package org.example.cinticket.domain.repository;

import org.example.cinticket.domain.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    List<MovieEntity> findAllByNameRuContaining(String name);
    MovieEntity findById(long id);

}

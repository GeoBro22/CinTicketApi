package org.example.cinticket.domain.repository;

import org.example.cinticket.domain.entities.CinemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<CinemaEntity, Long> {
}

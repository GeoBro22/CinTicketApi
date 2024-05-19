package org.example.cinticket.domain.repository;

import org.example.cinticket.domain.entities.ReservationEntity;
import org.example.cinticket.domain.entities.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity,Long> {
    List<ReservationEntity> findAllBySession(SessionEntity sessionId);
}

package org.example.cinticket.domain.repository;

import org.example.cinticket.domain.entities.HallEntity;
import org.example.cinticket.domain.entities.PlaceEntity;
import org.example.cinticket.domain.entities.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {
    List<PlaceEntity> findAllByHall_Id(long hallId);
    PlaceEntity findById(long id);
}

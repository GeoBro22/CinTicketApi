package org.example.cinticket.domain.repository;

import org.example.cinticket.domain.entities.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallRepository extends JpaRepository<HallEntity, Long> {
    List<HallEntity> findAllByCinema_Id(Long id);
}

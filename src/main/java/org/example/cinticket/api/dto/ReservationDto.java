package org.example.cinticket.api.dto;

import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.cinticket.domain.entities.PlaceEntity;
import org.example.cinticket.domain.entities.SessionEntity;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationDto {
    Long id;
    Integer reservationStatus;
    PlaceDto place;
    SessionDto session;
}
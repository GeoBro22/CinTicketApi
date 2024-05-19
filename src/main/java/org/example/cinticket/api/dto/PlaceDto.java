package org.example.cinticket.api.dto;

import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.cinticket.domain.entities.HallEntity;
import org.example.cinticket.domain.entities.SessionEntity;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaceDto {
    Long id;
    Integer rowNumber;
    Integer seatNumber;
    Integer position;
    Boolean isAvailable;
    HallEntity hall;
}

package org.example.cinticket.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "place")
public class PlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Integer rowNumber;
    Integer seatNumber;
    Integer position;
    Boolean isAvailable;
    @ManyToOne
    HallEntity hall;
}

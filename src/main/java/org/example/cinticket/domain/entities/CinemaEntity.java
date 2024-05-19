package org.example.cinticket.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "cinema")
public class CinemaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nameRu;
    String city;
    String address;
    String openingTime;
    String closingTime;
    String bankAccount;
//    @OneToMany
//    List<SessionEntity> sessions;

}

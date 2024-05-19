package org.example.cinticket.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CinemaDto {
    Long id;
    String nameRu;
    String city;
    String address;
    String openingTime;
    String closingTime;
    String bankAccount;
}

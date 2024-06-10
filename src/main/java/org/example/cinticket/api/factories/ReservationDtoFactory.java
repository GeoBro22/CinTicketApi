package org.example.cinticket.api.factories;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.cinticket.api.dto.PlaceDto;
import org.example.cinticket.api.dto.ReservationDto;
import org.example.cinticket.domain.entities.PlaceEntity;
import org.example.cinticket.domain.entities.ReservationEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ReservationDtoFactory {
    private final PlaceDtoFactory placeDtoFactory;
    private final SessionDtoFactory sessionDtoFactory;


    public ReservationDto makeReservationDto(ReservationEntity reservationEntity) {
        PlaceEntity placeEntity = reservationEntity.getPlace();
        PlaceDto place =PlaceDto.builder()
                .id(placeEntity.getId())
                .position(placeEntity.getPosition())
                .rowNumber(placeEntity.getRowNumber())
                .seatNumber(placeEntity.getSeatNumber())
                .hall(placeEntity.getHall())
                .build();

        return ReservationDto.builder()
                .id(reservationEntity.getId())
                .reservationStatus(reservationEntity.getReservationStatus())
                .place(placeDtoFactory.makePlaceDto(reservationEntity.getPlace()))
                .session(sessionDtoFactory.makeSessionDto(reservationEntity.getSession()))
                .build();
    }
    public List<ReservationDto> makeListReservationDto(List<ReservationEntity> reservationEntities) {
        List<ReservationDto> reservationDtos = new ArrayList<>();
        for (ReservationEntity reservationEntity : reservationEntities) {
            reservationDtos.add(makeReservationDto(reservationEntity));
        }
        return reservationDtos;
    }
}

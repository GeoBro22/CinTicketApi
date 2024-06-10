package org.example.cinticket.api.factories;

import org.example.cinticket.api.dto.PlaceDto;
import org.example.cinticket.api.dto.SessionDto;
import org.example.cinticket.domain.entities.PlaceEntity;
import org.example.cinticket.domain.entities.SessionEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaceDtoFactory {

    public PlaceDto makePlaceDto(PlaceEntity placeEntity) {
        return PlaceDto.builder()
                .id(placeEntity.getId())
                .position(placeEntity.getPosition())
                .rowNumber(placeEntity.getRowNumber())
                .seatNumber(placeEntity.getSeatNumber())
                .hall(placeEntity.getHall())
                .build();
    }
    public List<PlaceDto> makeListSessionDto(List<PlaceEntity> placeEntities) {
        List<PlaceDto> placeDtos = new ArrayList<>();
        for (PlaceEntity placeEntity : placeEntities) {
            placeDtos.add(makePlaceDto(placeEntity));
        }
        return placeDtos;
    }
}

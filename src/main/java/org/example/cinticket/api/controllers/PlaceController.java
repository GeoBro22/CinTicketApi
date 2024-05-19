package org.example.cinticket.api.controllers;

import jakarta.persistence.PostUpdate;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.cinticket.api.dto.PlaceDto;
import org.example.cinticket.api.dto.SessionDto;
import org.example.cinticket.api.factories.PlaceDtoFactory;
import org.example.cinticket.api.factories.SessionDtoFactory;
import org.example.cinticket.domain.entities.HallEntity;
import org.example.cinticket.domain.entities.PlaceEntity;
import org.example.cinticket.domain.entities.SessionEntity;
import org.example.cinticket.domain.repository.PlaceRepository;
import org.example.cinticket.domain.repository.SessionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@RestController
public class PlaceController {
    PlaceRepository placeRepository;
    PlaceDtoFactory placeDtoFactory;

    public static final String GET_PLACES_BY_SESSION = "/api/places/session";
    public static final String PUT_PLACES = "/api/places/place";

    @GetMapping(GET_PLACES_BY_SESSION)
    public List<PlaceDto> getPlacesBySession(@RequestParam Long hall) {
        return placeDtoFactory.makeListSessionDto(placeRepository.findAllByHall_Id(hall));
    }

    @PostMapping(PUT_PLACES)
    public List<PlaceEntity> putPlaces(@RequestParam long placeId) {
        PlaceEntity place = placeRepository.findById(placeId);
        placeRepository.saveAndFlush(PlaceEntity.builder()
                .id(place.getId())
                .seatNumber(place.getSeatNumber())
                .rowNumber(place.getRowNumber())
                .position(place.getPosition())
                .hall(place.getHall())
                .isAvailable(false)
                .build());
        return placeRepository.findAll();
    }

}

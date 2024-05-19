package org.example.cinticket.api.factories;

import org.example.cinticket.api.dto.SessionDto;
import org.example.cinticket.domain.entities.SessionEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SessionDtoFactory {
    public SessionDto makeSessionDto(SessionEntity sessionEntity) {
        return SessionDto.builder()
                .sessionId(sessionEntity.getId())
                .sessionDate(sessionEntity.getDate())
                .sessionTime(sessionEntity.getTime())
                .movie(sessionEntity.getMovie())
                .hallId(sessionEntity.getHall().getId())
                .cinema(sessionEntity.getHall().getCinema())
                .price(sessionEntity.getPrice())
                .build();
    }
    public List<SessionDto> makeListSessionDto(List<SessionEntity> sessionEntities) {
        List<SessionDto> sessionDtos = new ArrayList<>();
        for (int i = 0; i < sessionEntities.size(); i++) {
            sessionDtos.add(makeSessionDto(sessionEntities.get(i)));
        }
        return sessionDtos;
    }
}

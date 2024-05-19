package org.example.cinticket.api.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieDto {
    @NonNull
    Long id;
    @NonNull
    String nameRu;
    @NonNull
    List<String> genres;
    @NonNull
    String posterUrl;
    @NonNull
    String posterUrlPreview;
    @NonNull
    Integer year;
    @NonNull
    String description;
    @NonNull
    Integer length;
    @NonNull
    String trailer;
}

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
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nameRu;
    @ElementCollection
    List<String> genres;
    String posterUrl;
    String posterUrlPreview;
    Integer year;
    String description;
    Integer length;
    String trailer;

}

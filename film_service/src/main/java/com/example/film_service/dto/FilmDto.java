package com.example.film_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDto {

    private Long id;
    private String name;
    private String description;
    private LocalDate releaseDate;
    private String country;
    private int duration;
    private short ageLimit;
    private List<GenreDto> genres;
    private List<ActorRoleDto> actorRoles;
}

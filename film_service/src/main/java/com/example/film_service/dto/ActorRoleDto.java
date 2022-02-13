package com.example.film_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorRoleDto {

    private FilmDto film;
    private ActorDto actor;
    private String role;
}

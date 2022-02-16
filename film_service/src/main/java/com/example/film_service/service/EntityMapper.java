package com.example.film_service.service;

import com.example.film_service.dto.ActorDto;
import com.example.film_service.dto.ActorRoleDto;
import com.example.film_service.dto.FilmDto;
import com.example.film_service.dto.GenreDto;
import com.example.film_service.entity.Actor;
import com.example.film_service.entity.ActorRole;
import com.example.film_service.entity.Film;
import com.example.film_service.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    @Mappings({
            @Mapping(target = "firstName", source = "actor.firstName"),
            @Mapping(target = "secondName", source = "actor.secondName"),
            @Mapping(target = "age", source = "actor.age")
    })
    ActorDto actorToActorDto(Actor actor);

    @Mappings({
            @Mapping(target = "firstName", source = "actorDto.firstName"),
            @Mapping(target = "secondName", source = "actorDto.secondName"),
            @Mapping(target = "age", source = "actorDto.age")
    })
    Actor actorDtoToActor(ActorDto actorDto);

    @Mappings({
            @Mapping(target = "name", source = "film.name"),
            @Mapping(target = "description", source = "film.description"),
            @Mapping(target = "releaseDate", source = "film.releaseDate"),
            @Mapping(target = "duration", source = "film.duration"),
            @Mapping(target = "genres", source = "film.genres"),
            @Mapping(target = "actorRoles", source = "film.actorRoles")
    })
    FilmDto filmToFilmDto(Film film);

    @Mappings({
            @Mapping(target = "name", source = "filmDto.name"),
            @Mapping(target = "description", source = "filmDto.description"),
            @Mapping(target = "releaseDate", source = "filmDto.releaseDate"),
            @Mapping(target = "duration", source = "filmDto.duration"),
            @Mapping(target = "genres", source = "filmDto.genres"),
            @Mapping(target = "actorRoles", source = "filmDto.actorRoles")
    })
    Film filmDtoToFilm(FilmDto filmDto);

    @Mappings({
            @Mapping(target = "role", source = "actorRole.role"),
            @Mapping(target = "actor", source = "actorRole.actor")
    })
    ActorRoleDto actorRoleToActorRoleDto(ActorRole actorRole);

    @Mappings({
            @Mapping(target = "role", source = "actorRoleDto.role"),
            @Mapping(target = "actor", source = "actorRoleDto.actor")
    })
    ActorRole actorRoleDtoToActorRole(ActorRoleDto actorRoleDto);

    @Mappings({
            @Mapping(target = "name", source = "genre.name")
    })
    GenreDto genreToGenreDto(Genre genre);

    @Mappings({
            @Mapping(target = "name", source = "genreDto.name")
    })
    Genre genreDtoToGenre(GenreDto genreDto);
}

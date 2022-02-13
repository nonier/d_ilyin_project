package com.example.film_service.service;

import com.example.film_service.dto.FilmDto;
import com.example.film_service.entity.Film;
import com.example.film_service.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final EntityMapper entityMapper;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository, EntityMapper entityMapper) {
        this.filmRepository = filmRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public FilmDto findById(Long id) {
        return entityMapper.filmToFilmDto(filmRepository.getById(id));
    }

    @Override
    public List<FilmDto> findAll() {
        return filmRepository.findAll().stream().map(entityMapper::filmToFilmDto).collect(Collectors.toList());
    }

    @Override
    public FilmDto save(FilmDto filmDto) {
        return entityMapper.filmToFilmDto(filmRepository.save(entityMapper.filmDtoToFilm(filmDto)));
    }

    @Override
    public FilmDto update(Long id, FilmDto filmDto) {
        filmRepository.getById(id);
        Film updatedFilm = entityMapper.filmDtoToFilm(filmDto);
        updatedFilm.setId(id);
        return entityMapper.filmToFilmDto(filmRepository.save(updatedFilm));
    }

    @Override
    public void deleteById(Long id) {
        filmRepository.deleteById(id);
    }

}

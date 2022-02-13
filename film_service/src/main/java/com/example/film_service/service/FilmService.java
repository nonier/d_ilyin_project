package com.example.film_service.service;

import com.example.film_service.dto.FilmDto;

import java.util.List;

public interface FilmService {

    public FilmDto findById(Long id);

    public List<FilmDto> findAll();

    public FilmDto save(FilmDto filmDto);

    public FilmDto update(Long id, FilmDto filmDto);

    public void deleteById(Long id);
}

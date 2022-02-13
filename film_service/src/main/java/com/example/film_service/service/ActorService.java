package com.example.film_service.service;

import com.example.film_service.dto.ActorDto;

import java.util.List;

public interface ActorService {

    public ActorDto findById(Long id);

    public List<ActorDto> findAll();

    public ActorDto save(ActorDto actorDto);

    public ActorDto update(Long id, ActorDto actorDto);

    public void deleteById(Long id);
}

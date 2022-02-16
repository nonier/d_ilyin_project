package com.example.film_service.service;

import com.example.film_service.dto.ActorDto;
import com.example.film_service.entity.Actor;
import com.example.film_service.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    private final EntityMapper entityMapper;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository, EntityMapper entityMapper) {
        this.actorRepository = actorRepository;
        this.entityMapper = entityMapper;
    }


    @Override
    public ActorDto findById(Long id) {
        return entityMapper.actorToActorDto(actorRepository.getById(id));
    }

    @Override
    public List<ActorDto> findAll() {
        return actorRepository.findAll().stream().map(entityMapper::actorToActorDto).collect(Collectors.toList());
    }

    @Override
    public ActorDto save(ActorDto actorDto) {
        return entityMapper.actorToActorDto(actorRepository.save(entityMapper.actorDtoToActor(actorDto)));
    }

    @Override
    public ActorDto update(Long id, ActorDto actorDto) {
        actorRepository.getById(id);
        Actor updatedActor = entityMapper.actorDtoToActor(actorDto);
        updatedActor.setId(id);
        return entityMapper.actorToActorDto(actorRepository.save(updatedActor));
    }

    @Override
    public void deleteById(Long id) {
        actorRepository.deleteById(id);
    }
}

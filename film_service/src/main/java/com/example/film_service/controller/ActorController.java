package com.example.film_service.controller;

import com.example.film_service.dto.ActorDto;
import com.example.film_service.service.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<List<ActorDto>> findAll() {
        return ResponseEntity.ok(actorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDto> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(actorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ActorDto> save(@RequestBody ActorDto actorDto) {
        return ResponseEntity.ok(actorService.save(actorDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorDto> update(
            @PathVariable(name = "id") Long id,
            @RequestBody ActorDto actorDto
    ) {
        return ResponseEntity.ok(actorService.update(id, actorDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().build();
    }
}

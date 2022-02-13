package com.example.film_service.controller;

import com.example.film_service.dto.FilmDto;
import com.example.film_service.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<FilmDto>> findAll() {
        return ResponseEntity.ok(filmService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDto> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(filmService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FilmDto> save(@RequestBody FilmDto filmDto) {
        return ResponseEntity.ok(filmService.save(filmDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmDto> update(
            @PathVariable(name = "id") Long id,
            @RequestBody FilmDto filmDto
    ) {
        return ResponseEntity.ok(filmService.update(id, filmDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
        filmService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

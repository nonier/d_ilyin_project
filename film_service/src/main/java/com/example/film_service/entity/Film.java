package com.example.film_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "film")
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "country")
    private String country;

    @Column(name = "duration")
    private int duration;

    @Column(name = "age_limit")
    private short ageLimit;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_genre",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
    private List<ActorRole> actorRoles;
}

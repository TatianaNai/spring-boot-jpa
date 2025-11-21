package org.example.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "films")
@Entity
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @ManyToOne(targetEntity = Genre.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @OneToMany(targetEntity = Place.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    private List<Place> places;
}

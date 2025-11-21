package org.example.repository;

import org.example.domain.Film;

import java.util.List;

public interface FilmRepository {
    List<Film> findAll();

    Film getById(long id);
}

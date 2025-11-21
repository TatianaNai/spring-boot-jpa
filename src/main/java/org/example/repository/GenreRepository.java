package org.example.repository;

import org.example.domain.Genre;

public interface GenreRepository {

    Genre getById(long id);

    void insert(Genre genre);

    void update(Genre genre);

    void deleteById(long id);

    void detach(Genre genre);
}

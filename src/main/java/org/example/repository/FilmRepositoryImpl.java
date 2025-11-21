package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.example.domain.Film;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FilmRepositoryImpl implements FilmRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Film> findAll() {
        return entityManager.createQuery(
                "SELECT f FROM Film f JOIN FETCH f.genre JOIN FETCH f.places",
                Film.class).getResultList();
    }

    @Override
    public Film getById(long id) {
        return entityManager.find(Film.class, id);
    }
}

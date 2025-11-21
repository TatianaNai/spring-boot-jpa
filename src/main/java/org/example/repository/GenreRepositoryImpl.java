package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.domain.Genre;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
@RequiredArgsConstructor
public class GenreRepositoryImpl implements GenreRepository{
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Genre getById(long id) {
        return entityManager.find(Genre.class, id);
    }

    @Override
    public void insert(Genre genre) {
        if(genre.getId() == 0) {
            entityManager.persist(genre);
        } else {
            entityManager.merge(genre);
        }
    }

    @Override
    public void update(Genre genre) {
        entityManager.merge(genre);
    }

    @Override
    public void deleteById(long id) {
        Genre genre = entityManager.find(Genre.class, id);
        entityManager.remove(genre);
    }

    @Override
    public void detach(Genre genre) {
        entityManager.detach(genre);
    }
}

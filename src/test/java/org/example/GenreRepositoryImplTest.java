package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.domain.Genre;
import org.example.repository.GenreRepository;
import org.example.repository.GenreRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import(GenreRepositoryImpl.class)
public class GenreRepositoryImplTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void shouldHaveCorrectInsert() {
        Genre expectedGenre = new Genre(0L,"thriller");
        genreRepository.insert(expectedGenre);
        Genre actualGenre = entityManager.find(Genre.class, 4L);
        assertEquals(expectedGenre, actualGenre);
    }

    @Test
    public void shouldHaveCorrectUpdate() {
        Genre expectedGenre = entityManager.find(Genre.class, 1L);
        expectedGenre.setName("new name");
        genreRepository.update(expectedGenre);
        Genre actualGenre = entityManager.find(Genre.class, 1L);
        assertEquals("new name", actualGenre.getName());
    }

    @Test
    public void shouldHaveCorrectDelete() {
        genreRepository.deleteById(3L);
        Assertions.assertNull(entityManager.find(Genre.class, 3L));
    }
}

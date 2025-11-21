package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.domain.Film;
import org.example.repository.FilmRepository;
import org.example.repository.FilmRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@DataJpaTest
//@Import(FilmRepositoryImpl.class)
@SpringBootTest
@Transactional
public class FilmRepositoryImplTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private FilmRepository filmRepository;

    @Test
    public void shouldHaveCorrectGetById() {
        Film expectedFilm = entityManager.find(Film.class, 1L);
        Film actualFilm = filmRepository.getById(1L);
        assertEquals(expectedFilm, actualFilm);
    }

    @Test
    public void shouldHaveCorrectFindAll() {
        List<Film> expectedFilms = entityManager.createQuery(
                "SELECT f FROM Film f JOIN FETCH f.genre JOIN FETCH f.places",
                Film.class).getResultList();
        List<Film> actualFilms = filmRepository.findAll();
        assertEquals(expectedFilms, actualFilms);
    }
}

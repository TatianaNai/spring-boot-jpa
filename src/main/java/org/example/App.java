package org.example;

import org.example.domain.Film;
import org.example.domain.Genre;
import org.example.repository.FilmRepository;
import org.example.repository.GenreRepository;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class App {
    public static void main( String[] args ) throws SQLException {
        ApplicationContext context = SpringApplication.run(App.class, args);
        //Console.main(args);
        GenreRepository genreRepository = context.getBean(GenreRepository.class);
        FilmRepository filmRepository = context.getBean(FilmRepository.class);

        Genre genre = new Genre(0, "Horror");
        genreRepository.insert(genre);
        System.out.println(genreRepository.getById(3));
        genre.setName("Not Horror");
        genreRepository.update(genre);
        System.out.println("After changing: " + genreRepository.getById(3));
        genreRepository.deleteById(3);
        System.out.println(genreRepository.getById(3));

        List<Film> films = filmRepository.findAll();
        for(Film film : films) {
            System.out.println(film);
        }
    }
}

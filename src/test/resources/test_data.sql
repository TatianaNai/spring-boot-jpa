INSERT INTO genre(name)
VALUES ('horror'),
('comedy'),
('romance');

INSERT INTO films (title, genre_id)
VALUES ('Inception', 2),
('Scream', 1),
('Avengers', 2);

INSERT INTO place(name, film_id)
VALUES ('New York', 1),
 ('Italy', 2),
 ('Finland', 1);
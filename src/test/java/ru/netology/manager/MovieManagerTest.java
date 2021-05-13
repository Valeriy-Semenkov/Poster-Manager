package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieLibrary;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    MovieLibrary first = new MovieLibrary(1, "Иван вальевич меняет профессию", "Фантастика");
    MovieLibrary second = new MovieLibrary(2, "Золушка", "Мультфильм");
    MovieLibrary third = new MovieLibrary(3, "Один дома", "Комедия");
    MovieLibrary fourth = new MovieLibrary(4, "Форсаж", "Боевик");
    MovieLibrary fifth = new MovieLibrary(5, "Оно", "Ужасы");

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }


    @Test
    public void addMoviesToEmpty() {
        manager.add(first);
        assertArrayEquals(new MovieLibrary[]{first}, manager.getAll());
    }

    @Test
    public void addMoviesToExisted() {
        manager.add(first);
        MovieLibrary[] expected = new MovieLibrary[]{first};
        MovieLibrary[] actual = manager.getAll();
        assertArrayEquals(new MovieLibrary[]{first}, manager.getAll());

        manager.add(second);
        MovieLibrary[] expectedAdded = new MovieLibrary[]{second, first};
        MovieLibrary[] actualAdded = manager.getAll();
        assertArrayEquals(expectedAdded, actualAdded);
    }

    @Test
    void moviesForFeed() {
        setUp();
        MovieLibrary[] expected = new MovieLibrary[]{fifth, fourth, third, second, first};
        MovieLibrary[] actual = manager.getMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    void MoviesMinFeed() {
        manager = new MovieManager(3);
        setUp();
        MovieLibrary[] expected = new MovieLibrary[]{fifth, fourth, third};
        MovieLibrary[] actual = manager.getMovies();
        assertArrayEquals(expected, actual);
    }

}
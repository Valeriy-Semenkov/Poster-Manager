package ru.netology.manager;

import ru.netology.domain.MovieLibrary;
import ru.netology.domain.PurchaseItem;


public class MovieManager {
    public MovieLibrary[] movies = new MovieLibrary[0];
    private int feedCount = 10;

    public MovieManager() {

    }

    //Метод для добавления фильмов
    public void add(MovieLibrary movie) {
        int lenght = movies.length + 1;
        MovieLibrary[] tmp = new MovieLibrary[lenght];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;

    }

    //Метод получения всего списка элементов
    public MovieLibrary[] getAll() {
        MovieLibrary[] result = new MovieLibrary[movies.length];
        // перебираем массив в прямом порядке, кладем в обратном
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i -1;
            result[i] = movies[index];
        }
        return result;
    }
    //Метод, которотый выводит 10 фильфом
    public MovieLibrary[] getMovies() {
        int feed = this.feedCount;
        if (feed > movies.length)
            feed = movies.length;
        MovieLibrary[] result = new MovieLibrary[feed];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public MovieManager(int feedCount) {
        this.feedCount = feedCount;
    }
}

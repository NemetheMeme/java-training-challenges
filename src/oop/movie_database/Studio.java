package oop.movie_database;

public class Studio {

    private String name;
    private Movie movies[];

    public Studio(String name, Movie[] movies) {
        this.name = name;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public Movie[] getMovies() {
        return movies;
    }
}

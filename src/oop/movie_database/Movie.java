package oop.movie_database;

public class Movie {

    private int releaseYear;
    private String name;
    private Actor actors[];

    public Movie(int releaseYear, String name, Actor[] actors) {
        this.releaseYear = releaseYear;
        this.name = name;
        this.actors = actors;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Actor[] getActors() {
        return actors;
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }
}

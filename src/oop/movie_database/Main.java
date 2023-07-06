package oop.movie_database;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // This example is made using Aggregation, the objects' existence does not depend on other objects

        // Creating Awards
        Award oscar_1985 = new Award("oscar", 1985);
        Award oscar_1990 = new Award("oscar", 1990);
        Award oscar_2000 = new Award("oscar", 2000);
        Award oscar_2010 = new Award("oscar", 2010);
        Award oscar_2020 = new Award("oscar", 2020);

        // Creating Actors
        Actor Andrew  = new Actor("Andrew", 30, new Award[]{oscar_2010, oscar_2020});
        Actor Emma = new Actor("Emma", 29, new Award[]{oscar_2010, oscar_2020});
        Actor Miguel = new Actor("Miguel", 61, new Award[]{oscar_1985,oscar_1990});
        Actor Jenna = new Actor("Jenna", 52, new Award[]{oscar_1990, oscar_2000, oscar_2010});
        Actor Hannah = new Actor("Hannah", 45, new Award[]{oscar_2010, oscar_2000, oscar_2020});

        // Creating Movies
        Movie movie_one = new Movie(2000, "first_movie", new Actor[]{Hannah,Miguel});
        Movie movie_two = new Movie(2012, "second_movie", new Actor[]{Andrew,Emma});
        Movie movie_three = new Movie(2017, "third_movie", new Actor[]{Andrew,Emma,Hannah});
        Movie movie_four = new Movie(2015, "fourth_movie", new Actor[]{Hannah,Miguel,Jenna,Emma});

        // Creating Studios
        Studio studio_one = new Studio("first_studio", new Movie[]{movie_one,movie_two});
        Studio studio_two = new Studio("second_studio", new Movie[]{movie_three,movie_four});
        Studio studio_three = new Studio("third_studio", new Movie[]{movie_one, movie_two, movie_three});
        Studio studio_four = new Studio("fourth_studio", new Movie[]{movie_four});

        Studio[] studioDatabase = new Studio[]{studio_one,studio_two,studio_three, studio_four};


        String[] studiosMoreThanTwoMovies = getStudiosMoreThanTwoMovies(studioDatabase);
        for(String studio : studiosMoreThanTwoMovies){
            System.out.println(studio);
        }

        System.out.println('\n');
        String[] studiosByJenna = getStudiosByActor(studioDatabase, Jenna);
        for(String studio : studiosByJenna){
            System.out.println(studio);
        }

        System.out.println('\n');
        String[] moviesByAge = getMovieNamesWithActorsAbove50(studioDatabase);
        for (String movie : moviesByAge){
            System.out.println(movie);
        }

    }
    // Get all studio names that have published more than 2 movies
    static private String[] getStudiosMoreThanTwoMovies(Studio[] database){
        String[] studio_names;

        studio_names = Arrays.stream(database)
                .filter((Studio s) -> s.getMovies().length >= 2 )
                .map(Studio::getName)
                .toArray(String[]::new);
        return studio_names;
    }

    // Get all studio names by a specified actor
    static private String[] getStudiosByActor(Studio[] database, Actor specified_actor){
        String[] studio_names;

//        studio_names = Arrays.stream(database)
//                .filter((Studio s) ->
//        {
//            for (Movie movie: s.getMovies()) {
//                for (Actor actor: movie.getActors()) {
//                    if(actor.getName().equals(specified_actor.getName())){
//                        return true;
//                    }
//                }
//            }
//            return false;
//        })
//                .map(Studio::getName).toArray(String[]::new);

        studio_names = Arrays.stream(database)
                .filter(studio -> Arrays.stream(studio.getMovies())
                        .anyMatch(movie -> Arrays.stream(movie.getActors())
                                .anyMatch(actor -> actor.getName().equals(specified_actor.getName()) ) ))
                .map(Studio::getName)
                .toArray(String[]::new);

        return studio_names;

    }

    // Get all movie names with at least one actor that is above 50 years old
    static protected String[] getMovieNamesWithActorsAbove50(Studio[] database) {
        String[] movie_names;

        movie_names =  Arrays.stream(database)
                .flatMap(studio -> Arrays.stream(studio.getMovies()))
                .filter(movie -> Arrays.stream(movie.getActors()).anyMatch(actor -> actor.getAge() > 50))
                .map(Movie::getName)
                .distinct()
                .toArray(String[]::new);

        return movie_names;
    }

}

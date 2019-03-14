package com.example.movielibrary;

import java.io.Serializable;
import java.util.Objects;

public class Movies implements Serializable {
    private String movieName;
    private int movieRating;
    private int movieID;
    static int last_movieID=0;

    public Movies() {
    }

    public Movies(String movieName, int movieRating) {
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.last_movieID++;
        this.movieID = this.last_movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return movieRating == movies.movieRating &&
                movieID == movies.movieID &&
                Objects.equals(movieName, movies.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, movieRating, movieID);
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movieName='" + movieName + '\'' +
                ", movieRating=" + movieRating +
                ", movieID=" + movieID +
                '}';
    }
}


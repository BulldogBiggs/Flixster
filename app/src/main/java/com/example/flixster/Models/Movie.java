package com.example.flixster.Models;

import android.widget.RatingBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    String posterPath;
    String title;
    String overview;
    String backgroundPath;
    Double rating;

    public Movie() {}

    public Movie(JSONObject jsonObjct) throws JSONException {
        posterPath = jsonObjct.getString("poster_path");
        title = jsonObjct.getString("title");
        overview =  jsonObjct.getString("overview");
        backgroundPath = jsonObjct.getString("backdrop_path");
        rating = jsonObjct.getDouble("vote_average");
    }

    public static List<Movie> fromJsonArray (JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }
    public String getBackgroundPath() {

        return  String.format("https://image.tmdb.org/t/p/w342/%s", backgroundPath);
    }
    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public Double getRating(){return rating;}
}

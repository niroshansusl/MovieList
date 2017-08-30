package com.movieslist.movies.rest;

import com.movieslist.movies.model.BeanMoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by niroshan on 8/29/2017.
 */

public interface ApiInterface {
    @GET("movies.php")
    Call<BeanMoviesResponse> getTopRatedMovies();
}

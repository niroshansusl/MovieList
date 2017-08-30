package com.movieslist.movies.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niroshan on 8/29/2017.
 */

public class BeanMovie {
    @SerializedName("movie_id")
    private Integer movie_id;
    @SerializedName("movie_name")
    private String movie_name;
    @SerializedName("portrait_image")
    private String portrait_image;
    @SerializedName("movie_content")
    private String movie_content;
    @SerializedName("booking_start_date")
    private String booking_start_date;
    @SerializedName("date_release")
    private String date_release;
    @SerializedName("end_date")
    private String end_date;
    @SerializedName("imdb_rate")
    private Double imdb_rate;
    @SerializedName("trailer")
    private String trailer;
    @SerializedName("url_key")
    private String url_key;
    @SerializedName("genre")
    private String genre;
    @SerializedName("theater")
    private List<BeanTheater> theater = new ArrayList<BeanTheater>();

    public BeanMovie(Integer movie_id, String movie_name, String portrait_image, String movie_content,
                     String booking_start_date, String date_release, String end_date, Double imdb_rate,
                     String trailer, String url_key, String genre, List<BeanTheater> theater) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.portrait_image = portrait_image;
        this.movie_content = movie_content;
        this.booking_start_date = booking_start_date;
        this.date_release = date_release;
        this.end_date = end_date;
        this.imdb_rate = imdb_rate;
        this.trailer = trailer;
        this.url_key = url_key;
        this.genre = genre;
        this.theater = theater;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getPortrait_image() {
        return portrait_image;
    }

    public void setPortrait_image(String portrait_image) {
        this.portrait_image = portrait_image;
    }

    public String getMovie_content() {
        return movie_content;
    }

    public void setMovie_content(String movie_content) {
        this.movie_content = movie_content;
    }

    public String getBooking_start_date() {
        return booking_start_date;
    }

    public void setBooking_start_date(String booking_start_date) {
        this.booking_start_date = booking_start_date;
    }

    public String getDate_release() {
        return date_release;
    }

    public void setDate_release(String date_release) {
        this.date_release = date_release;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Double getImdb_rate() {
        return imdb_rate;
    }

    public void setImdb_rate(Double imdb_rate) {
        this.imdb_rate = imdb_rate;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getUrl_key() {
        return url_key;
    }

    public void setUrl_key(String url_key) {
        this.url_key = url_key;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<BeanTheater> getTheater() {
        return theater;
    }

    public void setTheater(List<BeanTheater> theater) {
        this.theater = theater;
    }
}

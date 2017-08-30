package com.movieslist.movies.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by niroshan on 8/29/2017.
 */

public class BeanTheater {

    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private String image;
    @SerializedName("cinema_name")
    private String cinema_name;
    @SerializedName("cinema_address")
    private String cinema_address;
    @SerializedName("url_key")
    private String url_key;

    public BeanTheater(String name, String image, String cinema_name, String cinema_address, String url_key) {
        this.name = name;
        this.image = image;
        this.cinema_name = cinema_name;
        this.cinema_address = cinema_address;
        this.url_key = url_key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    public String getCinema_address() {
        return cinema_address;
    }

    public void setCinema_address(String cinema_address) {
        this.cinema_address = cinema_address;
    }

    public String getUrl_key() {
        return url_key;
    }

    public void setUrl_key(String url_key) {
        this.url_key = url_key;
    }
}

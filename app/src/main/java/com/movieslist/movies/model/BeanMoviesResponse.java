package com.movieslist.movies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by niroshan on 8/29/2017.
 */

public class BeanMoviesResponse {
    @SerializedName("status")
    private boolean status;
    @SerializedName("data")
    private List<BeanMovie> data;
    @SerializedName("message")
    private String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<BeanMovie> getData() {
        return data;
    }

    public void setData(List<BeanMovie> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.myapplication2.app;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import org.apache.http.protocol.HTTP;

import java.util.List;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by oliver on 02/04/14.
 */
public class testApp {
    private static final String API_URL = "http://local.panel.bcarefool.com";

    static class Contributor {
        String id;
        String title;
        String review;
    }

    static class Checkingnew {
       public String title;
       public int    rate;
       public String rate_date;
       public String review;
       public String latitude;
       public String longitude;
    }

    interface Cheking {
        //@GET("/test_{id}.json")
        @GET("/api/v{id}/reviews")
        List<Contributor> contributors(
                @Path("id") String id
        );


        @POST("/api/v1/checkins")
        @Headers({
                HTTP.CONN_DIRECTIVE + ":" + HTTP.CONN_CLOSE,
        })
        List<Checkingnew> createCheckin(
                @Body Checkingnew nuevo) throws RetrofitError;

    }

    public static void main(String... args) {
        // Create a very simple REST adapter which points the GitHub API endpoint.

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();

        // Create an instance of our GitHub API interface.
        Cheking cheking = restAdapter.create(Cheking.class);


        Checkingnew nuevo = new Checkingnew();

        nuevo.title = "Prueba";
        nuevo.rate = 878;
        nuevo.rate_date = "2010-02-01 02:39:10";
        nuevo.review = "PruebaPruebaPruebaPruebaPruebaPrueba";
        nuevo.latitude = "1231312";
        nuevo.longitude = "3453534";

       cheking.createCheckin(nuevo);

    }
}
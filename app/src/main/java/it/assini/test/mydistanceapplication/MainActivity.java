package it.assini.test.mydistanceapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static String getDistanceMatrixAPIUrl() {

        String output = "json";
        String metrica = "metric";
        String origins = "Bobcaygeon+ON|24+Sussex+Drive+Ottawa+ON";
        String destinations = "New+York+City,NY";
        String key = "AIzaSyDvVi80jg583DKu0b0lcyUFWY5rQ_sa6PM";

        String arrival_time = ""; //Specifies the desired time of arrival for transit requests, in seconds since midnight, January 1, 1970 UTC.
        String departure_time = ""; //The desired time of departure. You can specify the time as an integer in seconds since midnight, January 1, 1970 UTC.

        String url = "https://maps.googleapis.com/maps/api/distancematrix/" + output + "?units=" + metrica + "&origins=" + origins + "&destinations=" + destinations + "&key=" + key;

        return url;
    }

    public static void main(String[] args) {

        System.out.println(getDistanceMatrixAPIUrl());

    }
}

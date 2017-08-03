package it.assini.test.mydistanceapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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

        String str = getDistanceMatrixAPIUrl();
        System.out.println(str);

        String title;
        String des;

        try {
            URL url = new URL(str);
            URLConnection urlc = url.openConnection();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String line;
            while ((line = bfr.readLine()) != null) {
                JSONArray jsa = new JSONArray(line);
                for (int i = 0; i < jsa.length(); i++) {
                    JSONObject jo = (JSONObject) jsa.get(i);
                    title = jo.getString("deal_title");  //tag name "deal_title",will return value that we save in title string
                    des = jo.getString("deal_description");
                    System.out.println(title + " " + des);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

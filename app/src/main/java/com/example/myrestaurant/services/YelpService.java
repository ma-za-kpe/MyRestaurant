package com.example.myrestaurant.services;
import android.util.Log;

import com.example.myrestaurant.Constants;
import com.example.myrestaurant.models.Restaurant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class YelpService {

    public static void findRestaurants(String location, Callback callback) {
        //OkHttpClient client to create and send our request
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YELP_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YELP_LOCATION_QUERY_PARAMETER, location);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", Constants.YELP_TOKEN)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);//perform asyncronous requests The OkHttp enqueue() method will add our request to a queue. Since this is the only call in the queue of our app, it will run right away. OkHttp will create a new thread to dispatch our request. Once it has a readable response it will trigger our callback method, where it will send our response data.

    }

    public ArrayList<Restaurant> processResults(Response response){
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        try{
            //Create a new restaurants array to eventually contain all restaurant objects.
            String xmlData = response.body().string();

            //Transform the API response into a String with String jsonData = response.body().string();
//            JSONObject yelpJSON = new JSONObject(jsonData);
            JSONObject yelpJSON = XML.toJSONObject(xmlData);
            JSONObject jsonResponse = new JSONObject(xmlData);

            Log.d("XML", xmlData);

            Log.d("JSON", jsonResponse.toString());

            //create a Java JSONObject from the response. ++ target the "businesses" array from the response
            JSONArray businessesJSON = jsonResponse.getJSONArray("businesses");

            if (response.isSuccessful()){
                //collect the name, phone, url, rating, image_url, location (both latitude and longitude), addresses, and categories for each restaurant.
                for (int i = 0; i < businessesJSON.length(); i++){
                    JSONObject restaurantJSON = businessesJSON.getJSONObject(i);
                    String name = restaurantJSON.getString("name");
                    String phone = restaurantJSON.optString("display_phone", "Phone not available");
                    String website = restaurantJSON.getString("url");
                    double rating = restaurantJSON.getDouble("rating");
                    String imageUrl = restaurantJSON.getString("image_url");
                    double latitude = restaurantJSON.getJSONObject("coordinates").getDouble("latitude");
                    double longitude = restaurantJSON.getJSONObject("coordinates").getDouble("longitude");
                    ArrayList<String> address = new ArrayList<>();
                    JSONArray addressJSON = restaurantJSON.getJSONObject("location").getJSONArray("display_address");
                    for (int y = 0; y < addressJSON.length(); y++){
                        address.add(addressJSON.get(y).toString());
                    }
                    ArrayList<String> categories = new ArrayList<>();
                    JSONArray categoriesJSON = restaurantJSON.getJSONArray("categories");
                    for (int y = 0; y < categoriesJSON.length(); y++){
                        categories.add(categoriesJSON.getJSONObject(y).getString("title"));
                    }
                    //create a new Restaurant object for each restaurant in the response.
                    Restaurant restaurant = new Restaurant(name, phone, website, rating,
                            imageUrl, address, latitude, longitude, categories);
                    restaurants.add(restaurant);
                }
            }
            //We catch any errors, then return the array of Restaurant objects.
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

}

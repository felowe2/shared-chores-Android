package com.epicodus.sharedchores.services;

import android.util.Log;

import com.epicodus.sharedchores.Constants;
import com.epicodus.sharedchores.models.CleaningService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by Guest on 7/12/16.
 */
public class YelpService {


    public static void findCleaningServices(String location, Callback callback) {

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.YELP_CONSUMER_KEY, Constants.YELP_CONSUMER_SECRET);
        consumer.setTokenWithSecret(Constants.YELP_TOKEN, Constants.YELP_TOKEN_SECRET);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YELP_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YELP_LOCATION_QUERY_PARAMETER, location);

        String url = urlBuilder.build().toString();

        Log.v("URL", url);

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }
    public ArrayList<CleaningService> processResults(Response response) {
        ArrayList<CleaningService> cleaningServices = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject yelpJSON = new JSONObject(jsonData);
                JSONArray businessesJSON = yelpJSON.getJSONArray("businesses");
                for (int i = 0; i < businessesJSON.length(); i++) {
                    JSONObject apiAnswerJSON = businessesJSON.getJSONObject(i);
                    String name = apiAnswerJSON.getString("name");
                    int reviews = apiAnswerJSON.getInt("review_count");
                    String phone = apiAnswerJSON.optString("display_phone", "Phone not available");
                    String website = apiAnswerJSON.getString("url");
                    double rating = apiAnswerJSON.getDouble("rating");
                    String imageUrl = apiAnswerJSON.optString("image_url", "Phone image available");
                    double latitude = apiAnswerJSON.getJSONObject("location")
                            .getJSONObject("coordinate").getDouble("latitude");
                    double longitude = apiAnswerJSON.getJSONObject("location")
                            .getJSONObject("coordinate").getDouble("longitude");
                    ArrayList<String> address = new ArrayList<>();
                    JSONArray addressJSON = apiAnswerJSON.getJSONObject("location")
                            .getJSONArray("display_address");
                    for (int y = 0; y < addressJSON.length(); y++) {
                        address.add(addressJSON.get(y).toString());
                    }

                    ArrayList<String> categories = new ArrayList<>();
                    JSONArray categoriesJSON = apiAnswerJSON.getJSONArray("categories");

                    CleaningService cleaningService = new CleaningService(name, phone, website, rating,
                            imageUrl, address, latitude, longitude, reviews);
                    cleaningServices.add(cleaningService);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cleaningServices;
    }

}

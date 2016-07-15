package com.epicodus.sharedchores.ui.api;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.CleaningService;
import com.epicodus.sharedchores.services.YelpService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CleaningServicesActivity extends AppCompatActivity {
    public static final String TAG = CleaningServicesActivity.class.getSimpleName();

    @Bind(R.id.locationTextView) TextView mLocationTextView;
    @Bind(R.id.listView) ListView mListView;
//    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    public ArrayList<CleaningService> mCleaningServices = new ArrayList<>();

//    private String[] cleaningServices = new String[]{"Sweet Hereafter", "Cricket", "Hawthorne Fish House", "Viking Soul Food",
//            "Red Square", "Horse Brass", "Dick's Kitchen", "Taco Bell", "Me Kha Noodle Bar",
//            "La Bonita Taqueria", "Smokehouse Tavern", "Pembiche", "Kay's Bar", "Gnarly Grey", "Slappy Cakes", "Mi Mero Mole"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning_services);

        ButterKnife.bind(this);

//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cleaningServices);
//        mListView.setAdapter(adapter);

//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String restaurant = ((TextView) view).getText().toString();
//                Toast.makeText(CleaningServicesActivity.this, restaurant, Toast.LENGTH_LONG).show();
//            }
//        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        mLocationTextView.setText("Here are all the cleaning services near you");

        getCleaningServices(location);
    }


    private void getCleaningServices(String location) {
        final YelpService yelpService = new YelpService();

        yelpService.findCleaningServices(location, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response){
                //                    throws IOException {
//                try {
//                    String jsonData = response.body().string();

                    mCleaningServices = yelpService.processResults(response);
//                    if (response.isSuccessful()) {
//                        Log.v(TAG, jsonData);


                    CleaningServicesActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            String[] cleaningServiceNames = new String[mCleaningServices.size()];
                            for (int i = 0; i < cleaningServiceNames.length; i++) {
                                cleaningServiceNames[i] = mCleaningServices.get(i).getName();
                            }

                            ArrayAdapter adapter = new ArrayAdapter(CleaningServicesActivity.this,
                                    android.R.layout.simple_list_item_1, cleaningServiceNames);
                            mListView.setAdapter(adapter);

                            for (CleaningService cleaningService : mCleaningServices) {
                                Log.d(TAG, "Name: " + cleaningService.getName());
                                Log.d(TAG, "Phone: " + cleaningService.getPhone());
                                Log.d(TAG, "Website: " + cleaningService.getWebsite());
                                Log.d(TAG, "Image url: " + cleaningService.getImageUrl());
                                Log.d(TAG, "Rating: " + Double.toString(cleaningService.getRating()));
                                Log.d(TAG, "Address: " + android.text.TextUtils.join(", ", cleaningService.getAddress()));
                                Log.d(TAG, "Categories: " + cleaningService.getCategories().toString());
                            }
                        }
                    });
            }
        });
    }
}


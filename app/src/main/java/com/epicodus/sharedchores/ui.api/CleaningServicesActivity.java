package com.epicodus.sharedchores.ui.api;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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

import com.epicodus.sharedchores.Constants;
import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.adapters.CleaningServiceListAdapter;
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

    private CleaningServiceListAdapter mAdapter;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentAddress;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    public ArrayList<CleaningService> mCleaningServices = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning_services);

        ButterKnife.bind(this);


        Intent intent = getIntent();
        String location = intent.getStringExtra("location");


        getCleaningServices(location);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
        Log.d("Shared Pref Location", mRecentAddress);
        if (mRecentAddress != null) {
            getCleaningServices(mRecentAddress);
        }
    }


    private void getCleaningServices(String location) {
        final YelpService yelpService = new YelpService();

        yelpService.findCleaningServices(location, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {


                mCleaningServices = yelpService.processResults(response);

                CleaningServicesActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        mAdapter = new CleaningServiceListAdapter(getApplicationContext(), mCleaningServices);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(CleaningServicesActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);

                    }
                });
            }
        });
    }
}


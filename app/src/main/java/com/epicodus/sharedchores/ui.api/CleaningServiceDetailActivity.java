package com.epicodus.sharedchores.ui.api;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.adapters.CleaningServicePagerAdapter;
import com.epicodus.sharedchores.models.CleaningService;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CleaningServiceDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;

    private CleaningServicePagerAdapter adapterViewPager;

    ArrayList<CleaningService> mCleaningServices = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning_service_detail);
        ButterKnife.bind(this);

        mCleaningServices = Parcels.unwrap(getIntent().getParcelableExtra("cleaningServices"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new CleaningServicePagerAdapter(getSupportFragmentManager(), mCleaningServices);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}

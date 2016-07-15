package com.epicodus.sharedchores.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.sharedchores.models.CleaningService;
import com.epicodus.sharedchores.ui.CleaningServiceDetailFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 7/14/16.
 */
public class CleaningServicePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<CleaningService> mCleaningServices;

    public CleaningServicePagerAdapter(FragmentManager fm, ArrayList<CleaningService> cleaningServices) {
        super(fm);
        mCleaningServices = cleaningServices;
    }

    @Override
    public Fragment getItem(int position) {
        return CleaningServiceDetailFragment.newInstance(mCleaningServices.get(position));
    }

    @Override
    public int getCount() {
        return mCleaningServices.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCleaningServices.get(position).getName();
    }


}

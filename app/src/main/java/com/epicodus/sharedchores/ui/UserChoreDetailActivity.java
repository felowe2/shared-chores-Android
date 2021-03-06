package com.epicodus.sharedchores.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.sharedchores.Constants;
import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.Chore;
import com.epicodus.sharedchores.ui.api.CleaningServicesActivity;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserChoreDetailActivity extends AppCompatActivity implements View.OnClickListener {

    Chore mChore;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Bind(R.id.userZipCode) EditText mUserZipCode;
    @Bind(R.id.helpSearchButton) Button mHelpSearchButton;
    @Bind(R.id.choreTitleTextView) TextView mChoreTitleTextView;
    @Bind(R.id.choreDescriptionTextView) TextView mChoreDescriptionTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_chore_detail);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();



        mChore = Parcels.unwrap(getIntent().getParcelableExtra("chore"));
        mChoreTitleTextView.setText("chore: " + mChore.getTitle());
        mChoreDescriptionTextView.setText("description: " + mChore.getDescription());

        mHelpSearchButton.setOnClickListener(this);
    }

    public void onClick(View v) {

        if (v == mHelpSearchButton) {
            String location = mUserZipCode.getText().toString();
            if (!(location).equals("")) {
                addToSharedPreferences(location);
            }
            Intent intent = new Intent(UserChoreDetailActivity.this, CleaningServicesActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
    }
}

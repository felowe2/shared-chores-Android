package com.epicodus.sharedchores.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.ui.api.CleaningServicesActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserChoreDetailActivity extends AppCompatActivity implements View.OnClickListener{


    @Bind(R.id.userZipCode) EditText mUserZipCode;
    @Bind(R.id.helpSearchButton) Button mHelpSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_chore_detail);

        ButterKnife.bind(this);

        mHelpSearchButton.setOnClickListener(this);
    }

    public void onClick(View v) {

        String location = mUserZipCode.getText().toString();
        Log.d("TAG", location);
        Intent intent = new Intent(UserChoreDetailActivity.this, CleaningServicesActivity.class);
        intent.putExtra("location", location);
        startActivity(intent);
    }
}

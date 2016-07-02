package com.epicodus.sharedchores;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WelcomePageActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.welcomeButton)
    Button mWelcomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        ButterKnife.bind(this);

        //FONTS EVERYTHING
        mWelcomeButton = (Button) findViewById(R.id.welcomeButton);
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mWelcomeButton.setTypeface(boldieFont);

// END OF FONTS

        mWelcomeButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mWelcomeButton) {
            Intent goToUserPage = new Intent(this, UserPageActivity.class);
            startActivity(goToUserPage);
        }
    }
}

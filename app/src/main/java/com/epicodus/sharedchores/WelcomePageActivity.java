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
    @Bind(R.id.getStartedButton) Button mGetStartedButton;
    @Bind(R.id.welcomeTextView) TextView mWelcomeTextView;
    @Bind(R.id.aboutUsTextView) TextView mAboutUsTextView;
    @Bind(R.id.aboutUsTitle) TextView mAboutUsTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        ButterKnife.bind(this);

//FONTS EVERYTHING
        mGetStartedButton = (Button) findViewById(R.id.getStartedButton);
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mGetStartedButton.setTypeface(boldieFont);
        mAboutUsTitle.setTypeface(boldieFont);

// END OF FONTS

        Intent showUsername = getIntent();
        String username = showUsername.getStringExtra("username");
        mWelcomeTextView.setText("Welcome to Shared Chores " + username + " we are happy you're here!");
        mAboutUsTextView.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");

        mGetStartedButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mGetStartedButton) {
            Intent goToUserPage = new Intent(this, UserPageActivity.class);
            startActivity(goToUserPage);
        }
    }
}

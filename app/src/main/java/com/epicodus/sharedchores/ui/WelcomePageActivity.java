package com.epicodus.sharedchores.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.User;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WelcomePageActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.getStartedButton) Button mGetStartedButton;
    @Bind(R.id.welcomeTextView) TextView mWelcomeTextView;
    @Bind(R.id.aboutUsTextView) TextView mAboutUsTextView;
    @Bind(R.id.aboutUsTitle) TextView mAboutUsTitle;

    private User mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        ButterKnife.bind(this);

//FONTS EVERYTHING
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mGetStartedButton.setTypeface(boldieFont);
        mAboutUsTitle.setTypeface(boldieFont);

// END OF FONTS

//        mUsername = Parcels.unwrap(getIntent().getParcelableExtra("username"));
//        String username = mUsername.getName();
//        mWelcomeTextView.setText("Welcome to Shared Chores \n " + username + " \n we are happy you're here!");

        Intent intent = getIntent();
        String username = intent.getStringExtra("userName");
        mWelcomeTextView.setText("Welcome to Shared Chores \n " + username + " \n we are happy you're here!");

        mGetStartedButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mGetStartedButton) {
            Intent goToUserPage = new Intent(WelcomePageActivity.this, UserChoreListActivity.class);
            startActivity(goToUserPage);
        }
    }
}

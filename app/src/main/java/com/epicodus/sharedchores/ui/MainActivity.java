package com.epicodus.sharedchores.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.sharedchores.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.welcome) TextView mSharedChoresTitle;
    @Bind(R.id.sharedHappiness) TextView mSharedHappiness;
    @Bind(R.id.signInButton) Button mSignInButton;
    @Bind(R.id.signUpButton) Button mSignUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//FONTS EVERYTHING
        mSharedChoresTitle = (TextView) findViewById(R.id.welcome);
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mSharedChoresTitle.setTypeface(boldieFont);
        mSharedHappiness.setTypeface(boldieFont);
        mSignUpButton.setTypeface(boldieFont);
        mSignInButton.setTypeface(boldieFont);
// END OF FONTS

        mSignUpButton.setOnClickListener(this);
        mSignInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            if (v == mSignUpButton) {
                Intent goToSignUpPage = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(goToSignUpPage);
        }    if (v == mSignInButton) {
                Intent goToSignInPage = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(goToSignInPage);
        }

    }
}

package com.epicodus.sharedchores;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.logIntextView) TextView mLogInTextView;
    @Bind(R.id.emailSignIn) EditText mEmailSignIn;
    @Bind(R.id.passwordSignIn) EditText mPasswordSignIn;
    @Bind(R.id.signInButton) Button mSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_sign_in);
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        AppEventsLogger.activateApp(this);
        ButterKnife.bind(this);

//FONTS EVERYTHING
        mSignInButton = (Button) findViewById(R.id.signInButton);
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mSignInButton.setTypeface(boldieFont);
        mLogInTextView.setTypeface(boldieFont);
// END OF FONTS

        mSignInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSignInButton) {
            String emailSignIn = mEmailSignIn.getText().toString();
            String passwordSignIn = mPasswordSignIn.getText().toString();

            Intent goToUserPage = new Intent(this, UserPageActivity.class);
            goToUserPage.putExtra("email", emailSignIn);
            goToUserPage.putExtra("password", passwordSignIn);
            startActivity(goToUserPage);
        }
    }
}

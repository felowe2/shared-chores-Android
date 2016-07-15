package com.epicodus.sharedchores.ui;

import com.epicodus.sharedchores.R;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.logInHeader) TextView mLogInHeader;
    @Bind(R.id.emailSignIn) EditText mEmailSignIn;
    @Bind(R.id.passwordSignIn) EditText mPasswordSignIn;
    @Bind(R.id.signInButton) Button mSignInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
;
        ButterKnife.bind(this);

//FONTS EVERYTHING
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mSignInButton.setTypeface(boldieFont);
        mLogInHeader.setTypeface(boldieFont);

// END OF FONTS

        mSignInButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == mSignInButton) {
            String emailSignIn = mEmailSignIn.getText().toString();
            String passwordSignIn = mPasswordSignIn.getText().toString();

            Intent goToUserPage = new Intent(this, CreateGroupActivity.class);
            goToUserPage.putExtra("email", emailSignIn);
            goToUserPage.putExtra("password", passwordSignIn);
            startActivity(goToUserPage);
        }
    }
}

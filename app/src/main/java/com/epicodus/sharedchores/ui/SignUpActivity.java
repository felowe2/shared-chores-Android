package com.epicodus.sharedchores.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.sharedchores.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.signUpButton) Button mSignUpButton;
    @Bind(R.id.createAccountHeader) TextView mCreateAccountHeader;
    @Bind(R.id.usernameInput) EditText mUsernameInput;
    @Bind(R.id.emailInput) EditText mEmailInput;
    @Bind(R.id.passwordInput) EditText mPasswordInput;
    @Bind(R.id.password2Input) EditText mPassword2Input;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

//FONTS EVERYTHING
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mCreateAccountHeader.setTypeface(boldieFont);
        mSignUpButton.setTypeface(boldieFont);
// END OF FONTS

        mSignUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSignUpButton) {
            String usernameInput = mUsernameInput.getText().toString();
            String emailInput = mEmailInput.getText().toString();
            String passwordInput = mPasswordInput.getText().toString();
            String password2Input = mPassword2Input.getText().toString();

            Intent goToWelcomePage = new Intent(this, WelcomePageActivity.class);
            goToWelcomePage.putExtra("username", usernameInput);
            goToWelcomePage.putExtra("email", emailInput);
            goToWelcomePage.putExtra("password", passwordInput);
            goToWelcomePage.putExtra("password2", password2Input);
            startActivity(goToWelcomePage);
        }

    }
}

package com.epicodus.sharedchores;

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

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.signInButton) Button mSubmitSignUpButton;
    @Bind(R.id.SucessMessageTextView) TextView mCreateAccount;
    @Bind(R.id.usernameInput) EditText mUsernameInput;
    @Bind(R.id.emailInput) EditText mEmailInput;
    @Bind(R.id.passwordSignIn) EditText mPasswordInput;
    @Bind(R.id.password2Input) EditText mPassword2Input;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

//FONTS EVERYTHING
        mCreateAccount = (TextView) findViewById(R.id.SucessMessageTextView);
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mCreateAccount.setTypeface(boldieFont);
        mSubmitSignUpButton.setTypeface(boldieFont);
// END OF FONTS

        mSubmitSignUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSubmitSignUpButton) {
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

package com.epicodus.sharedchores.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.sharedchores.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = SignUpActivity.class.getSimpleName();

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Bind(R.id.createAccountHeader)
    TextView mCreateAccountHeader;
    @Bind(R.id.usernameInput)
    EditText mUsernameInput;
    @Bind(R.id.emailInput)
    EditText mEmailInput;
    @Bind(R.id.passwordInput)
    EditText mPasswordInput;
    @Bind(R.id.password2Input)
    EditText mPassword2Input;
    @Bind(R.id.signUpButton)
    Button mSignUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

//FONTS EVERYTHING
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mCreateAccountHeader.setTypeface(boldieFont);
        mSignUpButton.setTypeface(boldieFont);
// END OF FONTS

        mSignUpButton.setOnClickListener(this);

        createAuthStateListener();
    }

    @Override
    public void onClick(View v) {
        if (v == mSignUpButton) {

            createNewUser();
        }
    }

    private void createNewUser() {
        String username = mUsernameInput.getText().toString().trim();
        String email = mEmailInput.getText().toString().trim();
        String password = mPasswordInput.getText().toString().trim();
        String password2 = mPassword2Input.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Authentication successful");
                        } else {
                            Toast.makeText(SignUpActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        Intent goToWelcomePage = new Intent(this, WelcomePageActivity.class);
        goToWelcomePage.putExtra("username", username);
        goToWelcomePage.putExtra("email", email);
        goToWelcomePage.putExtra("password", password);
        goToWelcomePage.putExtra("password2", password2);
        startActivity(goToWelcomePage);
    }

    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }

        };
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (mAuthListener != null) {
//            mAuth.removeAuthStateListener(mAuthListener);
//        }
//    }
}


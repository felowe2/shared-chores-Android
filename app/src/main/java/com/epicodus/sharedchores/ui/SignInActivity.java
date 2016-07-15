package com.epicodus.sharedchores.ui;

import com.epicodus.sharedchores.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog mAuthProgressDialog;


    @Bind(R.id.logInHeader) TextView mLogInHeader;
    @Bind(R.id.emailSignIn) EditText mEmailSignIn;
    @Bind(R.id.passwordSignIn) EditText mPasswordSignIn;
    @Bind(R.id.signInButton) Button mSignInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);

//FONTS EVERYTHING
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mSignInButton.setTypeface(boldieFont);
        mLogInHeader.setTypeface(boldieFont);
// END OF FONTS

        mAuth = FirebaseAuth.getInstance();
        createAuthProgressDialog();
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(SignInActivity.this, UserChoreListActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };


        mSignInButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == mSignInButton) {
            loginWithPassword();
        }
    }
    private void loginWithPassword() {
           String emailSignIn = mEmailSignIn.getText().toString().trim();
            String passwordSignIn = mPasswordSignIn.getText().toString().trim();
        if (emailSignIn.equals("")) {
            mEmailSignIn.setError("Please enter your email");
            return;
        }
        if (passwordSignIn.equals("")) {
            mPasswordSignIn.setError("Password cannot be blank");
            return;
        }
            Intent goToUserPage = new Intent(this, UserChoreListActivity.class);
            goToUserPage.putExtra("email", emailSignIn);
            goToUserPage.putExtra("password", passwordSignIn);
            startActivity(goToUserPage);

        mAuth.signInWithEmailAndPassword(emailSignIn, passwordSignIn)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        mAuthProgressDialog.dismiss();
                        Log.d("TAG", "signInWithEmail:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Log.w("TAG", "signInWithEmail", task.getException());
                            Toast.makeText(SignInActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void createAuthProgressDialog() {
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading...");
        mAuthProgressDialog.setMessage("Authenticating...");
        mAuthProgressDialog.setCancelable(false);
    }
}
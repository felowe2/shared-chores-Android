package com.epicodus.sharedchores.ui;

import android.app.ProgressDialog;
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

import com.epicodus.sharedchores.Constants;
import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class  SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = SignUpActivity.class.getSimpleName();

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog mAuthProgressDialog;
    private String mUsername;

    @Bind(R.id.createAccountHeader)
    TextView mCreateAccountHeader;
    @Bind(R.id.usernameInput)
    EditText mUsernameInput;
    @Bind(R.id.emailInput)
    EditText mEmailInput;
    @Bind(R.id.choreDoerEditText)
    EditText mPasswordInput;
    @Bind(R.id.password2Input)
    EditText mPassword2Input;
    @Bind(R.id.createChoreButton)
    Button mSignUpButton;


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

        createAuthStateListener();
        createAuthProgressDialog();

        mAuth = FirebaseAuth.getInstance();

        mSignUpButton.setOnClickListener(this);
    }

    private void createAuthProgressDialog() {
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading...");
        mAuthProgressDialog.setMessage("Authenticating...");
        mAuthProgressDialog.setCancelable(false);
    }


    @Override
    public void onClick(View v) {
        if (v == mSignUpButton) {

            createNewUser();
        }
    }

    private void createNewUser() {
        mUsername = mUsernameInput.getText().toString().trim();
        String email = mEmailInput.getText().toString().trim();
        String password = mPasswordInput.getText().toString().trim();
        String password2 = mPassword2Input.getText().toString().trim();

        boolean validEmail = isValidEmail(email);
        boolean validName = isValidName(mUsername);
        boolean validPassword = isValidPassword(password, password2);
        if (!validEmail || !validName || !validPassword) return;

        mAuthProgressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                mAuthProgressDialog.dismiss();

                if (task.isSuccessful()) {
                    Log.d(TAG, "Authentication successful");

                    createFirebaseUserProfile(task.getResult().getUser());

                } else {
                    Toast.makeText(SignUpActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        Intent intent = new Intent(SignUpActivity.this, WelcomePageActivity.class);
//        intent.putExtra("userName", mUsername);
//        startActivity(intent);
//
//        Intent intent = new Intent(SignUpActivity.this, WelcomePageActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        intent.putExtra("username", Parcels.wrap(mUsername));
//        startActivity(intent);
//        //finish();
    }

    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
//
////THIS CREATE A USER AND IT'S UNIQUE ID AND PUSH IT TO "USERS" NODE IN DATABASE'
//                    String uid = firebaseUser.getUid();
//                    User user = new User(firebaseUser.getDisplayName(), firebaseUser.getEmail());
//                    DatabaseReference ref = FirebaseDatabase
//                            .getInstance()
//                            .getReference(Constants.FIREBASE_CHILD_FRIENDS)
//                            .child(uid);
//                    ref.setValue(user);
//
//                    Intent intent = new Intent(SignUpActivity.this, WelcomePageActivity.class);
//                    intent.putExtra("userName", mUsername);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                    finish();
//                }
                }

            }

            ;
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

    private boolean isValidEmail(String email) {
        boolean isGoodEmail =
                (email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail) {
            mEmailInput.setError("Please enter a valid email address");
            return false;
        }
        return isGoodEmail;
    }

    private boolean isValidName(String name) {
        if (name.equals("")) {
            mUsernameInput.setError("Please enter your name");
            return false;
        }
        return true;
    }

    private boolean isValidPassword(String password, String confirmPassword) {
        if (password.length() < 6) {
            mPasswordInput.setError("Please create a password containing at least 6 characters");
            return false;
        } else if (!password.equals(confirmPassword)) {
            mPassword2Input.setError("Passwords do not match");
            return false;
        }
        return true;
    }

    private void createFirebaseUserProfile(final FirebaseUser user) {

        UserProfileChangeRequest addProfileName = new UserProfileChangeRequest.Builder()
                .setDisplayName(mUsername)
                .build();

        user.updateProfile(addProfileName)
                .addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("TAG", user.getDisplayName() + " ");
                        }
                    }

                });
    }
}




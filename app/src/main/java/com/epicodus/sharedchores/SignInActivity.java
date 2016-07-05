package com.epicodus.sharedchores;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

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
//    LOG IN WITH FACEBOOK
//    private CallbackManager callbackManager;
//    private TextView logInWithFacebookTextView;
//
//    private AccessTokenTracker accessTokenTracker;
//    private ProfileTracker profileTracker;
//
//    private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
//        @Override
//        public void onSuccess(LoginResult loginResult) {
//            AccessToken accessToken = loginResult.getAccessToken();
//            Profile profile = Profile.getCurrentProfile();
//            displayMessage(profile);
//        }
//
//        @Override
//        public void onCancel() {
//
//        }
//
//        @Override
//        public void onError(FacebookException e) {
//
//        }
//    };
//
//    public SignInActivity() {
//
//    }

//   LOG IN WITH FACEBOOK END

    @Bind(R.id.emailSignIn) EditText mEmailSignIn;
    @Bind(R.id.passwordSignIn) EditText mPasswordSignIn;
    @Bind(R.id.signInButton) Button mSignInButton;
    @Bind(R.id.logInWithFacebookTextView) TextView mLogInWithFacebookTextView;
    @Bind(R.id.facebookLoginButton) Button mFacebookLoginButton;


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

// END OF FONTS

        mSignInButton.setOnClickListener(this);

//MORE LOGIN WITH FACEBOOK STUFF
//        callbackManager = CallbackManager.Factory.create();
//
//        accessTokenTracker = new AccessTokenTracker() {
//            @Override
//            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
//
//            }
//        };
//
//        profileTracker = new ProfileTracker() {
//            @Override
//            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
//                displayMessage(newProfile);
//            }
//        };
//
//        accessTokenTracker.startTracking();
//        profileTracker.startTracking();
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.activity_sign_in, container, false);
//    }
//
//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        LoginButton loginButton = (LoginButton) view.findViewById(R.id.facebookLoginButton);
//        mLogInWithFacebookTextView = (TextView) view.findViewById(R.id.logInWithFacebookTextView);
//
//        loginButton.setReadPermissions("user_friends");
//        loginButton.setFragment(this);
//        loginButton.registerCallback(callbackManager, callback);
//
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//
//    }
//
//    private void displayMessage(Profile profile) {
//        if (profile != null) {
//            mLogInWithFacebookTextView.setText(profile.getName());
//        }
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        accessTokenTracker.stopTracking();
//        profileTracker.stopTracking();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        Profile profile = Profile.getCurrentProfile();
//        displayMessage(profile);
//    }

        //   LOG IN WITH FACEBOOK END
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

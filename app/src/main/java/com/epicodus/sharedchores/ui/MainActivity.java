package com.epicodus.sharedchores.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.sharedchores.Constants;
import com.epicodus.sharedchores.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.sharedChoresTitle) TextView mSharedChoresTitle;
    @Bind(R.id.sharedHappinessTitle) TextView mSharedHappinessTitle;
    @Bind(R.id.signInButton) Button mSignInButton;
    @Bind(R.id.createChoreButton) Button mSignUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//FONTS EVERYTHING
//        mSharedChoresTitle = (TextView) findViewById(R.id.welcome);
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mSharedChoresTitle.setTypeface(boldieFont);
        mSharedHappinessTitle.setTypeface(boldieFont);
        mSignUpButton.setTypeface(boldieFont);
        mSignInButton.setTypeface(boldieFont);
// END OF FONTS

        mSignUpButton.setOnClickListener(this);
        mSignInButton.setOnClickListener(this);

//        ValueEventListener mListener =
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("0", "this is a test chore!");
//        map.put("1", "this is another chor!@");
////
////        List<String> map = new ArrayList<String>();
////        map.add("thing 1");
////        map.add("thing 2");
//
//
//        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_FRIENDS).child(uid).child("choreList").push();
//        ref.updateChildren(map);

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

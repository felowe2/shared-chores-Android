package com.epicodus.sharedchores.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.sharedchores.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SuccessPageActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mSuccessMessageTextView;

//    @Bind(R.id.successMessageTextView) TextView mSuccessMessageTextView;
    @Bind(R.id.addMorePeopleButton) Button mAddMorePeopleButton;
    @Bind(R.id.backToUserChoreListButton) Button mBackToUserChoreListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_page);
        mSuccessMessageTextView = (TextView) findViewById(R.id.userChoreListHeader);
        Intent intent = getIntent();
        String choreDoer = intent.getStringExtra("doer_name");
        Log.v("TEST", choreDoer + "");
        mSuccessMessageTextView.setText("Congratulations! Chore has been successfully added to " + choreDoer + "'s chore list!");

        ButterKnife.bind(this);

//        Typeface blazedFont = Typeface.createFromAsset(getAssets(), "fonts/Blazed.ttf");


        mAddMorePeopleButton.setOnClickListener(this);
        mBackToUserChoreListButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mAddMorePeopleButton) {
            Intent goToAssignChoreActivity = new Intent(SuccessPageActivity.this, AssignChoreActivity.class);
            startActivity(goToAssignChoreActivity);
        }
        if (v == mBackToUserChoreListButton) {
            Intent goToUserPageActivity = new Intent(SuccessPageActivity.this, UserChoreListActivity.class);
            startActivity(goToUserPageActivity);
        }
    }
}

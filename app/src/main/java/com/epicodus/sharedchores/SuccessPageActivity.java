package com.epicodus.sharedchores;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SuccessPageActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.SucessMessageTextView)
    TextView mSuccessMessageTextView;
    @Bind(R.id.addMorePeopleButton)
    Button mAddMorePeopleButton;
    @Bind(R.id.backToUserChoreListButton)
    Button mBackToUserChoreListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_page);

        ButterKnife.bind(this);

        Typeface blazedFont = Typeface.createFromAsset(getAssets(), "fonts/Blazed.ttf");


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

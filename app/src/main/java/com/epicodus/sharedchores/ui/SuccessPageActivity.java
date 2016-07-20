package com.epicodus.sharedchores.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.Chore;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SuccessPageActivity extends AppCompatActivity implements View.OnClickListener {

    private Chore mChore;

    @Bind(R.id.successMessageTextView) TextView mSuccessMessageTextView;
    @Bind(R.id.createAnotherChoreButton) Button mCreateAnotherChoreButton;
    @Bind(R.id.backToUserChoreListButton) Button mBackToUserChoreListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_page);
        ButterKnife.bind(this);

//        Typeface blazedFont = Typeface.createFromAsset(getAssets(), "fonts/Blazed.ttf");



        mChore = Parcels.unwrap(getIntent().getParcelableExtra("chore"));
        String choreDoer = mChore.getDoer();
        mSuccessMessageTextView.setText("Congratulations! Chore has been successfully added to " + choreDoer + "'s chore list!");


        mCreateAnotherChoreButton.setOnClickListener(this);
        mBackToUserChoreListButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == mCreateAnotherChoreButton) {
            Intent intent = new Intent(SuccessPageActivity.this, AssignChoreActivity.class);
            startActivity(intent);
        }
        if (v == mBackToUserChoreListButton) {
            Intent intent = new Intent(SuccessPageActivity.this, UserChoreListActivity.class);
            startActivity(intent);
        }
    }
}

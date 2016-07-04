package com.epicodus.sharedchores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddFriendsActivity extends AppCompatActivity {
    @Bind(R.id.addFriendsTextView) TextView mFriendsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friends);

        ButterKnife.bind(this);

        Intent showHeader = getIntent();
        String groupName = showHeader.getStringExtra("groupNameInput");
        mFriendsTextView.setText("Now let's add some people to " + groupName);
    }

}

package com.epicodus.sharedchores;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserPageActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.createGroupButton) Button mCreateGroupButton;
    @Bind(R.id.groupName)
    EditText mGroupName;
    @Bind(R.id.saveGroupButton)
    Button mSaveGroupButton;
    @Bind(R.id.groupListView)
    ListView mGroupListView;
    private String[] groups = new String[]{"Group 1", "Group 2"};
    @Bind(R.id.clickableGroupName) Button mClickableGroupName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        ButterKnife.bind(this);

//FONTS EVERYTHING
        mCreateGroupButton = (Button) findViewById(R.id.createGroupButton);
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mCreateGroupButton.setTypeface(boldieFont);
// END OF FONTS

        mCreateGroupButton.setOnClickListener(this);
        mSaveGroupButton.setOnClickListener(this);

        mGroupName.setVisibility(View.GONE);
        mSaveGroupButton.setVisibility(View.GONE);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, groups);
        mGroupListView.setAdapter(adapter);

        mClickableGroupName.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        mGroupName.setVisibility(View.VISIBLE);
        mSaveGroupButton.setVisibility(View.VISIBLE);

        if (v == mCreateGroupButton) {
            String groupNameInput = mGroupName.getText().toString();
//            mGroupListView.setText("groupNameInput");

//            WANT TO SHOW THE GROUP NAME/USER INPUT IN THIS ACTIVITY

            Intent goToAddFriendsPage = new Intent(this, AddFriendsActivity.class);
            goToAddFriendsPage.putExtra("groupName", groupNameInput);
            startActivity(goToAddFriendsPage);
//
//

        } if (v == mSaveGroupButton) {


        } if (v == mClickableGroupName){



        }
    }
}

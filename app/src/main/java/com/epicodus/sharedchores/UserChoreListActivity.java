package com.epicodus.sharedchores;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserChoreListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_chore_list);
    }


    ArrayList<String> groupList = new ArrayList<String>();

    @Bind(R.id.bottomBar)
    TextView mButtomBar;
    @Bind(R.id.createGroupHeader)
    TextView mCreateGroupHeader;
    @Bind(R.id.createGroupButton)
    Button mCreateGroupButton;
    @Bind(R.id.groupHeader)
    TextView mGroupHeader;
    @Bind(R.id.groupListView)
    ListView mGroupListView;
    @Bind(R.id.groupNameInputField)
    EditText mGroupNameInputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        ButterKnife.bind(this);


//FONTS EVERYTHING
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mCreateGroupHeader.setTypeface(boldieFont);
        mCreateGroupButton.setTypeface(boldieFont);
        mGroupHeader.setTypeface(boldieFont);
// END OF FONTS


        mCreateGroupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String groupInput = mGroupNameInputField.getText().toString();

                if (groupList.contains(groupInput)) {
                    Toast.makeText(getBaseContext(), "Group name already exist", Toast.LENGTH_LONG).show();
                } else if (groupInput == null || groupInput.trim().equals(" ")) {
                    Toast.makeText(getBaseContext(), "Input field is empty", Toast.LENGTH_LONG).show();
                } else {
                    groupList.add(groupInput);

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateGroupActivity.this, android.R.layout.simple_list_item_1, groupList);
                    mGroupListView.setAdapter(adapter);
                }
            }

            // TODO: 7/9/16 this does not work. Click on item won't take user to AddPeopleActivity (where people are added to the group name clicked on)
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String groupInput = ((TextView) view).getText().toString();
                Intent intent = new Intent(CreateGroupActivity.this, AddPeopleActivity.class);
                startActivity(intent);
            }

        });

    }
}
}

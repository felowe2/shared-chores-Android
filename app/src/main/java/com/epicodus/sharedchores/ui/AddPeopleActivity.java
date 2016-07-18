package com.epicodus.sharedchores.ui;

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

import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.Group;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddPeopleActivity extends AppCompatActivity {
    ArrayList<String> listOfPeopleAddedToGroup = new ArrayList<String>();
    private Group group;

    @Bind(R.id.addPeopleHeader) TextView mAddPeopleHeader;
    @Bind(R.id.addPersonNameInputField) EditText mAddPersonNameInputField;
    @Bind(R.id.addPersonButton) Button mAddPersonButton;
    @Bind(R.id.peopleAddedHeader) TextView mPeopleAddedHeader;
    @Bind(R.id.peopleAddedListView) ListView mPeopleAddedListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_people);
        ButterKnife.bind(this);

//        Intent intent = getIntent();
//        String groupName = intent.getStringExtra("groupName");
//        mAddPeopleHeader.setText("Add people to " + groupName +"'s group");

        group = Parcels.unwrap(getIntent().getParcelableExtra("group"));
        String groupName = group.getName();
        mAddPeopleHeader.setText("Add people to " + groupName +"'s group");


//FONTS EVERYTHING
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mAddPeopleHeader.setTypeface(boldieFont);
        mAddPersonButton.setTypeface(boldieFont);
        mPeopleAddedHeader.setTypeface(boldieFont);
// END OF FONTS


        mAddPersonButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String personNameInput = mAddPersonNameInputField.getText().toString();
//                    Intent intent = new Intent(UserPageActivity.this, ChoresActivity.class);
//                    intent.putExtra("group_name", groupInput);
//                    startActivity(intent);

                if (listOfPeopleAddedToGroup.contains(personNameInput)) {
                    Toast.makeText(getBaseContext(), "This person has already been added", Toast.LENGTH_LONG).show();
                } else if (personNameInput == null || personNameInput.trim().equals(" ")) {
                    Toast.makeText(getBaseContext(), "Input field is empty", Toast.LENGTH_LONG).show();
                } else {
                    listOfPeopleAddedToGroup.add(personNameInput);

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddPeopleActivity.this, android.R.layout.simple_list_item_1, listOfPeopleAddedToGroup);
                    mPeopleAddedListView.setAdapter(adapter);
                }
            }

        });

        mPeopleAddedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AddPeopleActivity.this, AssignChoreActivity.class);
                startActivity(intent);
            }
        });

    }
}


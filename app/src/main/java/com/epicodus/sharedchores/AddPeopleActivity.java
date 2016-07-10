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

public class AddPeopleActivity extends AppCompatActivity {
    ArrayList<String> listOfPeopleAddedToGroup = new ArrayList<String>();

    @Bind(R.id.addPeopleHeader)
    TextView mAddPeopleHeader;
    @Bind(R.id.addPersonNameInputField)
    EditText mAddPersonNameInputField;
    @Bind(R.id.addPersonButton)
    Button mAddPersonButton;
    @Bind(R.id.peopleAddedHeader)
    TextView mPeopleAddedHeader;
    @Bind(R.id.peopleAddedListView)
    ListView mPeopleAddedListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_people);


        ButterKnife.bind(this);


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

            // TODO: 7/9/16 this does not work. Click on item won't take user to ChoresActivity :(
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String groupInput = ((TextView) view).getText().toString();
                Intent intent = new Intent(AddPeopleActivity.this, ChoresActivity.class);
                startActivity(intent);
            }

        });

    }
}


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

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChoresActivity extends AppCompatActivity {
    private ListView mChoreListView;
    @Bind(R.id.createChoreHeader) TextView mCreateChoreHeader;
    @Bind(R.id.groupNameInputField) EditText mChoreInputField;
    @Bind(R.id.createChoreButton) Button mCreateChoreButton;
    @Bind(R.id.choreHeader) TextView mChoreHeader;


    private String[] chores = new String[]{"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chores);


        ButterKnife.bind(this);

        mChoreListView = (ListView) findViewById(R.id.groupListView);

//FONTS EVERYTHING

        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mCreateChoreHeader.setTypeface(boldieFont);
        mCreateChoreButton.setTypeface(boldieFont);
        mChoreHeader.setTypeface(boldieFont);
// END OF FONTS


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chores);
        mChoreListView.setAdapter(adapter);

        mChoreListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String chore = ((TextView) view).getText().toString();
                Intent intent = new Intent(ChoresActivity.this, AddFriendsActivity.class);
                startActivity(intent);

            }

        });

    }
}


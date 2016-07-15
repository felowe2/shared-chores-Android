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

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class UserChoreListActivity extends AppCompatActivity {

    ArrayList<String> userChoreList = new ArrayList<String>();

    @Bind(R.id.userChoreListHeader)
    TextView mUserChoreListHeader;
    @Bind(R.id.userChoreListListView)
    ListView mUserChoreListListView;
    @Bind(R.id.userChoreListCreateChoreButton)
    Button mUserChoreListCreateChoreButton;

    private String[] userChores = new String[]{"Sweet Hereafter", "Cricket", "Hawthorne Fish House", "Viking Soul Food",
            "Red Square", "Horse Brass", "Dick's Kitchen", "Taco Bell", "Me Kha Noodle Bar"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_chore_list);

        ButterKnife.bind(this);

//
////////FONTS EVERYTHING
//////        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
//////        mCreateGroupHeader.setTypeface(boldieFont);
//////        mCreateGroupButton.setTypeface(boldieFont);
//////        mGroupHeader.setTypeface(boldieFont);
//////// END OF FONTS
//
//
        mUserChoreListCreateChoreButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserChoreListActivity.this, CreateGroupActivity.class);
                startActivity(intent);


            }

        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(UserChoreListActivity.this, android.R.layout.simple_list_item_1, userChores);
        mUserChoreListListView.setAdapter(adapter);

        mUserChoreListListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(UserChoreListActivity.this, UserChoreDetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
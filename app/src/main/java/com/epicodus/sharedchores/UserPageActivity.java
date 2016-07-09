//package com.epicodus.sharedchores;
//
//import android.content.Intent;
//import android.graphics.Typeface;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//
//public class UserPageActivity extends AppCompatActivity {
//    private  ListView mGroupListView;
//    @Bind(R.id.createChoreHeader)
//    TextView mCreateGroupHeader;
//    @Bind(R.id.choreInputField)
//    EditText mGroupNameInputField;
//    @Bind(R.id.createGroupButton)
//    Button mCreateGroupButton;
//    @Bind(R.id.groupHeader)
//    TextView mGroupHeader;
//
//
//    private String[] groups = new String[]{"Mi Mero Mole", "Mother's Bistro",
//            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
//            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
//            "Lardo", "Portland City Grill", "Fat Head's Brewery",
//            "Chipotle", "Subway"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_page);
//
//
//        ButterKnife.bind(this);
//
//        mGroupListView = (ListView) findViewById(R.id.groupListView);
//
////FONTS EVERYTHING
//
//        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
//        mCreateGroupHeader.setTypeface(boldieFont);
//        mCreateGroupButton.setTypeface(boldieFont);
//        mGroupHeader.setTypeface(boldieFont);
//// END OF FONTS
//
//
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, groups);
//        mGroupListView.setAdapter(adapter);
//
//        mGroupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String groupName = ((TextView) view).getText().toString();
//                Intent intent = new Intent(UserPageActivity.this, ChoresActivity.class);
//                startActivity(intent);
//
//            }
//
//        });
//
//    }
//}


package com.epicodus.sharedchores;

        import android.content.Intent;
        import android.graphics.Typeface;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.TextView;

        import com.epicodus.sharedchores.adapters.GroupListAdapter;

        import java.security.acl.Group;
        import java.util.ArrayList;

        import butterknife.Bind;
        import butterknife.ButterKnife;

public class UserPageActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    private GroupListAdapter mAdapter;

    public ArrayList<Group> mGroups = new ArrayList<>();

    public String[] myGroups;

    private TextView mGroupListView;
    @Bind(R.id.createChoreHeader)
    TextView mCreateGroupHeader;
    @Bind(R.id.groupNameInputField)
    EditText mGroupNameInputField;
    @Bind(R.id.createGroupButton)
    Button mCreateGroupButton;
    @Bind(R.id.groupHeader)
    TextView mGroupHeader;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

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

                String groupName = mGroupNameInputField.getText().toString();
                Intent intent = getIntent();
                String group = intent.getStringExtra(groupName);
                myGroups.setTex(group);



        UserPageActivity.this.runOnUiThread(new Runnable() {

            public void run() {

                mAdapter adapter = new GroupListAdapter(getApplicationContext(), mGroups);
                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(UserPageActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);
            }
        });
    }

    }

//
//        public class UserPageActivity extends AppCompatActivity {
////
//            @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
////
////            private GroupListAdapter mAdapter;
//
//            public ArrayList<Group> mGroups;
//
////            public String[] myGroups;
////
//            private TextView mGroupListView;
//            @Bind(R.id.createChoreHeader)
//            TextView mCreateGroupHeader;
//            @Bind(R.id.groupNameInputField)
//            EditText mGroupNameInputField;
//            @Bind(R.id.createGroupButton)
//            Button mCreateGroupButton;
//            @Bind(R.id.groupHeader)
//            TextView mGroupHeader;
////
//
//
//            @Override
//            protected void onCreate(Bundle savedInstanceState) {
//                super.onCreate(savedInstanceState);
//                setContentView(R.layout.activity_user_page);
//
//                ButterKnife.bind(this);
//
////FONTS EVERYTHING
//                Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
//                mCreateGroupHeader.setTypeface(boldieFont);
//                mCreateGroupButton.setTypeface(boldieFont);
//                mGroupHeader.setTypeface(boldieFont);
//// END OF FONTS
//
//                RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//
//
//                // Initialize contacts
//                mGroups.addAll(Group.create(5));
//                // Create adapter passing in the sample user data
//                GroupListAdapter adapter = new GroupListAdapter(this, mGroups);
//                // Attach the adapter to the recyclerview to populate items
//                myRecyclerView.setAdapter(adapter);
//                // Set layout manager to position the items
//                myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//                // That's all!
//
//
//
//                mCreateGroupButton.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//
//                        String groupName = mGroupNameInputField.getText().toString();
//                        mGroups.add(groupName);
//
//                        Intent intent = getIntent();
//
//                        String group = intent.getStringExtra(groupName);
//
//
//
//                        UserPageActivity.this.runOnUiThread(new Runnable() {
//
//                            public void run() {
//
//                                mAdapter adapter = new GroupListAdapter(getApplicationContext(), mGroups);
//                                mRecyclerView.setAdapter(mAdapter);
//                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(UserPageActivity.this);
//                                mRecyclerView.setLayoutManager(layoutManager);
//                                mRecyclerView.setHasFixedSize(true);
//                            }
//                        });
//                    }
//
//                }
//


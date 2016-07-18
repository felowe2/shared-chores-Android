package com.epicodus.sharedchores.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.sharedchores.Constants;
import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.Group;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CreateGroupActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;
    private Group group;
    View mView;
    Context mContext;


    //    @Bind(R.id.bottomBar)
//    TextView mButtomBar;
    @Bind(R.id.createGroupHeader) TextView mCreateGroupHeader;
    @Bind(R.id.createGroupButton) Button mCreateGroupButton;
    @Bind(R.id.groupHeader) TextView mGroupHeader;
    @Bind(R.id.groupNameTextView) TextView mGroupNameTextView;
    @Bind(R.id.groupNameEditText) EditText mGroupNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_GROUPS);
        mDatabaseReference.addValueEventListener(groupListener);


//FONTS EVERYTHING
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mCreateGroupHeader.setTypeface(boldieFont);
        mCreateGroupButton.setTypeface(boldieFont);
        mGroupHeader.setTypeface(boldieFont);
// END OF FONTS
        mCreateGroupButton.setOnClickListener(this);
        mGroupNameTextView.setOnClickListener(this);


    }

    ValueEventListener groupListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                group = snapshot.getValue(Group.class);

            }
            mGroupNameTextView.setText(group.getName());

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }

    };

    @Override
    public void onClick(View view) {
        if (view == mCreateGroupButton) {
            createNewGroup();

// TODO: 7/18/16 Intent: Click on the group name and go to the nest page, as well as pass groupName by getIntnet().  
       } if (view == mGroupNameTextView){
            Intent intent = new Intent(CreateGroupActivity.this, AddPeopleActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra("group", Parcels.wrap(group));
            startActivity(intent);
            finish();

//            Intent intent = new Intent(CreateGroupActivity.this, AddPeopleActivity.class);
//           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//           intent.putExtra("groupName", group.getName());
//           startActivity(intent);
//            finish();
        }
    }

    private void createNewGroup() {
       String groupName = mGroupNameEditText.getText().toString();
        Group newGroup = new Group(groupName);
        DatabaseReference groupRef = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_GROUPS)
                .push();
        String pushId = groupRef.getKey();
        newGroup.setPushId(pushId);
        groupRef.setValue(newGroup);
    }


}
